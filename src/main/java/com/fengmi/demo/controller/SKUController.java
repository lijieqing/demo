package com.fengmi.demo.controller;

import com.fengmi.demo.model.CodeMap;
import com.fengmi.demo.model.SKU;
import com.fengmi.demo.service.CodeRuleService;
import com.fengmi.demo.service.PIDService;
import com.fengmi.demo.service.SKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author lijie
 * @create 2019-06-19 15:37
 **/
@Controller()
public class SKUController {
    @Autowired
    private SKUService skuService;
    @Autowired
    private PIDService pidService;
    @Autowired
    private CodeRuleService codeService;

    @RequestMapping("/getAllSKU")
    public String getAllSKU(Model model) {
        skuService.getAllSKUs();
        model.addAttribute("sku_list", skuService.getAllSKUs());
        return "sku";
    }

    @RequestMapping("/querySKUByData")
    @ResponseBody
    public List<SKU> querySKUByData(@RequestParam String data) {
        return skuService.querySKUByData(data);
    }

    @RequestMapping("/querySKUByName")
    @ResponseBody
    public List<SKU> querySKUByName(@RequestParam String name) {
        return skuService.querySKUByName(name);
    }

    @RequestMapping(value = "/insertSKU", method = RequestMethod.POST)
    public String insertSKU(SKU sku) {
        System.out.println(sku.toString());
        skuService.insertSKU(sku);
        return "redirect:getAllSKU";
    }

    @RequestMapping("/updateSKU")
    public SKU updateSKU(String data, String name) {
        List<SKU> skuList = skuService.querySKUByData(data);
        if (skuList.size() != 1) {
            return null;
        }
        SKU sku = skuList.get(0);
        sku.setSku_name(name);
        return skuService.updateSKU(sku);
    }

    @RequestMapping("/deleteSKU")
    public String deleteSKU(@RequestParam Integer id) {
        skuService.deleteSKU(id);
        return "redirect:getAllSKU";
    }

    @RequestMapping("/toSKUEdit")
    public String toEdit(Model model, @RequestParam Integer id) {
        System.out.println("toEdit----------" + id);
        List<SKU> list = skuService.querySKUByID(id);
        if (list.size() == 1) {
            System.out.println(list.get(0).toString());
            model.addAttribute("sku", list.get(0));
            return "sku_edit";
        }
        return "error";
    }

    @RequestMapping(value = "/skuEdit", method = RequestMethod.POST)
    public String skuEdit(SKU sku) {
        System.out.println(sku.toString());
        skuService.updateSKU(sku);
        return "redirect:getAllSKU";
    }

    @RequestMapping(value = "/toSKUAdd")
    public String toSKUAdd(Model model) {
        Map<Integer, List<CodeMap>> maps = codeService.queryCodeRule("SKU");
        int num = maps.size();
        model.addAttribute("categoryNum", num);
        for (int i = 0; i < num; i++) {
            List<CodeMap> listMap = maps.get(i);
            model.addAttribute("code_list_" + i, listMap);
        }
        model.addAttribute("code_rule", maps);
        model.addAttribute("sku", new SKU());
        return "sku_add";
    }

}
