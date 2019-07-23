package com.fengmi.demo.mapper;

import com.fengmi.demo.model.CodeRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CodeRuleMapper {
    List<CodeRule> queryCodeRule(String codeType);
}
