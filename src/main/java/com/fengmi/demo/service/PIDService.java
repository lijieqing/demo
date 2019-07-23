package com.fengmi.demo.service;

import com.fengmi.demo.model.Category;
import com.fengmi.demo.model.PID;

import java.util.List;

public interface PIDService {
    List<PID> getAllPIDs();

    List<Category> getAllCategory();

    List<PID> queryPIDByID(int id);

    PID insertPID(PID pid);

    PID updatePID(PID pid);

    List<PID> queryPIDByData(String data);

    Integer deletePID(int id);
}
