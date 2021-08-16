package com.example.roofonclick.DataModels;

import androidx.annotation.ColorInt;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class CustomerHomeModel implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    public int roomid;

    @ColumnInfo(name = "OwnerId")
    public int ownerid;

    @ColumnInfo(name = "RoomType")
    public String roomtype;

    @ColumnInfo(name = "TenantType")
    public String tenanttype;

    @ColumnInfo(name = "Address")
    public String address;

    @ColumnInfo(name = "Area")
    public String area;

    @ColumnInfo(name = "City")
    public String city;

    @ColumnInfo(name = "State")
    public String state;

    @ColumnInfo(name = "Image")
    public byte[] img;

    @ColumnInfo(name = "Price")
    public int price;

    @ColumnInfo(name = "Description")
    public String descr;

    @Ignore
    public CustomerHomeModel(int ownerid, int roomid, String roomtype, String tenanttype, String address,String area, String city, String state, byte[] img, int price) {
        this.ownerid = ownerid;
        this.roomid = roomid;
        this.roomtype = roomtype;
        this.tenanttype = tenanttype;
        this.address = address;
        this.area=area;
        this.city = city;
        this.state = state;
        this.img = img;
        this.price = price;
    }

    public CustomerHomeModel() {

    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getTenanttype() {
        return tenanttype;
    }

    public void setTenanttype(String tenanttype) {
        this.tenanttype = tenanttype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) { this.address = address; }

    public String getArea(){return area; }

    public void setArea(String area) { this.area=area; }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getDescr() { return descr; }

    public void setDescr(String descr) {this.descr=descr;}
}
