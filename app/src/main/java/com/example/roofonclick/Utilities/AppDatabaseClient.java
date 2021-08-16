package com.example.roofonclick.Utilities;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roofonclick.DAOs.CustomerHomeFavouriteModelDao;
import com.example.roofonclick.DAOs.CustomerHomeModelDao;
import com.example.roofonclick.DAOs.CutomerHomeRequestModelDao;
import com.example.roofonclick.DAOs.UserModelDaos;
import com.example.roofonclick.DataModels.CustomerFavouriteModel;
import com.example.roofonclick.DataModels.CustomerHomeModel;
import com.example.roofonclick.DataModels.CustomerRequestModel;
import com.example.roofonclick.DataModels.UserModel;


@Database(entities  = {UserModel.class, CustomerHomeModel.class, CustomerRequestModel.class, CustomerFavouriteModel.class},version = 1,exportSchema = false)

public abstract class AppDatabaseClient extends RoomDatabase
{
    public abstract UserModelDaos userDaos();
    public abstract CustomerHomeModelDao customerHomeModelDao();
    public abstract CutomerHomeRequestModelDao customerHomeRequestModelDao();
    public abstract CustomerHomeFavouriteModelDao customerHomeFavouriteModelDao();

}
