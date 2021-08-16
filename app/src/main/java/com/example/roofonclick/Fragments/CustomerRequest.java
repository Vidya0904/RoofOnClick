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

import com.example.roofonclick.Adapters.CustomerRequestAdapter;
import com.example.roofonclick.DataModels.CustomerRequestModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.DatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class CustomerRequest extends Fragment
{

    List<CustomerRequestModel> customerrequestmodel;
    RecyclerView rviewreq;
    Context context9;

    @Override
    public void onAttach(@NonNull Context context8)
    {
        super.onAttach(context8);
        this.context9=context8;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customerrequesrt_recycler_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        customerrequestmodel=new ArrayList<>();
        rviewreq=view.findViewById(R.id.recylercustrequest);

        customerrequestmodel=DatabaseClient.getInstance(context9)
                .getAppDatabaseClient()
                .customerHomeRequestModelDao()
                .getAllRequest();

        CustomerRequestAdapter customerreqadapter=new CustomerRequestAdapter(customerrequestmodel,context9);
        rviewreq.setLayoutManager(new LinearLayoutManager(context9,LinearLayoutManager.VERTICAL,false));
        rviewreq.setAdapter(customerreqadapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
