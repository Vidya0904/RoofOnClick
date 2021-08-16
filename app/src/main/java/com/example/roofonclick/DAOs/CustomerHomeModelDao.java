package com.example.roofonclick.DAOs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roofonclick.DataModels.CustomerHomeModel;

import java.util.List;

@Dao
public interface CustomerHomeModelDao
{
    @Query("SELECT * FROM CustomerHomeModel")
    List<CustomerHomeModel> getAllRooms();

    @Insert
    long insetCustomerHomeModel(CustomerHomeModel chm);

    @Update
    void updateCustomerHomeModel(CustomerHomeModel chm);

    @Delete
    void deleteCustomerHomeModel(CustomerHomeModel chm);

    @Query("Select * from CustomerHomeModel WHERE RoomId=:roomid")
    CustomerHomeModel getRoomById(long roomid);
}
