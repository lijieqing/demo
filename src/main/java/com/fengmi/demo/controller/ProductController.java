package com.fengmi.demo.controller;

import com.fengmi.demo.model.*;
import com.fengmi.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lijie
 * @create 2019-07-02 09:16
 **/
@Controller()
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CodeRuleService codeService;
    @Autowired
    private PIDService pidService;
    @Autowired
    private MNService mnService;
    @Autowired
    private SKUService skuService;

    private Product productData;

    @RequestMapping("/")
    public String logIn() {
        return "redirect:getAllProduct";
    }

    @RequestMapping("/getAllProduct")
    public String getAllProduct(Model model) {
        model.addAttribute("product_list", productService.getAllProduct());
        return "product";
    }

    @RequestMapping("/toProductPIDAdd")
    public String toProductPIDAdd(Model model) {
        productData = new Product();
        model.addAttribute("code_rule", codeService.queryCodeRule("PID"));
        model.addAttribute("pid", new PID());
        model.addAttribute("brand_list", productService.findAllBrand());
        return "pid_add";
    }

    @RequestMapping(value = "/toProductSKUAdd", method = RequestMethod.POST)
    public String toProductSKUAdd(Model model, PID pid) {
        if (productData == null) {
            return "redirect:toProductPIDAdd";
        }
        productData.setPid(pid);
        System.out.println(productData);
        model.addAttribute("code_rule", codeService.queryCodeRule("SKU"));
        model.addAttribute("sku", new SKU());
        return "sku_add";
    }

    @RequestMapping(value = "/toProductMNAdd", method = RequestMethod.POST)
    public String toProductMNAdd(Model model, SKU sku) {
        if (productData == null) {
            return "redirect:toProductPIDAdd";
        }
        productData.setSku(sku);
        System.out.println(productData);
        model.addAttribute("code_rule", codeService.queryCodeRule("MN"));
        model.addAttribute("mn", new MN());
        return "mn_add";
    }

    @RequestMapping(value = "/toProductDetail", method = RequestMethod.POST)
    public String toProductDetail(Model model, MN mn) {
        if (productData == null) {
            return "redirect:toProductPIDAdd";
        }
        productData.setMn(mn);
        System.out.println(productData);

        model.addAttribute("detail", new ProductDetail());
        model.addAttribute("product", productData);
        model.addAttribute("color_list", productService.findAllColor());
        return "product_detail";
    }

    @RequestMapping(value = "/addProductDetail", method = RequestMethod.POST)
    public String productDetailAdd(ProductDetail detail) {
        if (productData == null) {
            return "redirect:toProductPIDAdd";
        }
        productData.setPd(detail);
        System.out.println(productData);

        if (insertProduct(productData)) {
            return "redirect:getAllProduct";
        }
        return "error";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(int id) {
        productService.deleteProductByID(id);
        return "redirect:getAllProduct";
    }

    private boolean insertProduct(Product product) {
        SKU sku = product.getSku();
        PID pid = product.getPid();
        MN mn = product.getMn();
        ProductDetail detail = productData.getPd();
        if (detail != null && detail.getDetail_color() != null) {
            productService.insertProductDetail(detail);
            if (detail.getDetail_id() == null) {
                System.out.println("detail insert error");
                return false;
            }
        } else {
            return false;
        }
        String pid_data = pid.getPid_data();
        if (pid_data != null && pid_data.trim().length() != 0) {
            pidService.insertPID(pid);
            if (pid.getPid_id() == null) {
                System.out.println("pid insert error");
                return false;
            }
        } else {
            return false;
        }
        String sku_data = sku.getSku_data();
        if (sku_data != null && sku_data.trim().length() != 0) {
            skuService.insertSKU(sku);
            if (sku.getSku_id() == null) {
                System.out.println("sku insert error");
                return false;
            }
        } else {
            return false;
        }
        String mn_data = mn.getMn_data();
        if (mn_data != null && mn_data.trim().length() != 0) {
            mnService.insertMN(mn);
            if (mn.getMn_id() == null) {
                System.out.println("mn insert error");
                return false;
            }
        } else {
            return false;
        }

        product.setInfo_detail(detail.getDetail_id());
        product.setProduct_sku(sku.getSku_id());
        product.setProduct_pid(pid.getPid_id());
        product.setProduct_mn(mn.getMn_id());
        product.setInfo_detail(detail.getDetail_id());
        product.setProduct_color(detail.getDetail_color());

        productService.insertProduct(product);

        return true;
    }
}
