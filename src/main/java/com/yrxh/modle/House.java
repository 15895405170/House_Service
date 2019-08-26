package com.yrxh.modle;

/**
 * Created by 91383 on 2019/8/23.
 */
public class House {
    private Integer id;
    private String community;
    private String location;
    private String owner;
    private String area;
    private String phone;
    private String houseType;
    private String repair;

    public House() {
    }

    public House(Integer id, String community, String location, String owner, String area, String phone, String houseType, String repair) {
        this.id = id;
        this.community = community;
        this.location = location;
        this.owner = owner;
        this.area = area;
        this.phone = phone;
        this.houseType = houseType;
        this.repair = repair;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String type) {
        this.houseType = type;
    }

    public String getRepair() {
        return repair;
    }

    public void setRepair(String repair) {
        this.repair = repair;
    }

    @Override
    public String toString() {
        return "id:"+id
                +",community:"+community
                +",location:"+location
                +",owner:"+owner
                +",area:"+area
                +",phone:"+phone
                +",houseType:"+houseType
                +",repair:"+repair;

    }
}
