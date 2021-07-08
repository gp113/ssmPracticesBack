package com.java.pojo;

import java.util.Date;

public class DeviceType {

    private Integer id;
    private String name;
    private Integer vendorId;
    private Integer txgyId;
    private String dy;
    private String fbl;
    private String lc;
    private String bz;
    private Date creatTime;
    private String txfs;
    private String wbq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getTxgyId() {
        return txgyId;
    }

    public void setTxgyId(Integer txgyId) {
        this.txgyId = txgyId;
    }

    public String getDy() {
        return dy;
    }

    public void setDy(String dy) {
        this.dy = dy;
    }

    public String getFbl() {
        return fbl;
    }

    public void setFbl(String fbl) {
        this.fbl = fbl;
    }

    public String getLc() {
        return lc;
    }

    public void setLc(String lc) {
        this.lc = lc;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getTxfs() {
        return txfs;
    }

    public void setTxfs(String txfs) {
        this.txfs = txfs;
    }

    public String getWbq() {
        return wbq;
    }

    public void setWbq(String wbq) {
        this.wbq = wbq;
    }
}
