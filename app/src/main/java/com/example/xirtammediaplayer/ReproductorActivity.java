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

    public String songsMatrix[] = {"Clubbed to Death","Rock Is Dead"};
    public String songsInterestellar[] = {"Cornfield Chase"};
    public String songsRadiohead[] = {"Creep"};
    public String songsGorillaz[] = {"Feel Good Inc."};
    public String songsCariño[] = {"Te Brillan"};
    public String songsCuarteto[] = {"Lo malo de ser bueno"};

    public int selector;


    public Spinner spGeneros,spGrupos, spCanciones;
    public ArrayAdapter adapterGrupos, adapterGeneros, adapterSongs;



    public void setGrupos(int i){

        switch (i){
            case 0:
                adapterGrupos = new ArrayAdapter(this, R.layout.spinner_item_layout, gruposBS);
                adapterGrupos.setDropDownViewResource(R.layout.custom_dropdown);
                spGrupos.setAdapter(adapterGrupos);
                setSongsBS(0);
                break;
            case 1:
                adapterGrupos = new ArrayAdapter(this, R.layout.spinner_item_layout, gruposRA);
                adapterGrupos.setDropDownViewResource(R.layout.custom_dropdown);
                spGrupos.setAdapter(adapterGrupos);
                setSongsRA(0);
                break;
            case 2:
                adapterGrupos = new ArrayAdapter(this, R.layout.spinner_item_layout, gruposI);
                adapterGrupos.setDropDownViewResource(R.layout.custom_dropdown);
                spGrupos.setAdapter(adapterGrupos);
                setSongsI(0);
                break;
        }

    }


    public void setSongsRA(int songId) {

        switch (songId){
            case 0:
                adapterSongs = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_layout, songsRadiohead);
                adapterSongs.setDropDownViewResource(R.layout.custom_dropdown);
                spCanciones.setAdapter(adapterSongs);
                break;
            case 1:
                adapterSongs = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_layout, songsGorillaz);
                adapterSongs.setDropDownViewResource(R.layout.custom_dropdown);
                spCanciones.setAdapter(adapterSongs);
                break;
        }

    }

    public void setSongsBS(int songId) {

        switch (songId){
            case 0:
                adapterSongs = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_layout, songsMatrix);
                adapterSongs.setDropDownViewResource(R.layout.custom_dropdown);
                spCanciones.setAdapter(adapterSongs);
                break;
            case 1:
                adapterSongs = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_layout, songsInterestellar);
                adapterSongs.setDropDownViewResource(R.layout.custom_dropdown);
                spCanciones.setAdapter(adapterSongs);
                break;
        }

    }

    public void setSongsI(int songId) {

        switch (songId){
            case 0:
                adapterSongs = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_layout, songsCariño);
                adapterSongs.setDropDownViewResource(R.layout.custom_dropdown);
                spCanciones.setAdapter(adapterSongs);
                break;
            case 1:
                adapterSongs = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_layout, songsCuarteto);
                adapterSongs.setDropDownViewResource(R.layout.custom_dropdown);
                spCanciones.setAdapter(adapterSongs);
                break;
        }

    }

    private void inicializarSpinners(){

        selector = 0;

        spGeneros = findViewById(R.id.spinnerGeneros);
        spGrupos = findViewById(R.id.spinnerGrupos);
        spCanciones = findViewById(R.id.spinnerCanciones);

        adapterGeneros = new ArrayAdapter(this, R.layout.spinner_item_layout, generos);
        adapterGeneros.setDropDownViewResource(R.layout.custom_dropdown);
        spGeneros.setAdapter(adapterGeneros);

        adapterGrupos = new ArrayAdapter(this, R.layout.spinner_item_layout, gruposBS);
        adapterGrupos.setDropDownViewResource(R.layout.custom_dropdown);
        spGrupos.setAdapter(adapterGrupos);

        adapterSongs = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_layout, songsMatrix);
        adapterSongs.setDropDownViewResource(R.layout.custom_dropdown);
        spCanciones.setAdapter(adapterSongs);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        getSupportActionBar().hide();

        inicializarSpinners();

        spGeneros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                setGrupos(position);
                selector = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        spGrupos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (selector){
                    case 0:
                        setSongsBS(i);
                        break;
                    case 1:
                        setSongsRA(i);
                        break;
                    case 2:
                        setSongsI(i);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}