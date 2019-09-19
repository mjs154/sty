package com.mjs.study.entity.pojo;

public class PaymentInfo {
    private Integer id;

    private String acceptid;

    private String transno;

    private Integer status;

    private String creattime;

    private String extend;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcceptid() {
        return acceptid;
    }

    public void setAcceptid(String acceptid) {
        this.acceptid = acceptid == null ? null : acceptid.trim();
    }

    public String getTransno() {
        return transno;
    }

    public void setTransno(String transno) {
        this.transno = transno == null ? null : transno.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime == null ? null : creattime.trim();
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }
}