package com.ieeesbumh.expoaltabix2014;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by javierlight on 7/11/14.
 *
 * He unificado todos los grupos en Fragment_Grupos_Trabajo en una mega función [kudo]
 * Este archivo y todos los Fragment_<grupo>.java son redundantes e innecesarios.
 * OJO!! SOLO LOS DE LOS GRUPOS DE TRABAJO (Android, impresora, videojuegos..), no el menu lateral.
 */
public class Fragment_Android extends Fragment {
    public Fragment_Android(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.android_y_java, container, false);


        ImageButton atras = (ImageButton) rootView.findViewById(R.id.boton_atras);
        ImageButton adelante = (ImageButton) rootView.findViewById(R.id.boton_adelante);


        // Esta fue la primera solucion. Poco elegante pero fácil y efectiva. [kudo]

        adelante.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                Fragment fragment = new Fragment_Impresora();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            }
        } );

        atras.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {

                Fragment fragment = new Fragment_Impresora();  // Este debería ser Fragment_Videojuegos...
                                                               // pero no existe, ni es necesario ya.

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            }
        } );



        return rootView;
    }
}
