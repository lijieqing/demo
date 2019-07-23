package com.fengmi.demo.model;

/**
 * SKU数据对象
 *
 * @author lijie
 * @create 2019-06-19 15:07
 **/
public class SKU {
    private Integer sku_id;
    private String sku_data;
    private String sku_name;
    private String sku_country;

    public SKU() {
    }

    public SKU(Integer sku_id, String sku_data, String sku_name) {
        this.sku_id = sku_id;
        this.sku_data = sku_data;
        this.sku_name = sku_name;
    }

    public Integer getSku_id() {
        return sku_id;
    }

    public void setSku_id(Integer sku_id) {
        this.sku_id = sku_id;
    }

    public String getSku_data() {
        return sku_data;
    }

    public void setSku_data(String sku_data) {
        this.sku_data = sku_data;
    }

    public String getSku_name() {
        return sku_name;
    }

    public void setSku_name(String sku_name) {
        this.sku_name = sku_name;
    }

    public String getSku_country() {
        return sku_country;
    }

    public void setSku_country(String sku_country) {
        this.sku_country = sku_country;
    }

    @Override
    public String toString() {
        return "SKU{" +
                "sku_id=" + sku_id +
                ", sku_data='" + sku_data + '\'' +
                ", sku_name='" + sku_name + '\'' +
                '}';
    }
}
