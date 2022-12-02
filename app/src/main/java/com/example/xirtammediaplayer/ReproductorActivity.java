package com.example.xirtammediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ReproductorActivity extends AppCompatActivity {

    public String generos[] = {"Bandas Sonoras","Rock Alternativo","Indie"};

    public String gruposBS[] = {"Matrix","Interestellar"};
    public String gruposRA[] = {"Radiohead","Gorillaz"};
    public String gruposI[] = {"Cariño","El Cuarteto de Nos"};

    public String songsMatrix[] = {"Matrix Main Theme"};
    public String songsInterestellar[] = {"Cornfield Chase"};
    public String songsRadiohead[] = {"Creep"};
    public String songsGorillaz[] = {"Feel Good Inc."};
    public String songsCariño[] = {"Te Brillan"};
    public String songsCuarteto[] = {"Lo malo de ser bueno","Algo mejor que hacer"};


    public Spinner spGeneros,spGrupos, spCanciones;
    public ArrayAdapter adapterGrupos;

    public void setGrupos(int i){

        switch (i){
            case 0:
                adapterGrupos = new ArrayAdapter(this, R.layout.spinner_item_layout, gruposBS);
                adapterGrupos.setDropDownViewResource(R.layout.custom_dropdown);
                spGrupos.setAdapter(adapterGrupos);
                break;
            case 1:
                adapterGrupos = new ArrayAdapter(this, R.layout.spinner_item_layout, gruposRA);
                adapterGrupos.setDropDownViewResource(R.layout.custom_dropdown);
                spGrupos.setAdapter(adapterGrupos);
                break;
            case 2:
                adapterGrupos = new ArrayAdapter(this, R.layout.spinner_item_layout, gruposI);
                adapterGrupos.setDropDownViewResource(R.layout.custom_dropdown);
                spGrupos.setAdapter(adapterGrupos);
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        getSupportActionBar().hide();

        spGeneros = findViewById(R.id.spinnerGeneros);
        spGrupos = findViewById(R.id.spinnerGrupos);
        spCanciones = findViewById(R.id.spinnerCanciones);

        ArrayAdapter adapterGeneros = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_layout, generos);
        adapterGeneros.setDropDownViewResource(R.layout.custom_dropdown);
        spGeneros.setAdapter(adapterGeneros);


        spGeneros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setGrupos(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                setGrupos(1);
            }

        });

        //setear canciones TODO

        /*
        ArrayAdapter adapterCanciones = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_layout, generos);
        adapterCanciones.setDropDownViewResource(R.layout.custom_dropdown);
        spCanciones.setAdapter(adapterCanciones);*/



    }
}