package com.fengmi.demo.service.impl;

import com.fengmi.demo.mapper.CodeRuleMapper;
import com.fengmi.demo.model.CodeMap;
import com.fengmi.demo.model.CodeRule;
import com.fengmi.demo.service.CodeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lijie
 * @create 2019-06-20 18:41
 **/
@Service
public class CodeRuleServiceImpl implements CodeRuleService {
    @Autowired
    private CodeRuleMapper codeRuleMapper;

    @Override
    public Map<Integer, List<CodeMap>> queryCodeRule(String codeType) {
        Map<Integer, List<CodeMap>> result = new HashMap<>();
        List<CodeRule> list = codeRuleMapper.queryCodeRule(codeType);
        for (CodeRule codeRule : list) {
            int key = codeRule.getCode_rule_index();
            if (result.get(key) == null) {
                result.put(key, new ArrayList<>());
            }
            CodeMap map = new CodeMap(
                    codeRule.getCode_rule_data(),
                    codeRule.getCode_rule_desc(),
                    codeRule.getCode_rule_len(),
                    codeRule.getCode_rule_index(),
                    codeRule.getCode_rule_type());
            result.get(key).add(map);
        }
        return result;
    }

    @Override
    public CodeRule insertCodeRule(CodeRule cr) {
        codeRuleMapper.insertCodeRule(cr);
        System.out.println(cr.toString());
        return cr;
    }

    @Override
    public Integer deleteCodeRule(int type, int index, String data) {
        return codeRuleMapper.deleteCodeRule(type, index, data);
    }
}
