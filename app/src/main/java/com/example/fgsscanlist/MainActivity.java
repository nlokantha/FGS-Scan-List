package com.example.fgsscanlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fgsscanlist.Fragments.HomeFragment;
import com.example.fgsscanlist.Fragments.LoginFragment;
import com.example.fgsscanlist.Fragments.ViewFragment;
import com.example.fgsscanlist.Models.Auth;
import com.example.fgsscanlist.Models.FgsScanList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoginFragment.LoginFragmentListener,
        HomeFragment.HomeFragmentListener, ViewFragment.ViewFragmentListener {
    Auth mAuth;
    ArrayList<FgsScanList> mlists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new LoginFragment())
                .commit();
    }

    @Override
    public void authSuccessfully(Auth auth) {
        this.mAuth = auth;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, HomeFragment.newInstance(mAuth))
                .commit();
    }

    @Override
    public void gotoViewFragment(ArrayList<FgsScanList> lists) {
        this.mlists = lists;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView,ViewFragment.newInstance(lists))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void logout() {
        mAuth = null;
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new LoginFragment())
                .commit();
    }

    @Override
    public void gotoHomeFragment() {
        mlists = null;
        getSupportFragmentManager().popBackStack();
    }
}