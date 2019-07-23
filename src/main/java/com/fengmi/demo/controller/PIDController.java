package com.fengmi.demo.controller;

import com.fengmi.demo.model.PID;
import com.fengmi.demo.service.CodeRuleService;
import com.fengmi.demo.service.PIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lijie
 * @create 2019-06-20 11:10
 **/
@Controller()
public class PIDController {
    @Autowired
    private PIDService pidService;
    @Autowired
    private CodeRuleService codeService;

    @RequestMapping("/getAllPID")
    public String getAllPIDs(Model model) {
        model.addAttribute("pid_list", pidService.getAllPIDs());
        return "pid";
    }

    @RequestMapping("/toPIDEdit")
    public String toEdit(Model model, @RequestParam Integer id) {
        System.out.println("toEdit----------" + id);
        List<PID> list = pidService.queryPIDByID(id);
        if (list.size() == 1) {
            System.out.println(list.get(0).toString());
            model.addAttribute("pid", list.get(0));
            model.addAttribute("categoryList", pidService.getAllCategory());
            return "pid_edit";
        }
        return "error";
    }

    @RequestMapping(value = "/pidEdit", method = RequestMethod.POST)
    public String pidEdit(PID pid) {
        System.out.println(pid.toString());
        pidService.updatePID(pid);
        return "redirect:getAllPID";
    }

    @RequestMapping("/toPIDAdd")
    public String toPIDAdd(Model model) {
        model.addAttribute("code_rule", codeService.queryCodeRule("PID"));
        model.addAttribute("pid", new PID());
        return "pid_add";
    }

    @RequestMapping("/toPIDDelete")
    public String toPIDDelete(@RequestParam Integer id) {
        pidService.deletePID(id);
        return "redirect:getAllPID";
    }

    @RequestMapping(value = "/pidAdd", method = RequestMethod.POST)
    public String pidAdd(PID pid) {
        System.out.println(pid.toString());
        pidService.insertPID(pid);
        if (pid.getPid_id() == null) {
            return "error";
        }
        return "redirect:getAllPID";
    }
}
