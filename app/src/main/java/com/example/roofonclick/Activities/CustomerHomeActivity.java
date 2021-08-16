package com.example.roofonclick.Activities;

import android.os.Bundle;

import com.example.roofonclick.DataModels.UserModel;
import com.example.roofonclick.Fragments.CustomerFavourite;
import com.example.roofonclick.Fragments.CustomerHome;
import com.example.roofonclick.Fragments.CustomerProfile;
import com.example.roofonclick.Fragments.CustomerRequest;
import com.example.roofonclick.Fragments.CustomerSearch;
import com.example.roofonclick.R;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;

import com.example.roofonclick.Utilities.CustomerHomeUtility;
import com.example.roofonclick.Utilities.DatabaseClient;
import com.example.roofonclick.Utilities.Shared_Preference_Manager;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomerHomeActivity extends AppCompatActivity
{
    private NavigationView navview;
    private DrawerLayout drawerlayout;
    Toolbar tbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        tbar = findViewById(R.id.toolbar);
        setSupportActionBar(tbar);

        drawerlayout = findViewById(R.id.drawer_layout);
        navview = findViewById(R.id.nav_view);

        View headerView = navview.getHeaderView(0);
        TextView txtEmail = headerView.findViewById(R.id.headerEmail);

        txtEmail.setText(Shared_Preference_Manager.getUser_Email(this));

        View headerView1 = navview.getHeaderView(0);
        CircleImageView imgprofile = headerView1.findViewById(R.id.imageView);

        UserModel um = DatabaseClient.getInstance(this)
                .getAppDatabaseClient().userDaos()
                .getUserByEmail(Shared_Preference_Manager.getUser_Email(this));

        imgprofile.setImageBitmap(CustomerHomeUtility.imgConvertFromByteArrayToBitmap(um.getUserImage()));



        setUpNavigationView();
    }

    private void setUpNavigationView()
    {
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFrag=null;

                switch (menuItem.getItemId()) {

                    case R.id.custhome:
                        selectedFrag = new CustomerHome();
                        break;

                    case R.id.custprofile:
                        selectedFrag = new CustomerProfile();
                        break;

                    case R.id.custfav:
                        selectedFrag = new CustomerFavourite();
                        break;

                    case R.id.custsearch:
                        selectedFrag = new CustomerSearch();
                        break;

                    case R.id.custreq:
                        selectedFrag = new CustomerRequest();
                        break;
                }

                getSupportFragmentManager()
                        .beginTransaction().replace(R.id.nav_host_fragment,selectedFrag)
                        .commit();

                if(menuItem.isChecked())
                {
                    menuItem.setChecked(false);
                }
                else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                drawerlayout.closeDrawers();
                return true;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerlayout,tbar
        ,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerlayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
