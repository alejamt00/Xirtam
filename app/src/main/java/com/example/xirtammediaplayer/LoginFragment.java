package com.example.xirtammediaplayer;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 *  Fragmento que se lanza desde MainActivity y muestra la información de login
 *  (Cuadros de texto y botón de inicio)
 */
public class LoginFragment extends Fragment {

    // No los utilizaré por ahora
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // No los utilizaré por ahora
    private String mParam1;
    private String mParam2;

    //Constructor vacío
    public LoginFragment() {
    }

    /**
     * Constructor parametrizado, no usado
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Metodo que setea mParam1 y mParam2 a los argumentos pasados por el constructor fuera de la clase
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * Listener de boton para poder entrar y comprobar las credenciales introducidas por los editText
     * Si son correctas (admin - 1234), iniciará la actividad del reproductor
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ImageView imgLogin = view.findViewById(R.id.icoLogin);
        Button btEnter = view.findViewById(R.id.loginButton);
        EditText etUser = view.findViewById(R.id.loginNameField);
        EditText etPass = view.findViewById(R.id.loginPassField);

        btEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etUser.getText().toString().equals("admin") && etPass.getText().toString().equals("1234")){ //usuario y contraseña correcta
                    Intent i = new Intent(getActivity(),ReproductorActivity.class);
                    startActivity(i);
                } else {
                    // fallo al iniciar
                    Intent i = new Intent(getActivity(),LoginErrorActivity.class);
                    startActivity(i);
                }

            }
        });




        return view;
    }
}