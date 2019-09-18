package com.fengmi.demo.controller;

import com.fengmi.demo.model.PN;
import com.fengmi.demo.model.ProductForm;
import com.fengmi.demo.service.CodeRuleService;
import com.fengmi.demo.service.PNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/showAllPN")
    public String showAllPN(Model model) {
        model.addAttribute("pn_list", pnService.getAllPN());
        return "pn";
    }

    @RequestMapping("/toPNAdd")
    public String toPNAdd(Model model) {
        model.addAttribute("code_rule", codeService.queryCodeRule("PN"));
        model.addAttribute("pn", new PN());
        return "pn_add";
    }

    @RequestMapping(value = "/addPN", method = RequestMethod.POST)
    public String addPN(PN pn) {
        pnService.insertPN(pn);
        return "redirect:showAllPN";
    }

    @RequestMapping(value = "/toCreateNew")
    public String toCreateNew(Model model){
        model.addAttribute("pn_code_rule", codeService.queryCodeRule("PN"));
        model.addAttribute("sku_code_rule", codeService.queryCodeRule("SKU"));
        model.addAttribute("mn_code_rule", codeService.queryCodeRule("MN"));
        model.addAttribute("pid_code_rule", codeService.queryCodeRule("PID"));
        model.addAttribute("form_product", new ProductForm());
        return "product_form";
    }
}
