package com.example.roofonclick.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roofonclick.Adapters.CustomerFavouriteAdapter;
import com.example.roofonclick.DataModels.CustomerFavouriteModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerFavouriteUtility;
import com.example.roofonclick.Utilities.DatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class CustomerFavourite extends Fragment
{
    List<CustomerFavouriteModel> customerfavmodel;
    RecyclerView rviewfav;
    Context context7;

    @Override
    public void onAttach(@NonNull Context context6)
    {
        super.onAttach(context6);
        this.context7=context6;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customerfav_recycler_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        customerfavmodel = new ArrayList<>();
        rviewfav=view.findViewById(R.id.recylercustomerfav);

       /*Bitmap custfav1 = BitmapFactory.decodeResource(context7.getResources(),R.drawable.orange);
        customerfavmodel.add(new CustomerFavouriteModel(101,301,5000,"Flat","Only for Family","Shree Nagar","Jodhpur","Rajasthan",
                CustomerFavouriteUtility.imgConvertFromBitmapToByteArray(custfav1)));

        Bitmap custfav2 = BitmapFactory.decodeResource(context7.getResources(),R.drawable.orange);
        customerfavmodel.add(new CustomerFavouriteModel(101,301,5000,"Flat","Only for Family","Shree Nagar","Jodhpur","Rajasthan",
                CustomerFavouriteUtility.imgConvertFromBitmapToByteArray(custfav1)));

        Bitmap custfav3 = BitmapFactory.decodeResource(context7.getResources(),R.drawable.orange);
        customerfavmodel.add(new CustomerFavouriteModel(101,301,5000,"Flat","Only for Family","Shree Nagar","Jodhpur","Rajasthan",
                CustomerFavouriteUtility.imgConvertFromBitmapToByteArray(custfav1)));

        Bitmap custfav4 = BitmapFactory.decodeResource(context7.getResources(),R.drawable.orange);
        customerfavmodel.add(new CustomerFavouriteModel(101,301,5000,"Flat","Only for Family","Shree Nagar","Jodhpur","Rajasthan",
                CustomerFavouriteUtility.imgConvertFromBitmapToByteArray(custfav1)));

        Bitmap custfav5 = BitmapFactory.decodeResource(context7.getResources(),R.drawable.orange);
        customerfavmodel.add(new CustomerFavouriteModel(101,301,5000,"Flat","Only for Family","Shree Nagar","Jodhpur","Rajasthan",
                CustomerFavouriteUtility.imgConvertFromBitmapToByteArray(custfav1)));*/

        customerfavmodel= DatabaseClient.getInstance(context7)
                .getAppDatabaseClient()
                .customerHomeFavouriteModelDao()
                .getAllFavourite();


        CustomerFavouriteAdapter custfavadapter = new CustomerFavouriteAdapter(customerfavmodel,context7);
        rviewfav.setLayoutManager(new LinearLayoutManager(context7,LinearLayoutManager.VERTICAL,false));
        rviewfav.setAdapter(custfavadapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
