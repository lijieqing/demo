package com.fengmi.demo.mapper;

import com.fengmi.demo.model.SKU;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SKUMapper {
    List<SKU> getAllSKUs();

    Integer insertSKU(SKU sku);

    void updateSKU(SKU sku);

    List<SKU> querySKUByData(String data);

    List<SKU> querySKUByName(String name);

    List<SKU> querySKUById(int id);

    Integer deleteSKU(int id);
}
