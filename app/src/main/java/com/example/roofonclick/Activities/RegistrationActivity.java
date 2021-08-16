package com.example.roofonclick.Activities;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.roofonclick.DataModels.UserModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.CustomerHomeUtility;
import com.example.roofonclick.Utilities.DatabaseClient;
import com.example.roofonclick.Utilities.EmailMobileValidator;
import com.example.roofonclick.Utilities.Shared_Preference_Manager;
import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity
{
    Button registrationbtn;
    RadioButton ownerrdobtn,customerrdobtn;
    RadioGroup rdgroup1,rdgroup2;
    TextInputEditText edtname,edtemail,edtpass,edtmb;
    TextView txtsignin;
    private ImageView regimg;

    private int PICK_IMAGE = 25;
    private Bitmap imgbit;
    BitmapFactory.Options options;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
        getSupportActionBar().setTitle("REGISTRATION");

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA},44);

        txtsignin=findViewById(R.id.signin);
        edtname=findViewById(R.id.fname);
        edtemail=findViewById(R.id.email);
        edtpass=findViewById(R.id.pass);
        edtmb=findViewById(R.id.mobile);
        ownerrdobtn=findViewById(R.id.ownerrdo);
        customerrdobtn=findViewById(R.id.customerrdo);
        rdgroup1=findViewById(R.id.rdgr1);
        rdgroup2=findViewById(R.id.rdgr2);

        regimg=findViewById(R.id.regprofileimg);
        regimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == regimg.getId())
                {
                  Intent pickphoto = new Intent(Intent.ACTION_PICK,
                          MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                  startActivityForResult(pickphoto,PICK_IMAGE);
                }

            }
        });

        registrationbtn=findViewById(R.id.regbtn);
        registrationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EmailMobileValidator emailmobilevalidator = new EmailMobileValidator();

                if (!TextUtils.isEmpty(edtname.getText().toString())
                &&  !TextUtils.isEmpty(edtemail.getText().toString())
                &&  !TextUtils.isEmpty(edtpass.getText().toString())
                &&  !TextUtils.isEmpty(edtmb.getText().toString()))
                {
                    if (emailmobilevalidator.validate(edtemail.getText().toString()) == true
                     && emailmobilevalidator.mobvalidate(edtmb.getText().toString()))
                    {
                        UserModel usermodel = new UserModel();

                        usermodel.setUsername(edtname.getText().toString());
                        usermodel.setEmail(edtemail.getText().toString());
                        usermodel.setPassword(edtpass.getText().toString());
                        usermodel.setMobno(edtmb.getText().toString());
                        usermodel.setUsertype(getUserTypeValue());
                        usermodel.setUserImage(CustomerHomeUtility.imgConvertFromBitmapToByteArray(imgbit));

                        long uId = DatabaseClient
                                .getInstance(getApplicationContext())
                                .getAppDatabaseClient().userDaos()
                                .insertUserModel(usermodel);

                        Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                        Shared_Preference_Manager.setUser_ID(RegistrationActivity.this,(int)uId);
                        Shared_Preference_Manager.setGender(RegistrationActivity.this, getGenderButtonValue());
                        Shared_Preference_Manager.setUser_Type(RegistrationActivity.this, getUserTypeValue());
                        Shared_Preference_Manager.setUser_Mob_No(RegistrationActivity.this,
                                edtmb.getText().toString());
                        Shared_Preference_Manager.setUser_Email(RegistrationActivity.this, edtemail.getText().toString());
                        Shared_Preference_Manager.setUser_Name(RegistrationActivity.this, edtname.getText().toString());

                        Intent intent = new Intent(RegistrationActivity.this,Login_Activity.class);
                        intent.putExtra("usertype", getUserTypeValue());
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(RegistrationActivity.this, "Please Enter Valid Mobile No. or Email", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(RegistrationActivity.this, "Please Enter all Fields", Toast.LENGTH_SHORT).show();
                }
            }

        });

        txtsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistrationActivity.this,Login_Activity.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && data != null)
        {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            if (selectedImage != null)
            {
                Cursor cursor = this.getContentResolver().query(selectedImage, filePathColumn,
                        null, null,  null);
                if (cursor != null)
                {
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    imgbit = BitmapFactory.decodeFile(picturePath,options);
                    regimg.setImageBitmap(imgbit);
                    cursor.close();
                }
            }
        }
    }



    private String getGenderButtonValue()
    {
        int chkId=rdgroup1.getCheckedRadioButtonId();
        if (chkId==R.id.rbmale)
        {
            return "Male";
        }
        else
        {
            return "Female";
        }
    }

    private String getUserTypeValue()
    {
        int chkusertype=rdgroup2.getCheckedRadioButtonId();
        if (chkusertype==R.id.ownerrdo)
        {
            return "Owner" ;
        }
        else
        {
            return "Customer";
        }
    }
}
