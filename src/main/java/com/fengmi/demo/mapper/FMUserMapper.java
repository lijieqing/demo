package com.fengmi.demo.mapper;

import com.fengmi.demo.model.FMUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FMUserMapper {
    FMUser getUserByName(String name);
}
