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
@SuppressWarnings("Duplicates")
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
        model.addAttribute("pn_code_rule_desc", Arrays.asList(
                "产品系列&分类",
                "投影：亮度标识\n" + "幕布：尺寸\n" + "支架：高度",
                "投影：分辨率\n" + "幕布：材质\n" + "支架：0，保留",
                "品牌",
                "销售区域",
                "渠道"));
        model.addAttribute("sku_code_rule", codeService.queryCodeRule("SKU"));
        model.addAttribute("sku_code_rule_desc", Arrays.asList(
                "产品品牌",
                "产品名称",
                "年份",
                "渠道",
                "衍生",
                "尺寸",
                "颜色",
                "销售国别"));
        model.addAttribute("mn_code_rule", codeService.queryCodeRule("MN"));
        model.addAttribute("pid_code_rule", codeService.queryCodeRule("PID"));
        model.addAttribute("pid_code_rule_desc", Arrays.asList(
                "立项年份",
                "产品线",
                "按照立项时间进行编号，从“1”计数"));
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

    @RequestMapping("/toCodeRule")
    public String toCodeRule(Model model) {
        model.addAttribute("pid_code_rule", codeService.queryCodeRule("PID"));
        model.addAttribute("pid_code_rule_desc", Arrays.asList(
                "立项年份",
                "产品线",
                "按照立项时间进行编号，从“1”计数"));
        model.addAttribute("pn_code_rule", codeService.queryCodeRule("PN"));
        model.addAttribute("pn_code_rule_desc", Arrays.asList(
                "产品系列&分类",
                "投影：亮度标识\n" + "幕布：尺寸\n" + "支架：高度",
                "投影：分辨率\n" + "幕布：材质\n" + "支架：0，保留",
                "品牌",
                "销售区域",
                "渠道"));
        model.addAttribute("sku_code_rule", codeService.queryCodeRule("SKU"));
        model.addAttribute("sku_code_rule_desc", Arrays.asList(
                "产品品牌",
                "产品名称",
                "年份",
                "渠道",
                "衍生",
                "尺寸",
                "颜色",
                "销售国别"));
        return "code_rule";
    }

    @RequestMapping(value = "/toCodeRuleAdd")
    public String toCodeRuleAdd(Model model, String type, int index) {
        CodeRule cr = new CodeRule();
        int codeLen = codeService.queryCodeRule(type).get(index).get(0).getCodeLength();
        int codeType = codeService.queryCodeRule(type).get(index).get(0).getCodeType();
        cr.setCode_rule_index(index);
        cr.setCode_rule_len(codeLen);
        cr.setCode_rule_type(codeType);

        System.out.println("type=" + codeType + ",index=" + index + ", code len is " + codeLen);
        model.addAttribute("code_rule_instance", cr);
        model.addAttribute("codeType", type);

        Map<String, List<String>> codeDesc = new HashMap<>();

        codeDesc.put("PID", Arrays.asList(
                "立项年份",
                "产品线",
                "按照立项时间进行编号，从“1”计数"));
        codeDesc.put("PN", Arrays.asList(
                "产品系列&分类",
                "投影：亮度标识\n" + "幕布：尺寸\n" + "支架：高度",
                "投影：分辨率\n" + "幕布：材质\n" + "支架：0，保留",
                "品牌",
                "销售区域",
                "渠道"));
        codeDesc.put("SKU", Arrays.asList(
                "产品品牌",
                "产品名称",
                "年份",
                "渠道",
                "衍生",
                "尺寸",
                "颜色",
                "销售国别"));
        model.addAttribute("codeDesc", codeDesc.get(type));

        Map<Integer, List<CodeMap>> codeData = codeService.queryCodeRule(type);
        model.addAttribute("codeDataList", codeData.get(index));
        return "code_rule_add";
    }

    @RequestMapping(value = "/addCodeRule", method = RequestMethod.POST)
    public String addCodeRule(CodeRule cr) {
        System.out.println(cr.toString());
        codeService.insertCodeRule(cr);
        return "redirect:toCodeRule";
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
