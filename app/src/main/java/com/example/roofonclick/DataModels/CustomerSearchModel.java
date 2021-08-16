package com.example.roofonclick.DataModels;

public class CustomerSearchModel
{
    public int searchprice;
    public int searchownerid;
    public int searchroomid;
    public String searchroomtype;
    public String searchtenanttype;
    public String searchaddress;
    public String searchcity;
    public String searchstate;

    public CustomerSearchModel(int searchprice, int searchownerid, int searchroomid, String searchroomtype, String searchtenanttype, String searchaddress, String searchcity, String searchstate) {
        this.searchprice = searchprice;
        this.searchownerid = searchownerid;
        this.searchroomid = searchroomid;
        this.searchroomtype = searchroomtype;
        this.searchtenanttype = searchtenanttype;
        this.searchaddress = searchaddress;
        this.searchcity = searchcity;
        this.searchstate = searchstate;
    }

    public int getSearchprice() {
        return searchprice;
    }

    public void setSearchprice(int searchprice) {
        this.searchprice = searchprice;
    }

    public int getSearchownerid() {
        return searchownerid;
    }

    public void setSearchownerid(int searchownerid) {
        this.searchownerid = searchownerid;
    }

    public int getSearchroomid() {
        return searchroomid;
    }

    public void setSearchroomid(int searchroomid) {
        this.searchroomid = searchroomid;
    }

    public String getSearchroomtype() {
        return searchroomtype;
    }

    public void setSearchroomtype(String searchroomtype) {
        this.searchroomtype = searchroomtype;
    }

    public String getSearchtenanttype() {
        return searchtenanttype;
    }

    public void setSearchtenanttype(String searchtenanttype) {
        this.searchtenanttype = searchtenanttype;
    }

    public String getSearchaddress() {
        return searchaddress;
    }

    public void setSearchaddress(String searchaddress) {
        this.searchaddress = searchaddress;
    }

    public String getSearchcity() {
        return searchcity;
    }

    public void setSearchcity(String searchcity) {
        this.searchcity = searchcity;
    }

    public String getSearchstate() {
        return searchstate;
    }

    public void setSearchstate(String searchstate) {
        this.searchstate = searchstate;
    }
}
