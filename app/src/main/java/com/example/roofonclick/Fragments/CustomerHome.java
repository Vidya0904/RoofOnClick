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

import com.example.roofonclick.Adapters.CustomerHomeAdapter;
import com.example.roofonclick.DataModels.CustomerHomeModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;
import com.example.roofonclick.Utilities.DatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class CustomerHome extends Fragment
{

    List<CustomerHomeModel> customerhomemodel;
    RecyclerView rview;
    Context context5;

    @Override
    public void onAttach(@NonNull Context context4)
    {
        super.onAttach(context4);
        this.context5=context4;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customerhome_recycler_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        customerhomemodel = new ArrayList<>();
        rview=view.findViewById(R.id.recylercustomerhome);


        customerhomemodel = DatabaseClient.getInstance(context5)
                .getAppDatabaseClient()
                .customerHomeModelDao()
                .getAllRooms();

        CustomerHomeAdapter custhmadapter = new CustomerHomeAdapter(customerhomemodel,context5);
        rview.setLayoutManager(new LinearLayoutManager(context5,LinearLayoutManager.VERTICAL,false));
        rview.setAdapter(custhmadapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
