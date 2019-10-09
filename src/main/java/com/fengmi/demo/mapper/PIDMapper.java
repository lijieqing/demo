package com.fengmi.demo.mapper;

import com.fengmi.demo.model.Category;
import com.fengmi.demo.model.PID;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PIDMapper {
    List<PID> getAllPIDs();

    Integer insertPID(PID pid);

    Integer updatePID(PID pid);

    List<PID> queryPIDByData(String data);

    List<PID> queryPIDByID(int id);

    List<Category> getAllCategory();

    Integer deletePID(int id);

    Integer insertCategory(int data,String name);
}
