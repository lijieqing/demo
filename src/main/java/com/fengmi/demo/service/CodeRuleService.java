package com.fengmi.demo.service;

import com.fengmi.demo.model.CodeMap;
import com.fengmi.demo.model.CodeRule;

import java.util.List;
import java.util.Map;

public interface CodeRuleService {
    Map<Integer, List<CodeMap>> queryCodeRule(String codeType);
    CodeRule insertCodeRule(CodeRule cr);
    Integer deleteCodeRule(int type,int index,String data);
}
