package com.example.xirtammediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

/**
 *   Activity que se muestra cuando el usuario o contraseña es incorrecto:
 *      En mi caso, cuando el usuario y contraseña no son admin - 1234 respectivamente
 */
public class LoginErrorActivity extends AppCompatActivity {

    /**
     *   Método que se ejecuta cuando se crea la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_error);
        getSupportActionBar().hide();

        /**
         *   Durante 1500ms se muestra la pantalla y después se finaliza
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },1500);
    }
}