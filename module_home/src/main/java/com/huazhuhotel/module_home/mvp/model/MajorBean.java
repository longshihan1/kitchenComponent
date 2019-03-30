package com.huazhuhotel.module_home.mvp.model;

public class MajorBean {
    /**
     * title : 高筋面粉
     * note : 150克
     * tu : https://m.douguo.com/ingredients/高筋面粉/detailmaterial
     */

    private String title;
    private String note;
    private String tu;
    private boolean isDel;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTu() {
        return tu;
    }

    public void setTu(String tu) {
        this.tu = tu;
    }

    public boolean isDel() {
        return isDel;
    }

    public MajorBean setDel(boolean del) {
        isDel = del;
        return this;
    }
}
