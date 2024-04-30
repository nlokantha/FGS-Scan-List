 package com.example.fgsscanlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fgsscanlist.Fragments.HomeFragment;
import com.example.fgsscanlist.Fragments.LoginFragment;

 public class MainActivity extends AppCompatActivity implements LoginFragment.LoginFragmentListener, HomeFragment.HomeFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView,new LoginFragment())
                .commit();
    }

     @Override
     public void authSuccessfully() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView,new HomeFragment())
                .commit();
     }
 }