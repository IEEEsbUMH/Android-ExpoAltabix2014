package com.ieeesbumh.expoaltabix2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by javierlight on 28/10/14.
 *
 * La Splash Screen es la pantalla que se muestra al iniciar la app, el clásico "Cargando".
 */
public class SplashScreen extends Activity {

    // Constante para especificar la duración de la Splash Screen
    private static final long SPLASH_SCREEN_DELAY = 5000; //tiempo en milisegundos (6000ms=6s)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen); //La vista se asigna a splash_screen.xml

        // instanciamos cargando
        final Cargando loading = new Cargando();

        TextView tv = (TextView) findViewById(R.id.textocargando);  // el texto variable
        String text = loading.setFraseCargando(0);  // frase inicial
        tv.setText(text);

        // <--- func mis timertask aqui
        TimerTask taskambiaolafrase1 = new TimerTask() { //Creación de un objeto TimerTask
            @Override
            public void run() {
                runThread(1);
            }
        };
        TimerTask taskambiaolafrase2 = new TimerTask() { //Creación de un objeto TimerTask
            @Override
            public void run() {
                runThread(2);
            }
        };
        TimerTask taskambiaolafrase3 = new TimerTask() { //Creación de un objeto TimerTask
            @Override
            public void run() {
                runThread(3);
            }
        };
        TimerTask taskambiaolafrase4 = new TimerTask() { //Creación de un objeto TimerTask
            @Override
            public void run() {
                runThread(4);
            }
        };



        // CIERRE SPLASH TRAS TIMER 6 SEG
         TimerTask task = new TimerTask() { //Creación de un objeto TimerTask
            @Override
            public void run() {

                // Empieza la siguiente actividad
                Intent intentPantallaPrincipal = new Intent().setClass(
                        SplashScreen.this, Main.class); //La clase de la que venimos, la clase a la que vamos.
                startActivity(intentPantallaPrincipal);

                // Se utiliza finish() para dar fin a la actividad, para que el usuario no pueda volver
                // a la Splash Screen dándole al botón de volver.
                finish();
            }
        };


        // Creamos array de tiempos de duracion de cada frase
        int[] triggerTime = new int[loading.listaTiempos.length]; // array de tiempos

        triggerTime[0] = loading.listaTiempos[0];     //el primer tiempo lo añadimos fuera del for
        for (int i = 1; i < triggerTime.length; i++) {
            triggerTime[i] = triggerTime[i-1] + loading.listaTiempos[i];
        }


        // INICIAMOS TIMER
        Timer timer = new Timer();

        timer.schedule(taskambiaolafrase1, triggerTime[0]);
        timer.schedule(taskambiaolafrase2, triggerTime[1]);
        timer.schedule(taskambiaolafrase3, triggerTime[2]);
        timer.schedule(taskambiaolafrase4, triggerTime[3]);


//        timer.schedule(task,SPLASH_SCREEN_DELAY);
        timer.schedule(task,triggerTime[triggerTime.length-1]);


    }



    private void runThread(final int i) {
        runOnUiThread(new Thread(new Runnable() {
            public void run() {
                TextView tv = (TextView) findViewById(R.id.textocargando);
                final Cargando loading = new Cargando();
                String text = loading.setFraseCargando(i);
                tv.setText(text);
//                while (i++ < 1000) {
//                    btn.setText("#" + i);
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
            }
        }));
    }

}
