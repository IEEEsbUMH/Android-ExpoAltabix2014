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
 */
public class Fragment_Grupos_Trabajo extends Fragment {
    public Fragment_Grupos_Trabajo() {
    }

    int contador = 0;


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grupos_trabajo, container, false);


        ImageButton atras = (ImageButton) rootView.findViewById(R.id.boton_atras);
        ImageButton adelante = (ImageButton) rootView.findViewById(R.id.boton_adelante);


        //en el grupo 1 (Android) el contador estará a 0.
        //Cada vez que pulsemos el botón adelante se incrementará 1 y variará el layout.
        //Cada vez que pulsemos el botón atrás se restará 1 y variará el layout.

try {
    adelante.setOnClickListener(new Button.OnClickListener() {
                                    public void onClick(View view) {


                                        if (contador < 6) {
                                            contador = contador + 1;
                                            Fragment fragment = null;
                                            switch (contador) {
                                                case 0:
                                                    fragment = new Fragment_Android();
                                                    break;
                                                case 1:
                                                    fragment = new Fragment_Impresora();
                                                    break;
                                            }
                                            if (fragment != null) {
                                                FragmentManager fragmentManager = getFragmentManager();
                                                fragmentManager.beginTransaction().replace(R.id.reemplazar_frame, fragment).commit();

                                            }

                                        }
                                    }


                                }
    );
return rootView;

}
catch(Exception holabuenosdias){
    return rootView;
}





    }



}