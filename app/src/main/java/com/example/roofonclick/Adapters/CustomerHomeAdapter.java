package com.example.roofonclick.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roofonclick.Activities.CustomerHomeDetailsActivity;
import com.example.roofonclick.Activities.RegistrationActivity;
import com.example.roofonclick.DataModels.CustomerFavouriteModel;
import com.example.roofonclick.DataModels.CustomerHomeModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;
import com.example.roofonclick.Utilities.DatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class CustomerHomeAdapter extends RecyclerView.Adapter<CustomerHomeAdapter.MyViewHolder>
{
    List<CustomerHomeModel> custhomelist;
    Context context4;

    public CustomerHomeAdapter(List<CustomerHomeModel> custhomelist, Context context4) {
        this.custhomelist = custhomelist;
        this.context4 = context4;
    }

    @Override
    public int getItemCount() {
        return custhomelist.size();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context4)
        .inflate(R.layout.customerhome_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position)
    {
        final CustomerHomeModel singlecusthomemodel=custhomelist.get(position);
        holder.image.setImageBitmap(CustomerHomeUtility.imgConvertFromByteArrayToBitmap(singlecusthomemodel.img));
        holder.txtprice.setText(context4.getResources().getString(R.string.rs_symbol)+""+CustomerHomeUtility.convertIntToString(singlecusthomemodel.price));
        holder.txtcity.setText(singlecusthomemodel.getCity()+" ,");
        holder.txtstate.setText(singlecusthomemodel.getState());
        holder.txtroomtype.setText(singlecusthomemodel.getRoomtype());
        holder.txttenanttype.setText(singlecusthomemodel.getTenanttype());

        holder.hmdetailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hmdetailintent=new Intent(context4,CustomerHomeDetailsActivity.class);

                hmdetailintent.putExtra("Owner Id",singlecusthomemodel.getOwnerid());
                hmdetailintent.putExtra("RoomId",singlecusthomemodel.getRoomid());
                hmdetailintent.putExtra("Room Type",singlecusthomemodel.getRoomtype());
                hmdetailintent.putExtra("Tenant Type",singlecusthomemodel.getTenanttype());
                hmdetailintent.putExtra("Address",singlecusthomemodel.getAddress());
                hmdetailintent.putExtra("Area",singlecusthomemodel.getArea());
                hmdetailintent.putExtra("State",singlecusthomemodel.getState());
                hmdetailintent.putExtra("City",singlecusthomemodel.getCity());
                hmdetailintent.putExtra("Price",singlecusthomemodel.price);
                hmdetailintent.putExtra("Description",singlecusthomemodel.getDescr());

                context4.startActivity(hmdetailintent);
            }
        });
        holder.favoriteicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable old = AppCompatResources.getDrawable(context4,R.drawable.custhomefav);
                Drawable newDraw = DrawableCompat.wrap(old);
                DrawableCompat.setTint(newDraw, Color.RED);
                holder.favoriteicon.setImageDrawable(newDraw);


                CustomerFavouriteModel customerFavouriteModel = new CustomerFavouriteModel();
                customerFavouriteModel.setFimg(singlecusthomemodel.getImg());
                customerFavouriteModel.setFroomid(singlecusthomemodel.getRoomid());
                customerFavouriteModel.setFroomtype(singlecusthomemodel.getRoomtype());
                customerFavouriteModel.setFtenanttype(singlecusthomemodel.getTenanttype());
                customerFavouriteModel.setFaddress(singlecusthomemodel.getAddress());
                customerFavouriteModel.setFcity(singlecusthomemodel.getCity());
                customerFavouriteModel.setFstate(singlecusthomemodel.getState());
                customerFavouriteModel.setFprice(singlecusthomemodel.getPrice());

                DatabaseClient.getInstance(context4)
                        .getAppDatabaseClient().customerHomeFavouriteModelDao()
                        .insertCustomerFavouriteModel(customerFavouriteModel);

                Toast.makeText(context4, "Favourite Added", Toast.LENGTH_SHORT).show();
            }

        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image,favoriteicon;
        TextView txtprice,txtroomtype,txttenanttype,txtcity,txtstate;
        Button hmdetailbtn,hmcontactbtn;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            image=itemView.findViewById(R.id.custhmimg);
            txtprice= itemView.findViewById(R.id.custprice);
            txtcity= itemView.findViewById(R.id.custcity);
            txtstate=itemView.findViewById(R.id.custstate);
            txtroomtype=itemView.findViewById(R.id.custroomtype);
            txttenanttype= itemView.findViewById(R.id.custtenanttype);
            hmdetailbtn=itemView.findViewById(R.id.detailbtn);
            favoriteicon=itemView.findViewById(R.id.fav);
        }
    }
}
