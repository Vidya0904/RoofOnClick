package com.example.roofonclick.Utilities;

import android.content.Context;

import com.example.roofonclick.Activities.RegistrationActivity;

public class Shared_Preference_Manager {

    public static boolean setUser_ID(Context context,int User_Id)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putInt(Shared_Preference_Key_Constant.USER_ID,User_Id).commit();
    }

    public static int getUser_Id(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getInt(Shared_Preference_Key_Constant.USER_ID,0);
    }

    public static long getMYAPP_ID(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getInt(Shared_Preference_Key_Constant.MYAPP_ID,0);
    }

    public static boolean setMYAPP_ID(Context context,long MyApp_Id)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putLong(Shared_Preference_Key_Constant.MYAPP_ID,MyApp_Id).commit();
    }

    public static boolean setAPP_List(Context context,long AppList_Id)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putLong(Shared_Preference_Key_Constant.APPLIST_ID,AppList_Id).commit();
    }

    public static long getAppList_Id(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getInt(Shared_Preference_Key_Constant.APPLIST_ID,0);
    }

    public static boolean setIs_Registration(Context context,long Is_Registration)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putLong(Shared_Preference_Key_Constant.IS_REGISTRATION,Is_Registration).commit();
    }

    public static long getIs_Registration(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getInt(Shared_Preference_Key_Constant.IS_REGISTRATION,0);
    }

    public static boolean setUser_Name(Context context,String User_Name)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putString(Shared_Preference_Key_Constant.USER_NAME,User_Name).commit();
    }

    public static String getUser_Name(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getString(Shared_Preference_Key_Constant.USER_NAME,"");
    }

    public static boolean setDisplay_Name(Context context,long Display_Name)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putLong(Shared_Preference_Key_Constant.DISPLAY_NAME,Display_Name).commit();
    }

    public static long getDisplay_Name(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getInt(Shared_Preference_Key_Constant.DISPLAY_NAME,0);
    }

    public static boolean setUser_Email(Context context,String User_Email)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putString(Shared_Preference_Key_Constant.USER_EMAIL, User_Email).commit();
    }

    public static String getUser_Email(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getString(Shared_Preference_Key_Constant.USER_EMAIL,"");
    }

    public static boolean setUser_Mob_No(Context context,String User_Mob_Id)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putString(Shared_Preference_Key_Constant.USER_MOB_NO,User_Mob_Id).commit();
    }

    public static String getUser_Mob_No(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getString(Shared_Preference_Key_Constant.USER_MOB_NO,"");
    }

    public static boolean setUser_Address(Context context,long User_Address)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putLong(Shared_Preference_Key_Constant.USER_ADDREES,User_Address).commit();
    }

    public static long getUser_Address(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getInt(Shared_Preference_Key_Constant.USER_ADDREES,0);
    }

    public static long getUser_Type(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getInt(Shared_Preference_Key_Constant.USER_TYPE,0);
    }
    public static boolean setUser_Type(Context context,String User_Type)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putString(Shared_Preference_Key_Constant.USER_TYPE,User_Type).commit();
    }


    public static boolean setGender(Context context,String Gender)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putString(Shared_Preference_Key_Constant.GENDER,Gender).commit();
    }

    public static long getGender(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getInt(Shared_Preference_Key_Constant.GENDER,0);
    }

    public static boolean setUser_Login(Context context,long User_Login)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putLong(Shared_Preference_Key_Constant.IS_LOGIN,User_Login).commit();
    }

    public static long getUser_Login(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getInt(Shared_Preference_Key_Constant.IS_LOGIN,0);
    }



}
