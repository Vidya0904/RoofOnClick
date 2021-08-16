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

import com.example.roofonclick.Adapters.OwnerRequestAdapter;
import com.example.roofonclick.DataModels.CustomerRequestModel;
import com.example.roofonclick.DataModels.OwnerHomeModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.DatabaseClient;
import com.example.roofonclick.Utilities.Shared_Preference_Manager;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment
{
    List<CustomerRequestModel> ownerhomemodel;
    RecyclerView recyclerview;
    Context contextl;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.contextl=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ownerhome_recyler_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ownerhomemodel = new ArrayList<>();
        recyclerview = view.findViewById(R.id.recylerhome);

        ownerhomemodel= DatabaseClient.getInstance(contextl)
                .getAppDatabaseClient()
                .customerHomeRequestModelDao()
                .getAllRequestByOwnerId((int) Shared_Preference_Manager.getUser_Id(contextl));

        OwnerRequestAdapter ownerrequestadapter = new OwnerRequestAdapter(ownerhomemodel,contextl);
        recyclerview.setLayoutManager(new LinearLayoutManager(contextl,LinearLayoutManager.VERTICAL,false));
        recyclerview.setAdapter(ownerrequestadapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}


