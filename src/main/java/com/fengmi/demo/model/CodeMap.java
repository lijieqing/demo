package com.fengmi.demo.model;

/**
 * @author lijie
 * @create 2019-06-20 18:53
 **/
public class CodeMap {
    private String codeData;
    private String codeDesc;
    private int codeLength;
    private int codeIndex;
    private int codeType;

    public CodeMap(String codeData, String codeDesc, int codeLength, int codeIndex, int codeType) {
        this.codeData = codeData;
        this.codeDesc = codeDesc;
        this.codeLength = codeLength;
        this.codeIndex = codeIndex;
        this.codeType = codeType;
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

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public int getCodeIndex() {
        return codeIndex;
    }

    public void setCodeIndex(int codeIndex) {
        this.codeIndex = codeIndex;
    }

    public int getCodeType() {
        return codeType;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }
}
