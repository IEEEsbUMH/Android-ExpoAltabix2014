package com.ieeesbumh.expoaltabix2014;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by javierlight on 7/11/14.
 */
public class Fragment_Grupos_Trabajo extends Fragment {
    public Fragment_Grupos_Trabajo() {
    }

    int contador = 0;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.android_y_java, container, false);


        ImageButton atras = (ImageButton) rootView.findViewById(R.id.boton_atras);
        ImageButton adelante = (ImageButton) rootView.findViewById(R.id.boton_adelante);


        //en el grupo 1 (Android) el contador estará a 0.
        //Cada vez que pulsemos el botón adelante se incrementará 1 y variará el layout.
        //Cada vez que pulsemos el botón atrás se restará 1 y variará el layout.

        atras.setOnClickListener(new Button.OnClickListener() {
                                     public void onClick(View view) {
                                         if (contador != 0 || contador < 6) {
                                             contador = contador + 1;
                                         }
                                     }
                                 }
        );


        switch (contador) {
            case 0:
                View vista0 = inflater.inflate(R.layout.android_y_java, container, false);
                return vista0;
            case 1:
                View vista1 = inflater.inflate(R.layout.impresion_3d, container, false);
                return vista1;
            case 2:
                View vista2 = inflater.inflate(R.layout.videojuegos, container, false);
                return vista2;
        }


        return null;
        }

    }



