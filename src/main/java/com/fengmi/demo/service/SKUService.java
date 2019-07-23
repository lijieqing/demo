package com.fengmi.demo.service;

import com.fengmi.demo.model.SKU;

import java.util.List;

public interface SKUService {
    List<SKU> getAllSKUs();

    Integer insertSKU(SKU sku);

    SKU updateSKU(SKU sku);

    List<SKU> querySKUByData(String data);

    List<SKU> querySKUByName(String name);

    Integer deleteSKU(int id);

    List<SKU> querySKUByID(int id);
}
