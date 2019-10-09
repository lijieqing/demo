package com.fengmi.demo.model;

/**
 * @author lijie
 * @create 2019-06-20 17:37
 **/
public class CodeRule {
    private Integer code_rule_id;
    private Integer code_rule_type;
    private Integer code_rule_index;
    private Integer code_rule_len;
    private String code_rule_data;
    private String code_rule_desc;
    private Integer code_total_len;
    private String code_desc;
    private String code_full_name;
    private String code_simple_name;

    public Integer getCode_rule_index() {
        return code_rule_index;
    }

    public void setCode_rule_index(Integer code_rule_index) {
        this.code_rule_index = code_rule_index;
    }

    public Integer getCode_rule_len() {
        return code_rule_len;
    }

    public void setCode_rule_len(Integer code_rule_len) {
        this.code_rule_len = code_rule_len;
    }

    public String getCode_rule_data() {
        return code_rule_data;
    }

    public void setCode_rule_data(String code_rule_data) {
        this.code_rule_data = code_rule_data;
    }

    public String getCode_rule_desc() {
        return code_rule_desc;
    }

    public void setCode_rule_desc(String code_rule_desc) {
        this.code_rule_desc = code_rule_desc;
    }

    public Integer getCode_total_len() {
        return code_total_len;
    }

    public void setCode_total_len(Integer code_total_len) {
        this.code_total_len = code_total_len;
    }

    public String getCode_desc() {
        return code_desc;
    }

    public void setCode_desc(String code_desc) {
        this.code_desc = code_desc;
    }

    public String getCode_full_name() {
        return code_full_name;
    }

    public void setCode_full_name(String code_full_name) {
        this.code_full_name = code_full_name;
    }

    public String getCode_simple_name() {
        return code_simple_name;
    }

    public void setCode_simple_name(String code_simple_name) {
        this.code_simple_name = code_simple_name;
    }

    public Integer getCode_rule_id() {
        return code_rule_id;
    }

    public void setCode_rule_id(Integer code_rule_id) {
        this.code_rule_id = code_rule_id;
    }

    public Integer getCode_rule_type() {
        return code_rule_type;
    }

    public void setCode_rule_type(Integer code_rule_type) {
        this.code_rule_type = code_rule_type;
    }

    @Override
    public String toString() {
        return "CodeRule{" +
                "code_rule_id=" + code_rule_id +
                ", code_rule_type=" + code_rule_type +
                ", code_rule_index=" + code_rule_index +
                ", code_rule_len=" + code_rule_len +
                ", code_rule_data='" + code_rule_data + '\'' +
                ", code_rule_desc='" + code_rule_desc + '\'' +
                ", code_total_len=" + code_total_len +
                ", code_desc='" + code_desc + '\'' +
                ", code_full_name='" + code_full_name + '\'' +
                ", code_simple_name='" + code_simple_name + '\'' +
                '}';
    }
}
