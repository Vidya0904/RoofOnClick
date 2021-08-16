package com.example.roofonclick.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roofonclick.DataModels.CustomerRequestModel;
import com.example.roofonclick.DataModels.OwnerHomeModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class OwnerRequestAdapter extends RecyclerView.Adapter<OwnerRequestAdapter.MyViewHolder>
{
    List<CustomerRequestModel> custreqlist;
    Context context;

    public OwnerRequestAdapter(List<CustomerRequestModel> custreqlist, Context context) {
        this.custreqlist = custreqlist;
        this.context = context;
    }

    @Override
    public int getItemCount()
    {
        return custreqlist.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.ownerhome_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        final CustomerRequestModel singleownhmmodel=custreqlist.get(position);
        holder.txtownroomid.setText( CustomerHomeUtility.convertIntToString(singleownhmmodel.getReqid()));
        holder.txtcustname.setText(singleownhmmodel.getReqcustname());
        holder.txtreqdate.setText(singleownhmmodel.getReqdate());
        holder.txtcustmobile.setText(singleownhmmodel.getReqMobNo());
        holder.room_image.setImageBitmap(CustomerHomeUtility.imgConvertFromByteArrayToBitmap(singleownhmmodel.reqImage));

        holder.txtcustmobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mbintent = new Intent(Intent.ACTION_CALL);
                mbintent.setData(Uri.parse("tel:"+singleownhmmodel.getReqMobNo()));
                context.startActivity(mbintent);
            }
        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtownroomid,txtcustname ,txtcustmobile,txtreqdate;
        CircleImageView room_image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtownroomid=itemView.findViewById(R.id.textownerroomid);
            txtcustname=itemView.findViewById(R.id.textitemcustname);
            txtreqdate=itemView.findViewById(R.id.textreqdate);
            txtcustmobile=itemView.findViewById(R.id.textitemcustmobile);
            room_image=itemView.findViewById(R.id.room_image);



        }
    }


}
