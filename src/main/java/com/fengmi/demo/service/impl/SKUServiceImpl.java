package com.fengmi.demo.service.impl;

import com.fengmi.demo.mapper.SKUMapper;
import com.fengmi.demo.model.SKU;
import com.fengmi.demo.service.SKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijie
 * @create 2019-06-19 15:17
 **/
@Service
public class SKUServiceImpl implements SKUService {
    @Autowired
    private SKUMapper skuMapper;

    public List<SKU> getAllSKUs() {
        System.out.println(skuMapper);
        return skuMapper.getAllSKUs();
    }

    @Override
    public Integer insertSKU(SKU sku) {
        return skuMapper.insertSKU(sku);
    }

    @Override
    public SKU updateSKU(SKU sku) {
        skuMapper.updateSKU(sku);
        System.out.println("updateSKU:" + sku.toString());
        return sku;
    }

    @Override
    public List<SKU> querySKUByData(String data) {
        return skuMapper.querySKUByData("%" + data + "%");
    }

    @Override
    public List<SKU> querySKUByName(String name) {
        return skuMapper.querySKUByName("%" + name + "%");
    }

    @Override
    public Integer deleteSKU(int id) {
        List<SKU> list = skuMapper.querySKUById(id);
        int res = -1;
        if (list.size() == 1) {
            System.out.println("deleteSKU " + list.get(0));
            if (list.get(0) != null) {
                skuMapper.deleteSKU(id);
                res = 1;
            }
        }
        return res;
    }

    @Override
    public List<SKU> querySKUByID(int id) {
        return skuMapper.querySKUById(id);
    }
}
