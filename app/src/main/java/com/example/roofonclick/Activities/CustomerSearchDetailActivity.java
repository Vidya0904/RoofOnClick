package com.example.roofonclick.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.roofonclick.DataModels.CustomerHomeModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;
import com.example.roofonclick.Utilities.DatabaseClient;

public class CustomerSearchDetailActivity extends AppCompatActivity {
    ImageView SDimg;
    TextView SDprice, SDroomtype, SDaddress, SDdescription;
    RatingBar SDratingbar;
    CustomerHomeModel customerHomeModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_searchdetail_layout);

        SDimg = findViewById(R.id.searchdetailimg);
        SDprice = findViewById(R.id.searchdetailprice);
        SDroomtype = findViewById(R.id.searchdetailroomtype);
        SDaddress = findViewById(R.id.searchdetailaddress);
        SDdescription = findViewById(R.id.searchdetaildesc);
        SDratingbar = findViewById(R.id.searchdetailratingbar);

        Intent intent = getIntent();
        int roomId=intent.getIntExtra("RoomId",0);

        customerHomeModel = DatabaseClient
                .getInstance(this)
                .getAppDatabaseClient()
                .customerHomeModelDao()
                .getRoomById((long) roomId);


        SDimg.setImageBitmap(CustomerHomeUtility.imgConvertFromByteArrayToBitmap(customerHomeModel.img));
        SDprice.setText(getResources().getString(R.string.rs_symbol)+""+CustomerHomeUtility.convertIntToString(customerHomeModel.price));
        SDroomtype.setText(customerHomeModel.getRoomtype());
        SDaddress.setText(customerHomeModel.getAddress());
        SDdescription.setText(customerHomeModel.getDescr());


    }
}
