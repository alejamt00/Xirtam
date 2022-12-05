package com.example.xirtammediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

/**
 * Activity que se encarga de las funciones principales de la app
 * Permite reproducir música almacenada de diferentes generos y grupos
 * a través de unos spinner y un botón de play/pause
 */
public class ReproductorActivity extends AppCompatActivity {

    //arrays de tipo string de generos, grupos y canciones
    public String[] generos;
    public String[] gruposBS = {"Matrix","Interestellar"};
    public String[] gruposRA = {"Radiohead","Gorillaz"};
    public String[] gruposI = {"Cariño","El Cuarteto de Nos"};
    public String[] songsMatrix = {"Clubbed to Death","Rock Is Dead"};
    public String[] songsInterestellar = {"Cornfield Chase"};
    public String[] songsRadiohead = {"Creep"};
    public String[] songsGorillaz = {"Feel Good Inc."};
    public String[] songsCarinio = {"Te Brillan"};
    public String[] songsCuarteto = {"Lo malo de ser bueno"};

    //variables auxiliares necesarias para el founcionamiento de la app
    public int selector;
    public Boolean playIconActive;
    private String source;

    //variables de elementos de la interfaz
    public Spinner spGeneros,spGrupos, spCanciones;
    public ArrayAdapter adapterGrupos, adapterGeneros, adapterSongs;
    public ImageButton playPauseB;
    public MediaPlayer mediaPlayer;
    public WebView matrixEffect;


    /**
     * Método que inicializa valores de la app por defecto y setea algunas partes de la interfaz
     * de forma default
     */
    private void inicializarItems(){

        selector = 0;
        playIconActive = true;
        source = "bs_clubbed_to_death";
        generos = new String[3];
        generos[0] = getString(R.string.bsString);
        generos[1] = getString(R.string.rockString);
        generos[2] = getString(R.string.indieString);

        matrixEffect = findViewById(R.id.matrixBar);
        matrixEffect.getSettings().setJavaScriptEnabled(true);
        matrixEffect.getSettings().setLoadWithOverviewMode(true);
        matrixEffect.getSettings().setUseWideViewPort(true);
        matrixEffect.setInitialScale(1);
        matrixEffect.setBackgroundColor(Color.BLACK);
        matrixEffect.onPause();
        matrixEffect.loadUrl("https://geekprank.com/matrix-code-rain/");

        spGeneros = findViewById(R.id.spinnerGeneros);
        spGrupos = findViewById(R.id.spinnerGrupos);
        spCanciones = findViewById(R.id.spinnerCanciones);
        playPauseB = findViewById(R.id.buttonPlayPause);
        int sound_id = getApplicationContext().getResources().getIdentifier(source, "raw",
                getApplicationContext().getPackageName());
        mediaPlayer = MediaPlayer.create(this, sound_id);
        mediaPlayer.setLooping(false);

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

    /**
     * Setea la variable "source" con el nombre de archivo según la cancion seleccionada en el spinner
     * de canciones
     */
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

    /**
     * En funcion de "i", sete los grupos del spinner de grupos
     *
     * @param i : indice del spinner de géneros
     */
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


    /**
     * Setea el spinner de canciones según el valor de "i" con canciones de algun grupo de Rock Alternativo
     *
     * @param i : indice de grupo seleccionado en el spinner de grupos
     */
    public void setSongsRA(int i) {

        switch (i){
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

    /**
     * Setea el spinner de canciones según el valor de "i" con canciones de algun grupo de Banda Sonora
     *
     * @param i : indice de grupo seleccionado en el spinner de grupos
     */
    public void setSongsBS(int i) {

        switch (i){
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

    /**
     * Setea el spinner de canciones según el valor de "i" con canciones de algun grupo de Indie
     *
     * @param i : indice de grupo seleccionado en el spinner de grupos
     */
    public void setSongsI(int i) {

        switch (i){
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

    /**
     * Setea el icono de play al botón playPauseB
     */
    public void playIcon(){
        playPauseB.setBackgroundResource(R.drawable.play_icon);
        playIconActive = true;
    }

    /**
     * Setea el icono de pause al botón playPauseB
     */
    public void pauseIcon(){
        playPauseB.setBackgroundResource(R.drawable.pause_icon);
        playIconActive = false;
    }

    /**
     * """Listener""" que se ejecuta cuando el usuario deja la app
     */
    @Override
    protected void onUserLeaveHint (){
        matrixEffect.onPause();
        mediaPlayer.pause();
        playIcon();
    }

    /**
     * """Listener""" que se ejecuta cuando el usuario gira el dispositivo, después de demasiado tiempo minimizada... etc
     */
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer.stop();
    }

    /**
     * Método que se ejecuta cuando se crea la actividad
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        getSupportActionBar().hide();

        //inicializamos los items
        inicializarItems();

        //listener del spinner de géneros
        spGeneros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    playIcon();
                    matrixEffect.onPause();
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

        //listener del spinner de grupos
        spGrupos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    playIcon();
                    matrixEffect.onPause();
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

        //listener del spinner de canciones
        spCanciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(mediaPlayer != null && mediaPlayer.isPlaying()){
                    playIcon();
                    matrixEffect.onPause();
                    mediaPlayer.stop();
                }
                //sete la variable source con el nombre del archivo de la cancion seleccionada
                setSongSource();
                int sound_id = getApplicationContext().getResources().getIdentifier(source, "raw",
                        getApplicationContext().getPackageName());

                if(sound_id != 0) {
                    mediaPlayer.release(); //TODO
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), sound_id);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //nothing
            }
        });

        //listener del boton play/pause
        playPauseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playIconActive){
                    pauseIcon();
                    matrixEffect.onResume();
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            playIcon();
                            Log.v("[osaki]", "Se acabó la cancion");
                        }
                    });
                } else {
                    playIcon();
                    matrixEffect.onPause();
                    mediaPlayer.pause();
                }
            }
        });

    }

}