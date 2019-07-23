package com.fengmi.demo.model;

/**
 * @author lijie
 * @create 2019-06-20 18:53
 **/
public class CodeMap {
    private String codeData;
    private String codeDesc;

    public CodeMap(String codeData, String codeDesc) {
        this.codeData = codeData;
        this.codeDesc = codeDesc;
    }

    public String getCodeData() {
        return codeData;
    }

    public void setCodeData(String codeData) {
        this.codeData = codeData;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }
}
