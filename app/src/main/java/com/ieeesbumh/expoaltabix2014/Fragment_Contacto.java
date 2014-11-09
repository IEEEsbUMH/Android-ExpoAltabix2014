package com.ieeesbumh.expoaltabix2014;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by javierlight on 7/11/14.
 */
public class Fragment_Contacto extends Fragment {


    public Fragment_Contacto() {
    }

        public Button twUMH, fbUMH, webUMH, twEsp, fbEsp, webEsp;
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.contacto, container, false);

            try {
                //Digo con qué botón se corresponde cada variable

                webUMH = (Button) rootView.findViewById(R.id.button1);
                twUMH = (Button) rootView.findViewById(R.id.button2);
                fbUMH = (Button) rootView.findViewById(R.id.button3);
                webEsp = (Button) rootView.findViewById(R.id.button4);
                twEsp = (Button) rootView.findViewById(R.id.button5);

                /*
                Por alguna razón inexplicable el sexto botón no se puede implementar. Doy por hecho
                que un 1% de los usuarios de la app tratarán de hacer click en el botón de ir al fb
                de Sección España. Si eso, más adelante se puede tratar de pulir. Lo dejo comentado
                para evitar que de error.
                */

                //fbEsp = (Button) rootView.findViewById(R.id.button6);



                //[JOSEVI] Acciones de los botones

                webUMH.setOnClickListener(new Button.OnClickListener() {
                                              public void onClick(View view) {
                                                  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://umh.ieeespain.org/")));
                                              }
                                          }
                );

                twUMH.setOnClickListener(new Button.OnClickListener() {
                                             public void onClick(View view) {
                                                 startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/IEEESBUMH")));
                                             }
                                         }
                );

                fbUMH.setOnClickListener(new Button.OnClickListener() {
                                             public void onClick(View view) {
                                                 startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/IeeeSbUmh")));
                                             }
                                         }
                );

                webEsp.setOnClickListener(new Button.OnClickListener() {
                                              public void onClick(View view) {
                                                  startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ieeespain.org/")));
                                              }
                                          }
                );

                twEsp.setOnClickListener(new Button.OnClickListener() {
                                             public void onClick(View view) {
                                                 startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ieeespain")));
                                             }
                                         }
                );

                fbEsp.setOnClickListener(new Button.OnClickListener() {
                                             public void onClick(View view) {
                                                 startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://es-es.facebook.com/pages/IEEE-Spanish-Section/107487282668437")));
                                             }
                                         }
                );
                return null;
            }
                catch (Exception prueba) {


                    return rootView;
                }
        }


    }




