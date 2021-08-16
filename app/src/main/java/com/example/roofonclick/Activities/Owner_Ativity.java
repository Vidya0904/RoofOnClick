package com.example.roofonclick.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.roofonclick.Fragments.AddRoom;
import com.example.roofonclick.Fragments.CustomerList;
import com.example.roofonclick.Fragments.HomeFragment;
import com.example.roofonclick.Fragments.OwnerProfile;
import com.example.roofonclick.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Owner_Ativity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bnview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_bottom_navigation);

        bnview=findViewById(R.id.navigation);
        bnview.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        if (menuItem.getItemId() == R.id.hm)
        {
            FragmentManager frm = getSupportFragmentManager();
            FragmentTransaction frt = frm.beginTransaction();
            frt.replace(R.id.owner_frag,new HomeFragment());
            frt.commit();
        }

        if (menuItem.getItemId() == R.id.addroom)
        {
            FragmentManager frm = getSupportFragmentManager();
            FragmentTransaction frt = frm.beginTransaction();
            frt.replace(R.id.owner_frag,new AddRoom());
            frt.commit();
        }

        if (menuItem.getItemId() == R.id.ownerprofile)
        {
            FragmentManager frm = getSupportFragmentManager();
            FragmentTransaction frt = frm.beginTransaction();
            frt.replace(R.id.owner_frag,new OwnerProfile());
            frt.commit();
        }

        if (menuItem.getItemId() == R.id.custlist)
        {
            FragmentManager frm = getSupportFragmentManager();
            FragmentTransaction frt = frm.beginTransaction();
            frt.replace(R.id.owner_frag,new CustomerList() );
            frt.commit();
        }

        return true;
    }
}
