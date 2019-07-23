package com.fengmi.demo.service.impl;

import com.fengmi.demo.mapper.MNMapper;
import com.fengmi.demo.model.MN;
import com.fengmi.demo.service.MNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijie
 * @create 2019-06-25 13:14
 **/
@Service
public class MNServiceImpl implements MNService {
    @Autowired
    private MNMapper mnMapper;

    @Override
    public MN insertMN(MN mn) {
        mnMapper.insertMN(mn);
        return mn;
    }

    @Override
    public Integer deleteMN(int id) {
        return mnMapper.deleteMN(id);
    }

    @Override
    public MN updateMN(MN mn) {
        mnMapper.updateMN(mn);
        return mn;
    }

    @Override
    public List<MN> getAllMN() {
        return mnMapper.getAllMN();
    }

    @Override
    public List<MN> queryMNByID(int id) {
        return mnMapper.queryMNByID(id);
    }

    @Override
    public List<MN> queryMNByData(String data) {
        return mnMapper.queryMNByData("%" + data + "%");
    }

    @Override
    public List<MN> queryMNByName(String name) {
        return mnMapper.queryMNByData("%" + name + "%");
    }
}
