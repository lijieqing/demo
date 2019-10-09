package com.fengmi.demo.model;

/**
 * @author lijie
 * @create 2019-06-20 16:13
 **/
public class Category {
    private Integer category_id;
    private Integer category_data;
    private String category_name;

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Integer getCategory_data() {
        return category_data;
    }

    public void setCategory_data(Integer category_data) {
        this.category_data = category_data;
    }
}
