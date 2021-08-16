package com.example.roofonclick.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roofonclick.DataModels.CustomerFavouriteModel;
import com.example.roofonclick.DataModels.CustomerHomeModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerFavouriteUtility;
import com.example.roofonclick.Utilities.DatabaseClient;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class CustomerFavouriteAdapter extends RecyclerView.Adapter<CustomerFavouriteAdapter.MyViewHolder>
{
    List<CustomerFavouriteModel> custfavlist;
    Context context6;

    public CustomerFavouriteAdapter(List<CustomerFavouriteModel> custfavlist, Context context6) {
        this.custfavlist = custfavlist;
        this.context6 = context6;
    }


    @Override
    public int getItemCount() {
        return custfavlist.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context6)
        .inflate(R.layout.customerfav_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerFavouriteAdapter.MyViewHolder holder, final int position) {
        final CustomerFavouriteModel singlecustfavmodel=custfavlist.get(position);

        holder.favimage.setImageBitmap(CustomerFavouriteUtility.imgConvertFromByteArrayToBitmap(singlecustfavmodel.fimg));
        holder.ftxtprice.setText(context6.getResources().getString(R.string.rs_symbol)+""+CustomerFavouriteUtility.convertIntToString(singlecustfavmodel.fprice));
        holder.ftxtcity.setText(singlecustfavmodel.getFcity()+" ,");
        holder.ftxtstate.setText(singlecustfavmodel.getFstate());
        holder.ftxtroomtype.setText(singlecustfavmodel.getFroomtype());
        holder.ftxttenanttype.setText(singlecustfavmodel.getFtenanttype());

        holder.favdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseClient.getInstance(context6)
                        .getAppDatabaseClient()
                        .customerHomeFavouriteModelDao()
                        .deleteCustomerFavouriteModel(singlecustfavmodel);
                custfavlist.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView favimage,favdelete;
        TextView ftxtprice,ftxtroomtype,ftxttenanttype,ftxtcity,ftxtstate;

        public MyViewHolder(View itemView) {
            super(itemView);
            favimage=itemView.findViewById(R.id.custfavimg);
            ftxtprice= itemView.findViewById(R.id.custfavprice);
            ftxtcity= itemView.findViewById(R.id.custfavcity);
            ftxtstate=itemView.findViewById(R.id.custfavstate);
            ftxtroomtype=itemView.findViewById(R.id.custfavroomtype);
           ftxttenanttype= itemView.findViewById(R.id.custfavtenanttype);
           favdelete= itemView.findViewById(R.id.favremove);

        }
    }
}
