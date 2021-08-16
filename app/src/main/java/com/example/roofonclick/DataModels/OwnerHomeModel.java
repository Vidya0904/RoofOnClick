package com.example.roofonclick.DataModels;

public class OwnerHomeModel
{
    public int id;
    public int roomId;
    public String custName;
    public String requestDate;
    public String custMobile;


    public OwnerHomeModel(int id, int roomId, String custName, String requestDate, String custMobile) {
        this.id = id;
        this.roomId = roomId;
        this.custName = custName;
        this.requestDate = requestDate;
        this.custMobile = custMobile;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id=id;
    }

    public int getroomId()
    {
        return roomId;
    }

    public void setroomId(int roomId)
    {
        this.roomId=roomId;
    }

    public String getcustName()
    {
        return custName;
    }

    public void setcustName(String custName)
    {
        this.custName=custName;
    }

    public String getrequestDate()
    {
        return requestDate;
    }

    public void setrequestDate(String requestDate)
    {
        this.requestDate=requestDate;
    }

    public String getcustMobile()
    {
        return custMobile;
    }

    public void setcustMobile(String custMobile)
    {
        this.custMobile=custMobile;
    }

}






