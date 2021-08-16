package com.example.roofonclick.DataModels;

public class CustomerListModel
{
    public String username;
    public String emailid;
    public String password;
    public String mobileno;

    public CustomerListModel(String username, String emailid, String password, String mobileno) {
        this.username = username;
        this.emailid = emailid;
        this.password = password;
        this.mobileno = mobileno;
    }

    public String getusername()
    {
        return username;
    }
    public void setusername(String username)
    {
        this.username=username;
    }

    public String getemailid()
    {
        return emailid;
    }
    public void setemailid(String emailid)
    {
        this.emailid=emailid;
    }

    public String getpassword()
    {
        return password;
    }
    public void setpassword(String password)
    {
        this.password=password;
    }

    public String getmobileno()
    {
        return mobileno;
    }
    public void setmobileno(String mobileno)
    {
        this.mobileno=mobileno;
    }
}
