package com.fengmi.demo.model;

/**
 * @author lijie
 * @create 2019-07-02 19:31
 **/
public class Brand {
    private Integer brand_id;
    private String brand_name;

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brand_id=" + brand_id +
                ", brand_name='" + brand_name + '\'' +
                '}';
    }
}
