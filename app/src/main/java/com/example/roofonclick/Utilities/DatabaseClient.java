package com.example.roofonclick.Utilities;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

public class DatabaseClient
{
    private Context context;
    private static DatabaseClient mInstatnce;

    private AppDatabaseClient appDatabaseClient;

    public DatabaseClient(Context context)
    {
        this.context=context;

        appDatabaseClient = Room.databaseBuilder(context,AppDatabaseClient.class,"RoofOnClickDB")
                .allowMainThreadQueries().build();

    }
    public static synchronized DatabaseClient getInstance(Context context)
    {
        if (mInstatnce == null)
        {
            mInstatnce = new DatabaseClient(context);
        }
        return mInstatnce;
    }
    public AppDatabaseClient getAppDatabaseClient()
    {
        return appDatabaseClient;
    }
}
