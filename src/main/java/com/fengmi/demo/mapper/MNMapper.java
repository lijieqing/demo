package com.fengmi.demo.mapper;

import com.fengmi.demo.model.MN;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MNMapper {

    Integer insertMN(MN mn);

    Integer deleteMN(int id);

    Integer updateMN(MN mn);

    List<MN> getAllMN();

    List<MN> queryMNByID(int id);

    List<MN> queryMNByData(String data);

    List<MN> queryMNByName(String name);
}
