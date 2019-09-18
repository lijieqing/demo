package com.fengmi.demo.mapper;

import com.fengmi.demo.model.PN;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PNMapper {
    List<PN> getAllPN();

    Integer insertPN(PN pn);

    PN getPNByID(int id);

    List<PN> getPNByData(String data);

    void deletePNByID(int id);
}
