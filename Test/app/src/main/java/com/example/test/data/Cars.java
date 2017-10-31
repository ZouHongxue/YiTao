package com.example.test.data;

/**
 * Created by 邹洪学 on 2017/5/29.
 */

public class Cars {
    String id;
    String name ;
    String logo;
    String initial;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    String parentid;
    String depth;

    public Cars(String id, String name, String logo, String initial, String parentid, String depth) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.initial = initial;
        this.parentid = parentid;
        this.depth = depth;
    }

    public Cars() {
    }

    public Cars(String name, String logo) {
        this.name = name;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
