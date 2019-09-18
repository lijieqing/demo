package com.fengmi.demo.model;

/**
 * @author lijie
 * @create 2019-09-17 15:17
 **/
public class PN {
    private Integer pn_id;
    private String pn_data;
    private String pn_simple_name;
    private String pn_desc;
    private Integer pn_product_info;
    private Product product;

    public Integer getPn_id() {
        return pn_id;
    }

    public void setPn_id(Integer pn_id) {
        this.pn_id = pn_id;
    }

    public String getPn_data() {
        return pn_data;
    }

    public void setPn_data(String pn_data) {
        this.pn_data = pn_data;
    }

    public String getPn_simple_name() {
        return pn_simple_name;
    }

    public void setPn_simple_name(String pn_simple_name) {
        this.pn_simple_name = pn_simple_name;
    }

    public String getPn_desc() {
        return pn_desc;
    }

    public void setPn_desc(String pn_desc) {
        this.pn_desc = pn_desc;
    }

    public Integer getPn_product_info() {
        return pn_product_info;
    }

    public void setPn_product_info(Integer pn_product_info) {
        this.pn_product_info = pn_product_info;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "PN{" +
                "pn_id=" + pn_id +
                ", pn_data='" + pn_data + '\'' +
                ", pn_simple_name='" + pn_simple_name + '\'' +
                ", pn_desc='" + pn_desc + '\'' +
                ", pn_product_info=" + pn_product_info +
                ", product=" + product +
                '}';
    }
}
