package com.example.roofonclick.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.roofonclick.DataModels.UserModel;
import com.example.roofonclick.R;
import com.example.roofonclick.Utilities.DatabaseClient;
import com.example.roofonclick.Utilities.Shared_Preference_Manager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class Login_Activity extends AppCompatActivity
{
    FloatingActionButton floatingactionbutton;
    TextInputEditText edtemailid,edtpass;
    TextView lgnregtxt;
    String uType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        uType=getIntent().getStringExtra("usertype");

        floatingactionbutton=findViewById(R.id.login_floating);
        edtemailid=findViewById(R.id.emailid);
        edtpass=findViewById(R.id.password);
        lgnregtxt=findViewById(R.id.regtxt);
        floatingactionbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                if(v.getId() == floatingactionbutton.getId())
                {
                    if(!TextUtils.isEmpty(edtpass.getText().toString())
                    && !TextUtils.isEmpty(edtemailid.getText().toString()))
                    {
                        if (edtpass.getText().toString().equals("Admin")
                         && edtemailid.getText().toString().equals("Admin"))
                        {
                            Intent i=new Intent(Login_Activity.this,Owner_Ativity.class);
                            startActivity(i);
                        }
                        else {
                            UserModel userModel = DatabaseClient.getInstance(getApplicationContext())
                                    .getAppDatabaseClient().userDaos().userLogin(edtemailid.getText().toString()
                                    ,edtpass.getText().toString());

                            if (userModel != null)
                            {

                                Shared_Preference_Manager.setUser_ID(Login_Activity.this, userModel.getID());
                                Shared_Preference_Manager.setUser_Type(Login_Activity.this,userModel.getUsertype());
                                Shared_Preference_Manager.setUser_Mob_No(Login_Activity.this, userModel.getMobno());
                                Shared_Preference_Manager.setUser_Email(Login_Activity.this, userModel.getEmail());
                                if (userModel.getUsertype().equals("Owner"))
                                {
                                    Intent i=new Intent(Login_Activity.this,Owner_Ativity.class);
                                    startActivity(i);
                                }else {
                                    Intent i=new Intent(Login_Activity.this,CustomerHomeActivity.class);
                                    startActivity(i);
                                }
                            }
                            else
                            {
                                Toast.makeText(Login_Activity.this, "You are not Register", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else
                    {
                        Toast.makeText(Login_Activity.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    lgnregtxt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Login_Activity.this,RegistrationActivity.class);
            startActivity(i);
        }
    });
    }

}
