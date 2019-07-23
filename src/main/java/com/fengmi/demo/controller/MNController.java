package com.fengmi.demo.controller;

import com.fengmi.demo.model.MN;
import com.fengmi.demo.model.Product;
import com.fengmi.demo.service.CodeRuleService;
import com.fengmi.demo.service.MNService;
import com.fengmi.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author lijie
 * @create 2019-06-25 13:25
 **/
@Controller()
public class MNController {
    @Autowired
    private MNService mnService;
    @Autowired
    private CodeRuleService codeService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/getAllMN")
    public String getAllMN(Model model) {
        model.addAttribute("mn_list", mnService.getAllMN());
        List<Product> list = productService.getAllProduct();

        for (Product product : list) {
            System.out.println(product.toString());
        }
        return "mn";
    }

    @RequestMapping("/toMNEdit")
    public String toMNEdit(Model model, @RequestParam int id) {
        List<MN> list = mnService.queryMNByID(id);
        if (list.size() == 1) {
            model.addAttribute("mn", list.get(0));
            return "mn_edit";
        }
        return "error";
    }

    @RequestMapping(value = "/mnEdit", method = RequestMethod.POST)
    public String mnEdit(MN mn) {
        mnService.updateMN(mn);
        return "redirect:getAllMN";
    }

    @RequestMapping("/toMNDelete")
    public String toMNDelete(int id) {
        List<MN> list = mnService.queryMNByID(id);
        if (list.size() == 1) {
            mnService.deleteMN(id);
            return "redirect:getAllMN";
        }
        return "error";
    }

    @RequestMapping("/toMNAdd")
    public String toMNAdd(Model model) {
        model.addAttribute("mn", new MN());
        model.addAttribute("code_rule", codeService.queryCodeRule("MN"));
        return "mn_add";
    }

    @RequestMapping(value = "/mnAdd", method = RequestMethod.POST)
    public String mnAdd(MN mn) {
        mnService.insertMN(mn);
        return "redirect:getAllMN";
    }
}
