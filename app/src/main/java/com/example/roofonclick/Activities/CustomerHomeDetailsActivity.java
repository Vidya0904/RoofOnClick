package com.example.roofonclick.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.roofonclick.DataModels.CustomerHomeModel;
import com.example.roofonclick.DataModels.CustomerRequestModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;
import com.example.roofonclick.Utilities.DatabaseClient;
import com.example.roofonclick.Utilities.Shared_Preference_Manager;

public class CustomerHomeDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    TextView detailPrice,detailRoomType,detailAddress,detailDescription;
    RatingBar detailRatingbar;
    ImageView detailimg;
    Button custmakerequest;
    CustomerHomeModel customerHomeModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerhomedetail_layout_activity);

        detailPrice = findViewById(R.id.Dprice);
        detailRoomType = findViewById(R.id.Droomtype);
        detailAddress = findViewById(R.id.Daddress);
        detailRatingbar = findViewById(R.id.Dratingbar);
        detailDescription = findViewById(R.id.Ddescription);
        detailimg = findViewById(R.id.Dimg);

        custmakerequest=findViewById(R.id.custdetailmakerequest);
        custmakerequest.setOnClickListener(this);

        Intent intent = getIntent();
        int roomId=intent.getIntExtra("RoomId",0);

        customerHomeModel = DatabaseClient
                .getInstance(this)
                .getAppDatabaseClient()
                .customerHomeModelDao()
                .getRoomById((long) roomId);

        detailimg.setImageBitmap(CustomerHomeUtility.imgConvertFromByteArrayToBitmap(customerHomeModel.img));
        detailPrice.setText(getResources().getString(R.string.rs_symbol)+""+CustomerHomeUtility.convertIntToString(customerHomeModel.price));
        detailRoomType.setText(customerHomeModel.getRoomtype());
        detailAddress.setText(customerHomeModel.getAddress());
        detailDescription.setText(customerHomeModel.getDescr());


    }

    @Override
    public void onClick(View v)
    {

        CustomerRequestModel customerRequestModel=new CustomerRequestModel();

        customerRequestModel.setReqtenanttype(customerHomeModel.getTenanttype());
        customerRequestModel.setReqroomtype(customerHomeModel.getRoomtype());
        customerRequestModel.setOwnerid(customerHomeModel.getOwnerid());
        customerRequestModel.setReqdate(CustomerHomeUtility.getDateAndTime());
        customerRequestModel.setReqcustname(Shared_Preference_Manager.getUser_Email(this));
        customerRequestModel.setReqMobNo(Shared_Preference_Manager.getUser_Mob_No(this));
        customerRequestModel.setReqImage(customerHomeModel.getImg());


        DatabaseClient.getInstance(this)
                .getAppDatabaseClient()
                .customerHomeRequestModelDao()
                .insetCustomerHomeRequestModel(customerRequestModel);

        Toast.makeText(this, "Request Added", Toast.LENGTH_SHORT).show();
    }
}
