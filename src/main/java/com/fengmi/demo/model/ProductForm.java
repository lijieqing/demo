package com.fengmi.demo.model;

/**
 * @author lijie
 * @create 2019-09-18 09:35
 **/
public class ProductForm {
    private PN pn;
    private PID pid;
    private MN mn;
    private SKU sku;
    private Product product;
    private ProductDetail product_detail;

    public ProductForm() {
        this.pn = new PN();
        this.pid = new PID();
        this.mn = new MN();
        this.sku = new SKU();
        this.product = new Product();
        this.product_detail = new ProductDetail();
    }

    public PN getPn() {
        return pn;
    }

    public void setPn(PN pn) {
        this.pn = pn;
    }

    public PID getPid() {
        return pid;
    }

    public void setPid(PID pid) {
        this.pid = pid;
    }

    public MN getMn() {
        return mn;
    }

    public void setMn(MN mn) {
        this.mn = mn;
    }

    public SKU getSku() {
        return sku;
    }

    public void setSku(SKU sku) {
        this.sku = sku;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductDetail getProduct_detail() {
        return product_detail;
    }

    public void setProduct_detail(ProductDetail product_detail) {
        this.product_detail = product_detail;
    }

    @Override
    public String toString() {
        return "ProductForm{" +
                "pn=" + pn +
                ", pid=" + pid +
                ", mn=" + mn +
                ", sku=" + sku +
                ", product=" + product +
                ", product_detail=" + product_detail +
                '}';
    }
}
