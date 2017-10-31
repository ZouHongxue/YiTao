package com.example.test.entity;

/**
 * Created by 邹洪学 on 2017/5/29.
 */

public class CarsDetail {
    private String id;
    private String name;
    private String logo;
    private String price;
    private String sizetype;

    public CarsDetail() {
    }

    public CarsDetail(String id, String name, String logo, String price, String sizetype) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.price = price;
        this.sizetype = sizetype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSizetype() {
        return sizetype;
    }

    public void setSizetype(String sizetype) {
        this.sizetype = sizetype;
    }
}
