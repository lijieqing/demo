package com.fengmi.demo.model;

/**
 * @author lijie
 * @create 2019-06-25 12:50
 **/
public class MN {
    private Integer mn_id;
    private String mn_type;
    private String mn_type_desc;
    private String mn_data;
    private String mn_name;
    private String mn_supplier;

    public Integer getMn_id() {
        return mn_id;
    }

    public void setMn_id(Integer mn_id) {
        this.mn_id = mn_id;
    }

    public String getMn_type() {
        return mn_type;
    }

    public void setMn_type(String mn_type) {
        this.mn_type = mn_type;
    }

    public String getMn_type_desc() {
        return mn_type_desc;
    }

    public void setMn_type_desc(String mn_type_desc) {
        this.mn_type_desc = mn_type_desc;
    }

    public String getMn_data() {
        return mn_data;
    }

    public void setMn_data(String mn_data) {
        this.mn_data = mn_data;
    }

    public String getMn_name() {
        return mn_name;
    }

    public void setMn_name(String mn_name) {
        this.mn_name = mn_name;
    }

    public String getMn_supplier() {
        return mn_supplier;
    }

    public void setMn_supplier(String mn_supplier) {
        this.mn_supplier = mn_supplier;
    }

    @Override
    public String toString() {
        return "MN{" +
                "mn_id=" + mn_id +
                ", mn_type='" + mn_type + '\'' +
                ", mn_type_desc='" + mn_type_desc + '\'' +
                ", mn_data='" + mn_data + '\'' +
                ", mn_name='" + mn_name + '\'' +
                ", mn_supplier='" + mn_supplier + '\'' +
                '}';
    }
}
