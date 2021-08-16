package com.example.roofonclick.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roofonclick.Adapters.CustomerSearchAdapter;
import com.example.roofonclick.DataModels.CustomerHomeModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;
import com.example.roofonclick.Utilities.DatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class CustomerSearch extends Fragment
{
    List<CustomerHomeModel> customerhomemodel;
    RecyclerView searchrview;
    Context searchcontex2;
    CustomerSearchAdapter searchAdapter;
    @Override
    public void onAttach(@NonNull Context searchcontex1) {
        super.onAttach(searchcontex1);
        this.searchcontex2=searchcontex1;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customersearch_recycler_layout,container,false);
    }
    private List<CustomerHomeModel> filter(List<CustomerHomeModel> customerSearchModels, String newText)
    {
        final List<CustomerHomeModel> flist=new ArrayList<>();
        for (CustomerHomeModel homeModel:customerSearchModels)
        {
            final String text=homeModel.getCity().toLowerCase();
            if(text.contains(newText))
            {
                flist.add(homeModel);
            }
        }
        return flist;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.search_action);
        SearchView searchView=(SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search City");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<CustomerHomeModel> flist=filter(customerhomemodel,newText);
                searchAdapter.setFilterlist(flist);
                return true;
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        customerhomemodel=new ArrayList<>();
        searchrview=view.findViewById(R.id.recyclercustomersearch);

        customerhomemodel= DatabaseClient.getInstance(searchcontex2)
                .getAppDatabaseClient()
                .customerHomeModelDao().getAllRooms();


        searchAdapter = new CustomerSearchAdapter(customerhomemodel,searchcontex2);
        searchrview.setLayoutManager(new LinearLayoutManager(searchcontex2,LinearLayoutManager.VERTICAL,false));
        searchrview.setAdapter(searchAdapter);


    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
