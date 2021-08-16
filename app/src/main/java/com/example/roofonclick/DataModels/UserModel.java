package com.example.roofonclick.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserModel implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "Email")
    private String Email;

    @ColumnInfo(name = "mobno")
    private String Mobno;

    @ColumnInfo(name = "password")
    private String Password;

    @ColumnInfo(name = "uName")
    private String Username;

    @ColumnInfo(name = "uType")
    private String Usertype;

    @ColumnInfo(name = "userImage")
    private byte[] userImage;


    @ColumnInfo(name = "userAddress")
    private String userAddress;

    @ColumnInfo(name = "userCity")
    private String userCity;

    @ColumnInfo(name = "userState")
    private String userState;

    public UserModel() {
    }


    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobno() {
        return Mobno;
    }

    public void setMobno(String mobno) {
        Mobno = mobno;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getUsertype() {
        return Usertype;
    }

    public void setUsertype(String usertype) {
        Usertype = usertype;
    }
}
