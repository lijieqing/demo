package com.fengmi.demo.service.impl;

import com.fengmi.demo.mapper.CodeRuleMapper;
import com.fengmi.demo.mapper.PIDMapper;
import com.fengmi.demo.model.Category;
import com.fengmi.demo.model.PID;
import com.fengmi.demo.service.PIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijie
 * @create 2019-06-20 11:11
 **/
@Service
public class PIDServiceImpl implements PIDService {
    @Autowired
    private PIDMapper pidMapper;

    @Override
    public List<PID> getAllPIDs() {
        return pidMapper.getAllPIDs();
    }

    @Override
    public List<Category> getAllCategory() {
        return pidMapper.getAllCategory();
    }

    @Override
    public List<PID> queryPIDByID(int id) {
        return pidMapper.queryPIDByID(id);
    }

    @Override
    public PID insertPID(PID pid) {
        pidMapper.insertPID(pid);
        return pid;
    }

    @Override
    public PID updatePID(PID pid) {
        pidMapper.updatePID(pid);
        return pid;
    }

    @Override
    public List<PID> queryPIDByData(String data) {
        return pidMapper.queryPIDByData(data);
    }

    @Override
    public Integer deletePID(int id) {
        return pidMapper.deletePID(id);
    }
}
