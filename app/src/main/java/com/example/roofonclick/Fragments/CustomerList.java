package com.example.roofonclick.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roofonclick.Adapters.CustomerListAdapter;
import com.example.roofonclick.DataModels.CustomerListModel;
import com.example.roofonclick.DataModels.UserModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.DatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class CustomerList extends Fragment
{
    List<UserModel> userModels;
    RecyclerView recyclerviews;

    Context context3;
    @Override
    public void onAttach(@NonNull Context context2)
    {
        super.onAttach(context2);
        this.context3=context2;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customerlist_recycler_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userModels = new ArrayList<>();
        recyclerviews = view.findViewById(R.id.recylercustomerlist);

       userModels = DatabaseClient.getInstance(context3).getAppDatabaseClient()
               .userDaos().getAllUserByType("Customer");

        CustomerListAdapter customerlistadapter = new CustomerListAdapter(userModels,context3);
        recyclerviews.setLayoutManager(new LinearLayoutManager(context3,LinearLayoutManager.VERTICAL,false));
        recyclerviews.setAdapter(customerlistadapter);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
