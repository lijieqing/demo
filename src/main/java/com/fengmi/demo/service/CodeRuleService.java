package com.fengmi.demo.service;

import com.fengmi.demo.model.CodeMap;

import java.util.List;
import java.util.Map;

public interface CodeRuleService {
    Map<Integer, List<CodeMap>> queryCodeRule(String codeType);
}
