package com.example.roofonclick.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roofonclick.Activities.CustomerHomeDetailsActivity;
import com.example.roofonclick.Activities.CustomerSearchDetailActivity;
import com.example.roofonclick.DataModels.CustomerHomeModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;

import java.util.ArrayList;
import java.util.List;

public class CustomerSearchAdapter extends RecyclerView.Adapter<CustomerSearchAdapter.MyViewHolder>
{
    List<CustomerHomeModel> custhomelist;
    Context searchcontext1;

    public CustomerSearchAdapter(List<CustomerHomeModel> custhomelist, Context searchcontext1) {
        this.custhomelist = custhomelist;
        this.searchcontext1 = searchcontext1;
    }


    @Override
    public int getItemCount() {
        return custhomelist.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(searchcontext1)
                .inflate(R.layout.customersearch_item_layout,parent,false));
    }

    public void setFilterlist(List<CustomerHomeModel> custhomelist)
    {
       this.custhomelist = custhomelist;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        final CustomerHomeModel singlecustomermodel=custhomelist.get(position);
        holder.txtsearchprice.setText(searchcontext1.getResources().getString(R.string.rs_symbol)+""+ CustomerHomeUtility.convertIntToString(singlecustomermodel.getPrice()));
        holder.txtsearchownerid.setText(CustomerHomeUtility.convertIntToString(singlecustomermodel.getOwnerid()));
        holder.txtsearchroomid.setText(CustomerHomeUtility.convertIntToString(singlecustomermodel.getRoomid()));
        holder.txtsearchroomtype.setText(singlecustomermodel.getRoomtype());
        holder.txtsearchtenanttype.setText(singlecustomermodel.getTenanttype());
        holder.txtsearchaddress.setText(singlecustomermodel.getAddress()+", ");
        holder.txtsearchcity.setText(singlecustomermodel.getCity()+",");
        holder.txtsearchstate.setText(singlecustomermodel.getState());

        holder.searchdtailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hmdetailintent=new Intent(searchcontext1, CustomerSearchDetailActivity.class);

                hmdetailintent.putExtra("Owner Id",singlecustomermodel.getOwnerid());
                hmdetailintent.putExtra("RoomId",singlecustomermodel.getRoomid());
                hmdetailintent.putExtra("Room Type",singlecustomermodel.getRoomtype());
                hmdetailintent.putExtra("Tenant Type",singlecustomermodel.getTenanttype());
                hmdetailintent.putExtra("Address",singlecustomermodel.getAddress());
                hmdetailintent.putExtra("Area",singlecustomermodel.getArea());
                hmdetailintent.putExtra("State",singlecustomermodel.getState());
                hmdetailintent.putExtra("City",singlecustomermodel.getCity());
                hmdetailintent.putExtra("Price",singlecustomermodel.price);
                hmdetailintent.putExtra("Description",singlecustomermodel.getDescr());

                searchcontext1.startActivity(hmdetailintent);
            }
        });

    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtsearchprice,txtsearchownerid,txtsearchroomid,txtsearchroomtype,txtsearchtenanttype,txtsearchaddress,txtsearchcity,txtsearchstate;
        Button searchdtailbtn;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtsearchprice=itemView.findViewById(R.id.custsearchprice);
            txtsearchownerid=itemView.findViewById(R.id.custsearchownerid);
            txtsearchroomid=itemView.findViewById(R.id.custsearchroomid);
            txtsearchroomtype=itemView.findViewById(R.id.custsearchroomtype);
            txtsearchtenanttype=itemView.findViewById(R.id.custsearchtenanttype);
            txtsearchaddress=itemView.findViewById(R.id.custsearchaddress);
            txtsearchcity=itemView.findViewById(R.id.custsearchcity);
            txtsearchstate=itemView.findViewById(R.id.custsearchstate);
            searchdtailbtn=itemView.findViewById(R.id.detailsearchbtn);

        }
    }
}
