package com.huazhuhotel.module_home.mvp.model;

import java.util.List;

public class MajorInfo {

    private String name;
    private String id ;
    private List<MajorBean> majorBean;

    public String getName() {
        return name;
    }

    public MajorInfo setName(String name) {
        this.name = name;
        return this;
    }

    public String getId() {
        return id;
    }

    public MajorInfo setId(String id) {
        this.id = id;
        return this;
    }

    public List<MajorBean> getMajorBean() {
        return majorBean;
    }

    public MajorInfo setMajorBean(List<MajorBean> majorBean) {
        this.majorBean = majorBean;
        return this;
    }
}
