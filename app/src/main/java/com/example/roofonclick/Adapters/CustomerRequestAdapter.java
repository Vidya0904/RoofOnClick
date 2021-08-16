package com.example.roofonclick.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roofonclick.Activities.CustomerRequestViewActivity;
import com.example.roofonclick.DataModels.CustomerRequestModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;

import java.util.ArrayList;
import java.util.List;

public class CustomerRequestAdapter extends RecyclerView.Adapter<CustomerRequestAdapter.MyViewHolder>
{
    List<CustomerRequestModel> custreqlist;
    Context context8;

    public CustomerRequestAdapter(List<CustomerRequestModel> custreqlist, Context context8) {
        this.custreqlist = custreqlist;
        this.context8 = context8;
    }

    @Override
    public int getItemCount() {
        return custreqlist.size();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context8)
        .inflate(R.layout.customer_requestitem_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final CustomerRequestModel singlecustreqmodel = custreqlist.get(position);

        holder.txtreqid.setText(String.valueOf(singlecustreqmodel.getReqid()));
        holder.txtreqcustnm.setText(singlecustreqmodel.getReqcustname());
        holder.txtreqroomtype.setText(singlecustreqmodel.getReqroomtype());
        holder.txtreqtenantype.setText(singlecustreqmodel.getReqtenanttype());
        holder.txtreqdate.setText(singlecustreqmodel.getReqdate());
        holder.txtreqcustmb.setText(singlecustreqmodel.getReqMobNo());

        holder.reqviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewintent = new Intent(context8, CustomerRequestViewActivity.class);

                viewintent.putExtra("reqModel",singlecustreqmodel);

                context8.startActivity(viewintent);
            }
        });
    }
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView reqimage;
        TextView txtreqid, txtreqcustnm,txtreqroomtype,txtreqtenantype,txtreqdate,txtreqcustmb;
        Button reqviewbtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            reqimage=itemView.findViewById(R.id.custhmimg);
            txtreqid=itemView.findViewById(R.id.reqid);
            txtreqcustnm=itemView.findViewById(R.id.reqcustname);
            txtreqroomtype=itemView.findViewById(R.id.reqroomtype) ;
            txtreqtenantype=itemView.findViewById(R.id.reqtenanttype);
            txtreqdate=itemView.findViewById(R.id.reqdate);
            txtreqcustmb=itemView.findViewById(R.id.reqcustmb);
            reqviewbtn=itemView.findViewById(R.id.viewbtn);
        }
    }
}
