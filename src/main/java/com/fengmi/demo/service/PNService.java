package com.fengmi.demo.service;

import com.fengmi.demo.model.PN;

import java.util.List;

public interface PNService {
    List<PN> getAllPN();

    List<PN> getPNByData(String data);

    Integer insertPN(PN pn);

    PN getPNByID(int id);

    void deletePNByID(int id);
}
