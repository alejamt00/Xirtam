package com.example.xirtammediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

/**
 * MainActivity que lanza el fragmento de login
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new LoginFragment())
                .commit();
    }
}