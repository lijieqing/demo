package com.fengmi.demo.model;

/**
 * @author lijie
 * @create 2019-07-01 19:53
 **/
public class Product {
    private Integer product_id;
    private Integer product_color;
    private Integer product_brand;
    private Integer info_detail;

    private Integer product_pid;
    private Integer product_sku;
    private Integer product_mn;

    private String color;
    private String brand;

    private PID pid;
    private SKU sku;
    private MN mn;
    private ProductDetail pd;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getProduct_color() {
        return product_color;
    }

    public void setProduct_color(Integer product_color) {
        this.product_color = product_color;
    }

    public Integer getProduct_brand() {
        return product_brand;
    }

    public void setProduct_brand(Integer product_brand) {
        this.product_brand = product_brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public PID getPid() {
        return pid;
    }

    public void setPid(PID pid) {
        this.pid = pid;
    }

    public SKU getSku() {
        return sku;
    }

    public void setSku(SKU sku) {
        this.sku = sku;
    }

    public MN getMn() {
        return mn;
    }

    public void setMn(MN mn) {
        this.mn = mn;
    }

    public Integer getProduct_pid() {
        return product_pid;
    }

    public void setProduct_pid(Integer product_pid) {
        this.product_pid = product_pid;
    }

    public Integer getProduct_sku() {
        return product_sku;
    }

    public void setProduct_sku(Integer product_sku) {
        this.product_sku = product_sku;
    }

    public Integer getProduct_mn() {
        return product_mn;
    }

    public void setProduct_mn(Integer product_mn) {
        this.product_mn = product_mn;
    }

    public ProductDetail getPd() {
        return pd;
    }

    public void setPd(ProductDetail pd) {
        this.pd = pd;
    }

    public Integer getInfo_detail() {
        return info_detail;
    }

    public void setInfo_detail(Integer info_detail) {
        this.info_detail = info_detail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_color=" + product_color +
                ", product_brand=" + product_brand +
                ", info_detail=" + info_detail +
                ", product_pid=" + product_pid +
                ", product_sku=" + product_sku +
                ", product_mn=" + product_mn +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", pid=" + pid +
                ", sku=" + sku +
                ", mn=" + mn +
                ", pd=" + pd +
                '}';
    }
}
