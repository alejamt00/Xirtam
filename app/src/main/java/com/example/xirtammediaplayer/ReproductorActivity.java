package com.example.xirtammediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class ReproductorActivity extends AppCompatActivity {

    public String test[] = {"Test1","Test2","Test3"};
    public Spinner spTest;

    public static GradientDrawable backgroundWithBorder(int bgcolor,
                                                        int brdcolor) {

        GradientDrawable gdDefault = new GradientDrawable();
        gdDefault.setColor(bgcolor);
        gdDefault.setStroke(2, brdcolor);
        gdDefault.setCornerRadii(new float[] { 2, 2, 0, 0, 0, 0,
                2, 2 });

        return gdDefault;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        getSupportActionBar().hide();

        spTest = findViewById(R.id.spinner);
        ArrayAdapter adapterTest = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, test);
        spTest.setAdapter(adapterTest);


    }
}