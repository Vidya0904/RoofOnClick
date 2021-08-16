package com.example.roofonclick.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roofonclick.DataModels.CustomerHomeModel;
import com.example.roofonclick.DataModels.CustomerRequestModel;
import com.example.roofonclick.Fragments.CustomerRequest;

import java.util.List;

@Dao
public interface CutomerHomeRequestModelDao
{
    @Query("SELECT * FROM CustomerRequestModel")
    List<CustomerRequestModel> getAllRequest();

    @Query("SELECT * FROM CustomerRequestModel WHERE OwnerId=:ownerId")
    List<CustomerRequestModel> getAllRequestByOwnerId(int ownerId);

    @Insert
    long insetCustomerHomeRequestModel(CustomerRequestModel chrm);

    @Update
    void updateCustomerHomeRequestModel(CustomerRequestModel chrm);

    @Delete
    void deleteCustomerHomeRequestModel(CustomerRequestModel chrm);

}
