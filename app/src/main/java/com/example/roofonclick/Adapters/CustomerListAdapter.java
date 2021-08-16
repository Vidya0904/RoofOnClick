package com.example.roofonclick.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roofonclick.DataModels.CustomerListModel;
import com.example.roofonclick.DataModels.UserModel;
import com.example.roofonclick.R;

import java.util.ArrayList;
import java.util.List;

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.MyViewHolder>
{
    List<UserModel> userlist;
    Context context2;


    public CustomerListAdapter(List<UserModel> userlist, Context context2) {
        this.userlist = userlist;
        this.context2 = context2;
    }

    @Override
    public int getItemCount()
    {
        return userlist.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context2)
                .inflate(R.layout.customer_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        UserModel singleusermodel=userlist.get(position);

        holder.txtusername.setText(singleusermodel.getUsername());
        holder.txtuseremail.setText(singleusermodel.getEmail());
        holder.txtusermobile.setText(singleusermodel.getMobno());

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtusername,txtuseremail,txtusermobile;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtusername=itemView.findViewById(R.id.textitemname);
            txtuseremail=itemView.findViewById(R.id.textitememail);
            txtusermobile=itemView.findViewById(R.id.textitemmobile);

        }
    }
}
