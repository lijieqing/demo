package com.fengmi.demo.service.impl;

import com.fengmi.demo.mapper.PNMapper;
import com.fengmi.demo.model.PN;
import com.fengmi.demo.service.PNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijie
 * @create 2019-09-17 15:36
 **/
@Service
public class PNServiceImpl implements PNService {
    @Autowired
    private PNMapper pnMapper;

    @Override
    public List<PN> getAllPN() {
        return pnMapper.getAllPN();
    }

    @Override
    public List<PN> getPNByData(String data) {
        return pnMapper.getPNByData(data);
    }

    @Override
    public Integer insertPN(PN pn) {
        return pnMapper.insertPN(pn);
    }

    @Override
    public PN getPNByID(int id) {
        return pnMapper.getPNByID(id);
    }

    @Override
    public void deletePNByID(int id) {
        if (pnMapper.getPNByID(id) != null)
            pnMapper.deletePNByID(id);
    }
}
