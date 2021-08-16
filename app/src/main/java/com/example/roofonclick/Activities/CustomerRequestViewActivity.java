package com.example.roofonclick.Activities;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.roofonclick.DataModels.CustomerRequestModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;
import com.example.roofonclick.Utilities.DatabaseClient;

public class CustomerRequestViewActivity extends AppCompatActivity
{
    ImageView vimage;
    TextView vEmail,vMobile,vDate;
    Button vContactUs;
    CustomerRequestModel customerRequestModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_requestview_layout);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);

        vimage = findViewById(R.id.viewImage);
        vEmail = findViewById(R.id.viewEmail);
        vMobile = findViewById(R.id.viewCustomerMobile);
        vDate = findViewById(R.id.viewDate);
        vContactUs = findViewById(R.id.viewContactbtn);
        vContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mbintent = new Intent(Intent.ACTION_CALL);
                mbintent.setData(Uri.parse("tel:"+customerRequestModel.getReqMobNo()));
                startActivity(mbintent);
            }
        });

        customerRequestModel= (CustomerRequestModel) getIntent().getSerializableExtra("reqModel");

        vEmail.setText(customerRequestModel.getReqcustname());
        vMobile.setText(customerRequestModel.getReqMobNo());
        vDate.setText(customerRequestModel.getReqdate());
        vimage.setImageBitmap(CustomerHomeUtility.imgConvertFromByteArrayToBitmap(customerRequestModel.reqImage));


    }
}
