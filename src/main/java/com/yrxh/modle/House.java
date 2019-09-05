package com.yrxh.modle;

/**
 * Created by 91383 on 2019/8/23.
 */
public class House {
    private Integer id;
    private String community;
    private String location;
    private String owner;
    private Integer area;
    private String phone;
    private String houseType1;
    private String houseType2;
    private String houseType3;
    private String repair1;
    private String repair2;
    private String remark;

    private String houseType;


    public House() {
    }

    public House(Integer id, String community, String location, String owner, Integer area, String phone, String houseType1, String houseType2, String houseType3, String repair1, String repair2, String remark) {
        this.id = id;
        this.community = community;
        this.location = location;
        this.owner = owner;
        this.area = area;
        this.phone = phone;
        this.houseType1 = houseType1;
        this.houseType2 = houseType2;
        this.houseType3 = houseType3;
        this.repair1 = repair1;
        this.repair2 = repair2;
        this.remark = remark;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHouseType1() {
        return houseType1;
    }

    public void setHouseType1(String houseType1) {
        this.houseType1 = houseType1;
    }

    public String getHouseType2() {
        return houseType2;
    }

    public void setHouseType2(String houseType2) {
        this.houseType2 = houseType2;
    }

    public String getHouseType3() {
        return houseType3;
    }

    public void setHouseType3(String houseType3) {
        this.houseType3 = houseType3;
    }

    public String getRepair1() {
        return repair1;
    }

    public void setRepair1(String repair1) {
        this.repair1 = repair1;
    }

    public String getRepair2() {
        return repair2;
    }

    public void setRepair2(String repair2) {
        this.repair2 = repair2;
    }

    @Override
    public String toString() {
        return "id:"+id
                +",community:"+community
                +",location:"+location
                +",owner:"+owner
                +",area:"+area
                +",phone:"+phone;


    }
}
