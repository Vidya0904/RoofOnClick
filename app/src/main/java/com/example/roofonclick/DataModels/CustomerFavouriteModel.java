package com.example.roofonclick.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CustomerFavouriteModel
{
    @PrimaryKey(autoGenerate = true)
    public int Favid;

    @ColumnInfo(name = "RoomId" )
    public int froomid;

    @ColumnInfo(name = "Price")
    public int fprice;

    @ColumnInfo(name = "RoomType")
    public String froomtype;

    @ColumnInfo(name = "TenantType")
    public String ftenanttype;

    @ColumnInfo(name = "Address")
    public String faddress;

    @ColumnInfo(name = "City")
    public String fcity;

    @ColumnInfo(name = "State")
    public String fstate;

    @ColumnInfo(name = "Image")
    public byte[] fimg;


    public CustomerFavouriteModel() {
    }

    public int getFavid() {
        return Favid;
    }

    public void setFavid(int fFavid) {
        this.Favid = fFavid;
    }

    public int getFroomid() {
        return froomid;
    }

    public void setFroomid(int froomid) {
        this.froomid = froomid;
    }

    public int getFprice() {
        return fprice;
    }

    public void setFprice(int fprice) {
        this.fprice = fprice;
    }

    public String getFroomtype() {
        return froomtype;
    }

    public void setFroomtype(String froomtype) {
        this.froomtype = froomtype;
    }

    public String getFtenanttype() {
        return ftenanttype;
    }

    public void setFtenanttype(String ftenanttype) {
        this.ftenanttype = ftenanttype;
    }

    public String getFaddress() {
        return faddress;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress;
    }

    public String getFcity() {
        return fcity;
    }

    public void setFcity(String fcity) {
        this.fcity = fcity;
    }

    public String getFstate() {
        return fstate;
    }

    public void setFstate(String fstate) {
        this.fstate = fstate;
    }

    public byte[] getFimg() {
        return fimg;
    }

    public void setFimg(byte[] fimg) {
        this.fimg = fimg;
    }
}
