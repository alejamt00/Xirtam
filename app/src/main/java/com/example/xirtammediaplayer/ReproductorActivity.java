package com.example.xirtammediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.io.IOException;

public class ReproductorActivity extends AppCompatActivity {

    public String[] generos = {"Bandas Sonoras","Rock Alternativo","Indie"};

    public String[] gruposBS = {"Matrix","Interestellar"};
    public String[] gruposRA = {"Radiohead","Gorillaz"};
    public String[] gruposI = {"Cariño","El Cuarteto de Nos"};
    public String[] songsMatrix = {"Clubbed to Death","Rock Is Dead"};
    public String[] songsInterestellar = {"Cornfield Chase"};
    public String[] songsRadiohead = {"Creep"};
    public String[] songsGorillaz = {"Feel Good Inc."};
    public String[] songsCarinio = {"Te Brillan"};
    public String[] songsCuarteto = {"Lo malo de ser bueno"};

    public int selector;
    public Boolean playIconActive;
    private String source;

    public Spinner spGeneros,spGrupos, spCanciones;
    public ArrayAdapter adapterGrupos, adapterGeneros, adapterSongs;
    public ImageButton playPauseB;
    public MediaPlayer mediaPlayer;


    public void setSongSource(){
        switch (spCanciones.getSelectedItem().toString()){
            case "Clubbed to Death":
                source = "bs_clubbed_to_death";
                break;
            case "Rock Is Dead":
                source = "bs_rock_is_dead";
                break;
            case "Cornfield Chase":
                source = "bs_cornfield_chase";
                break;
            case "Creep":
                source = "ra_creep";
                break;
            case "Feel Good Inc.":
                source = "ra_feel_good_inc";
                break;
            case "Te Brillan":
                source = "i_te_brillan";
                break;
            case "Lo malo de ser bueno":
                source = "i_lo_malo_de_ser_bueno";
                break;
        }
    }

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
                adapterSongs = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_layout, songsCarinio);
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

    private void inicializarItems(){

        selector = 0;
        playIconActive = true;
        source = "bs_clubbed_to_death";

        spGeneros = findViewById(R.id.spinnerGeneros);
        spGrupos = findViewById(R.id.spinnerGrupos);
        spCanciones = findViewById(R.id.spinnerCanciones);
        playPauseB = findViewById(R.id.buttonPlayPause);
        int sound_id = getApplicationContext().getResources().getIdentifier(source, "raw",
                getApplicationContext().getPackageName());
        mediaPlayer = MediaPlayer.create(this, sound_id);

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

    public void playIcon(){
        playPauseB.setBackgroundResource(R.drawable.play_icon);
        playIconActive = true;
    }

    public void pauseIcon(){
        playPauseB.setBackgroundResource(R.drawable.pause_icon);
        playIconActive = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        getSupportActionBar().hide();

        inicializarItems();

        spGeneros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    playIcon();
                    mediaPlayer.stop();
                }

                setGrupos(position);
                selector = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                //nothing
            }
        });

        spGrupos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    playIcon();
                    mediaPlayer.stop();
                }

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
                //nothing
            }
        });

        spCanciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    playIcon();
                    mediaPlayer.stop();
                }

                setSongSource();
                int sound_id = getApplicationContext().getResources().getIdentifier(source, "raw",
                        getApplicationContext().getPackageName());

                if(sound_id != 0) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), sound_id);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //nothing
            }
        });

        playPauseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playIconActive){
                    pauseIcon();
                    mediaPlayer.start();
                } else {
                    playIcon();
                    mediaPlayer.pause();
                }
            }
        });
    }

}