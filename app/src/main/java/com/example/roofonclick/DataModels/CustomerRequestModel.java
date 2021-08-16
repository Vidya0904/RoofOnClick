package com.example.roofonclick.DataModels;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class CustomerRequestModel implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    public int reqid;

    @ColumnInfo(name ="OwnerId")
    public int ownerid;

    @ColumnInfo(name = "Customer Name")
    public String reqcustname;

    @ColumnInfo(name = "Room Type")
    public String reqroomtype;

    @ColumnInfo(name = "Tenant Type")
    public String reqtenanttype;

    @ColumnInfo(name = "Date")
    public String reqdate;

    @ColumnInfo(name = "reqImage")
    public byte[] reqImage;

    @ColumnInfo(name = "MobileNo")
    public String reqMobNo;

    public CustomerRequestModel() {
    }


    public int getReqid() {
        return reqid;
    }

    public void setReqid(int reqid) {
        this.reqid = reqid;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public String getReqcustname() {
        return reqcustname;
    }

    public void setReqcustname(String reqcustname) {
        this.reqcustname = reqcustname;
    }

    public String getReqroomtype() {
        return reqroomtype;
    }

    public void setReqroomtype(String reqroomtype) {
        this.reqroomtype = reqroomtype;
    }

    public String getReqtenanttype() {
        return reqtenanttype;
    }

    public void setReqtenanttype(String reqtenanttype) {
        this.reqtenanttype = reqtenanttype;
    }

    public String getReqdate() {
        return reqdate;
    }

    public void setReqdate(String reqdate) {
        this.reqdate = reqdate;
    }

    public String getReqMobNo() {
        return reqMobNo;
    }

    public void setReqMobNo(String reqMobNo) {
        this.reqMobNo = reqMobNo;
    }

    public byte[] getReqImage() {
        return reqImage;
    }

    public void setReqImage(byte[] reqImage) {
        this.reqImage = reqImage;
    }
}
