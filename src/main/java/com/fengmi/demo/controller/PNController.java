package com.fengmi.demo.controller;

import com.fengmi.demo.model.*;
import com.fengmi.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * @author lijie
 * @create 2019-09-17 15:01
 **/
@Controller
public class PNController {
    @Autowired
    private PNService pnService;
    @Autowired
    private CodeRuleService codeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PIDService pidService;
    @Autowired
    private SKUService skuService;

    @RequestMapping("/showAllPN")
    public String showAllPN(Model model) {
        List<PN> pn_list = pnService.getAllPN();
        model.addAttribute("pn_list", pn_list);

        for (PN pn : pn_list) {
            Product p = productService.findProductByID(pn.getPn_product_info());
            pn.setProduct(p);

            System.out.println("--  query all PN  --" + pn);
        }
        return "pn";
    }

    @RequestMapping("/toPNAdd")
    public String toPNAdd(Model model) {
        model.addAttribute("code_rule", codeService.queryCodeRule("PN"));
        model.addAttribute("pn", new PN());
        return "pn_add";
    }

    @RequestMapping(value = "/addPN", method = RequestMethod.POST)
    public String addPN(ProductForm pf) {
        //pnService.insertPN(pn);
        insertProduct(pf);

        return "redirect:showAllPN";
    }

    @RequestMapping(value = "/toCreateNew")
    public String toCreateNew(Model model) {
        model.addAttribute("pn_code_rule", codeService.queryCodeRule("PN"));
        model.addAttribute("sku_code_rule", codeService.queryCodeRule("SKU"));
        model.addAttribute("mn_code_rule", codeService.queryCodeRule("MN"));
        model.addAttribute("pid_code_rule", codeService.queryCodeRule("PID"));
        model.addAttribute("brand_list", productService.findAllBrand());
        model.addAttribute("color_list", productService.findAllColor());
        model.addAttribute("form_product", new ProductForm());
        return "product_form";
    }

    @RequestMapping("/deletePN")
    public String deletePN(int id) {
        PN pn = pnService.getPNByID(id);
        if (pn != null) {
            productService.deleteProductByID(pn.getPn_product_info());
            pnService.deletePNByID(pn.getPn_id());
            return "redirect:showAllPN";
        }
        return "error";
    }

    private boolean insertProduct(ProductForm productForm) {
        SKU sku = productForm.getSku();
        PID pid = productForm.getPid();
        PN pn = productForm.getPn();
        ProductDetail product_detail = productForm.getProduct_detail();
        Product product = productForm.getProduct();

        if (product_detail != null && product_detail.getDetail_color() != null) {
            //填充细节表内的 PN
            product_detail.setDetail_pn(pn.getPn_data());
            productService.insertProductDetail(product_detail);
            if (product_detail.getDetail_id() == null) {
                System.out.println("detail insert error");
                return false;
            }
        } else {
            System.out.println("detail or color data is null !!");
            return false;
        }
        //关联 detail ID
        product.setInfo_detail(product_detail.getDetail_id());


        String pid_data = pid.getPid_data();
        if (pid_data != null && pid_data.trim().length() != 0) {
            pidService.insertPID(pid);
            if (pid.getPid_id() == null) {
                System.out.println("pid insert error");
                return false;
            }
        } else {
            System.out.println("pid or pid data is null !!");
            return false;
        }
        // 关联 PID id
        product.setProduct_pid(pid.getPid_id());

        String sku_data = sku.getSku_data();
        if (sku_data != null && sku_data.trim().length() != 0) {
            skuService.insertSKU(sku);
            if (sku.getSku_id() == null) {
                System.out.println("sku insert error");
                return false;
            }
        } else {
            System.out.println("sku or sku data is null");
            return false;
        }
        // 关联 sku id
        product.setProduct_sku(sku.getSku_id());
        productService.insertProduct(product);
        System.out.println("---insert Product--- : " + product);

        if (product.getProduct_id() != null) {
            pn.setPn_product_info(product.getProduct_id());

            pnService.insertPN(pn);
            System.out.println("---insert PN--- : " + pn);
            return true;
        } else {
            System.out.println("---insert PN Failed---");
            return false;
        }

    }
}
