package com.fengmi.demo.model;

/**
 * @author lijie
 * @create 2019-07-02 20:12
 **/
public class Color {
    private Integer color_id;
    private String color_name;

    public Integer getColor_id() {
        return color_id;
    }

    public void setColor_id(Integer color_id) {
        this.color_id = color_id;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    @Override
    public String toString() {
        return "Color{" +
                "color_id=" + color_id +
                ", color_name='" + color_name + '\'' +
                '}';
    }
}
