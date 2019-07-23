package com.fengmi.demo.model;

import java.sql.Date;

/**
 * PID数据库对象
 *
 * @author lijie
 * @create 2019-06-20 09:51
 **/
public class PID {
    private Integer pid_id;
    private String pid_data;
    private String market_name;
    private Integer pid_category;
    private String pid_category_desc;
    private Date pid_create_date;
    private String pid_remark;
    private String pid_sn;
    private Integer pid_brand;

    public Integer getPid_id() {
        return pid_id;
    }

    public void setPid_id(Integer pid_id) {
        this.pid_id = pid_id;
    }

    public String getPid_data() {
        return pid_data;
    }

    public void setPid_data(String pid_data) {
        this.pid_data = pid_data;
    }

    public String getMarket_name() {
        return market_name;
    }

    public void setMarket_name(String market_name) {
        this.market_name = market_name;
    }

    public Date getPid_create_date() {
        return pid_create_date;
    }

    public void setPid_create_date(Date pid_create_date) {
        this.pid_create_date = pid_create_date;
    }

    public String getPid_remark() {
        return pid_remark;
    }

    public void setPid_remark(String pid_remark) {
        this.pid_remark = pid_remark;
    }

    public Integer getPid_category() {
        return pid_category;
    }

    public void setPid_category(Integer pid_category) {
        this.pid_category = pid_category;
    }

    public String getPid_category_desc() {
        return pid_category_desc;
    }

    public void setPid_category_desc(String pid_category_desc) {
        this.pid_category_desc = pid_category_desc;
    }

    public String getPid_sn() {
        return pid_sn;
    }

    public void setPid_sn(String pid_sn) {
        this.pid_sn = pid_sn;
    }

    public Integer getPid_brand() {
        return pid_brand;
    }

    public void setPid_brand(Integer pid_brand) {
        this.pid_brand = pid_brand;
    }

    @Override
    public String toString() {
        return "PID{" +
                "pid_id=" + pid_id +
                ", pid_data='" + pid_data + '\'' +
                ", market_name='" + market_name + '\'' +
                ", pid_category=" + pid_category +
                ", pid_category_desc='" + pid_category_desc + '\'' +
                ", pid_create_date=" + pid_create_date +
                ", pid_remark='" + pid_remark + '\'' +
                ", pid_sn='" + pid_sn + '\'' +
                ", pid_brand=" + pid_brand +
                '}';
    }
}
