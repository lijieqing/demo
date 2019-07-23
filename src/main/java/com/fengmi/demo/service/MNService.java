package com.fengmi.demo.service;

import com.fengmi.demo.model.MN;

import java.util.List;

public interface MNService {
    MN insertMN(MN mn);

    Integer deleteMN(int id);

    MN updateMN(MN mn);

    List<MN> getAllMN();

    List<MN> queryMNByID(int id);

    List<MN> queryMNByData(String data);

    List<MN> queryMNByName(String name);
}
