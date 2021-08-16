package com.example.roofonclick.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roofonclick.DataModels.UserModel;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UserModelDaos
{
    @Query("SELECT * FROM UserModel")
    List<UserModel> getAllUsers();

    @Insert
    long insertUserModel(UserModel U);

    @Update
    void updateUserModel(UserModel U);

    @Delete
    void deleteUserModel(UserModel U);

    @Query("Select * from UserModel WHERE Email=:email and password=:pass")
    UserModel userLogin(String email,String pass);

    @Query("Select * from UserModel WHERE uType=:uType")
    List<UserModel> getAllUserByType(String uType);

    @Query("Select * from UserModel WHERE Email=:proemail")
    UserModel getUserByEmail(String proemail);
}
