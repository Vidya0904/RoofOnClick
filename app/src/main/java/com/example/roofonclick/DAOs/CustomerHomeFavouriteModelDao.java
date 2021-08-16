package com.example.roofonclick.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roofonclick.DataModels.CustomerFavouriteModel;

import java.util.List;

@Dao
public interface CustomerHomeFavouriteModelDao
{
    @Query("SELECT * FROM CustomerFavouriteModel")
    List<CustomerFavouriteModel> getAllFavourite();

    @Insert
    long insertCustomerFavouriteModel(CustomerFavouriteModel cfm);

    @Update
    void updateCustomerFavouriteModel(CustomerFavouriteModel cfm);

    @Delete
    void deleteCustomerFavouriteModel(CustomerFavouriteModel cfm);
}