package com.ieeesbumh.expoaltabix2014;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by kudo on 11/11/14.
 *
 * Se trata de un fragment recursivo que se llama a sí mismo para crear nuevos fragments cada vez.
 * Un fragment calcula su layout, lo muestra, y configura los botones para crear el siguiente.
 * Cada botón enviará el id del layout a mostrar en el nuevo fragment.
 * El único problema era que conseguir que le llegue el mensaje (idGrupo) del uno al otro!!!
 */
public class Fragment_Grupos_Trabajo extends Fragment {
    public Fragment_Grupos_Trabajo() {
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {


        // Obtiene el id del grupo a mostrar cada vez que se invoca este objeto.
        // Este valor debe venir desde el anterior fragment que invocó al actual
        final int idGrupoActual = getArguments().getInt("idGrupo",0);  // el 0 es el default (android)

        // Listamos los layouts a mostrar sobre los grupos
        final int[] layoutGrupos = {
                R.layout.android_y_java,
                R.layout.impresion_3d,
                R.layout.videojuegos
//                , R.layout.comunicacion //  demás grupos etc
        };

/*        switch (idGrupoActual) {
            case 0:
                layoutActual = R.layout.android_y_java;
                break;
            case 1:
                layoutActual = R.layout.impresion_3d;
                break;
            case 2:
                layoutActual = R.layout.videojuegos;
                break;
//            case 3:
//                layoutActual = R.layout.comunicacion;  // demás grupos etc
//                break;
            default:
                // Volvemos a Android en caso de error o de llegar al último (cíclico es más versátil)
                layoutActual = R.layout.android_y_java;
                break;*/

        // Dibujamos el layout del grupo correspondiente al grupo actual
        View rootView = inflater.inflate(layoutGrupos[idGrupoActual], container, false);


           // Definimos los botones para navegar entre grupos
            ImageButton atras = (ImageButton) rootView.findViewById(R.id.boton_atras);
            ImageButton adelante = (ImageButton) rootView.findViewById(R.id.boton_adelante);

           // Así como sus funciones
            adelante.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View view) {

                    int nextGrupo = idGrupoActual+1;            // Pasamos al siguiente grupo.
                    if (nextGrupo >= layoutGrupos.length) {     // Si llegamos al último,
                        nextGrupo = 0;                          // volvemos al primero
                    }

                    // Creamos la estructura para pasar la variable 'nextGrupo' desde este
                    // fragment, al nuevo creado para el nuevo grupo
                    Bundle args = new Bundle();
                    args.putInt("idGrupo",nextGrupo);

                    Fragment nuevoFragment = new Fragment_Grupos_Trabajo();
                    nuevoFragment.setArguments(args);   // recién creado, le acoplamos el mensaje

                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, nuevoFragment);
                    fragmentTransaction.commit();

                }
            } );

            atras.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View view) {

                    int nextGrupo = idGrupoActual-1;          // Pasamos al grupo anterior.
                    if (nextGrupo < 0) {                      // Si llegamos al primero,
                        nextGrupo = layoutGrupos.length - 1;  // hacia atrás vamos al último
                    }

                    Bundle args = new Bundle();
                    args.putInt("idGrupo",nextGrupo);

                    Fragment nuevoFragment = new Fragment_Grupos_Trabajo();
                    nuevoFragment.setArguments(args);

                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_frame, nuevoFragment);
                    fragmentTransaction.commit();

                }
            } );



        // Esta clase es redundante, el menu lateral debería llamar directamente a 'Fragment_Android'.
        // La dejo por si en algun momento se quiere hacer un layout introductorio con
        // todos los grupos de trabajo (actualmente 'grupos_trabajo.xml' no se usa) [by kudo]
//        Fragment fragment = new Fragment_Android();
//
//        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.reemplazar_frame, fragment).commit();





        return rootView;






/*      ImageButton atras = (ImageButton) rootView.findViewById(R.id.boton_atras);
        ImageButton adelante = (ImageButton) rootView.findViewById(R.id.boton_adelante);


        //en el grupo 1 (Android) el contador estará a 0.
        //Cada vez que pulsemos el botón adelante se incrementará 1 y variará el layout.
        //Cada vez que pulsemos el botón atrás se restará 1 y variará el layout.

//
// NOTA DE KUDO:
// En cada Fragment se gestionan los botones que llevan a los 2 Fragment adyacentes.
// Para este sistema, no es necesario implementar ningún tipo de contador, ya que los Fragment de
// los botones se invocan localmente en el fragment actual, sin hacer uso de variables externas.
// Solo tiene sentido si se implementa un <string-array name="grupos"> en 'strings.xml', para que
// se gestionen las llamadas a los fragment de los grupos desde ahí
// (como hace Main.java con los fragment del menú lateral)

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
*/





    }


}