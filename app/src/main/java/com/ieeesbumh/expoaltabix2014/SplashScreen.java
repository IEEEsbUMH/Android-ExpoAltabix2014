package com.ieeesbumh.expoaltabix2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by javierlight on 28/10/14.
 *
 * La Splash Screen es la pantalla que se muestra al iniciar la app, el clásico "Cargando".
 * Modificado por kudo para incluir un texto dinámico con distintos mensajes de "loading".
 */
public class SplashScreen extends Activity {

    // Constante para especificar la duración de la Splash Screen
    //private static final long SPLASH_SCREEN_DELAY = 2000; //tiempo en milisegundos (6000ms=6s)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen); //La vista se asigna a splash_screen.xml

        // instanciamos cargando para obtener las frases
        final Cargando loading = new Cargando();

        // Generamos un valor aleatorio como frase inicial
        Random rnd = new Random();
        int randNum = rnd.nextInt(loading.listaFrases.length);

        // Recuperamos arrays aleatorizados de frases y tiempos, y gestionar localmente
        final String[] frasesCargando = loading.getFrasesCargando(randNum);
        final int[] tiemposCargando = loading.getTiemposCargando(randNum);


        // Definimos el texto del layout, y le damos valor inicial
        TextView tv = (TextView) findViewById(R.id.textocargando);  // el texto variable
        String text = frasesCargando[4];  // frase inicial (aleatoria)
        tv.setText(text);


        // Todas las task para varios cambios de frase consecutivos.
        // Los timertask corren sobre otros hilos, por tanto, necesitamos llamar a 'runThread()'
        // para que ejecute el cambio de texto en el hilo principal (el que creó ese TextView)

        TimerTask taskambiaolafrase1 = new TimerTask() {
            @Override
            public void run() {
                runThread(frasesCargando[1]);
            }
        };
        TimerTask taskambiaolafrase2 = new TimerTask() {
            @Override
            public void run() {
                runThread(frasesCargando[2]);
            }
        };
        TimerTask taskambiaolafrase3 = new TimerTask() {
            @Override
            public void run() {
                runThread(frasesCargando[3]);
            }
        };
        TimerTask taskambiaolafrase4 = new TimerTask() {
            @Override
            public void run() {
                runThread(frasesCargando[4]);
            }
        };



        // CIERRE SPLASH TRAS FINALIZAR TODAS LAS FRASES
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


        // Creamos array de tiempos de disparo para cada task del timer
        int[] triggerTime = new int[tiemposCargando.length];

        // Cada valor de tiempo indicará el momento del timer en que se lanzará cada task
        // (el primer valor lo añadimos fuera del for, por ser valor directo, no acumulativo)
        triggerTime[0] = tiemposCargando[0];
        int suma = tiemposCargando[0];  // test kudo
        for (int i = 1; i < triggerTime.length; i++) {
            triggerTime[i] = triggerTime[i-1] + tiemposCargando[i];
            suma = suma + tiemposCargando[i];  //test kudo
        }


        // INICIAMOS TIMER
        Timer timer = new Timer();

        // Todas las frases cada vez era innecesario... pero lo dejo por si acaso!
        timer.schedule(taskambiaolafrase1, triggerTime[0]);
        timer.schedule(taskambiaolafrase2, triggerTime[1]);
        timer.schedule(taskambiaolafrase3, triggerTime[2]);
        timer.schedule(taskambiaolafrase4, triggerTime[3]);

        // Termina cuando acaban todos los mensajes de loading
//        timer.schedule(task,triggerTime[4]);

        // EVITAR ESTO: tras eliminar dependencia entre listaFrases y listaTiempos, ya no tiene sentido
//        timer.schedule(task,triggerTime[triggerTime.length-1]);

        timer.schedule(task,2000);    // tiempo fijo forzado manualmente

    }



    private void runThread(final String text) {
        runOnUiThread(new Thread(new Runnable() {
            public void run() {
                TextView tv = (TextView) findViewById(R.id.textocargando);
//                final Cargando loading = new Cargando();
//                String text = frasesCargando[i];
                tv.setText(text);

            }
        }));
    }


}

//Toast.makeText(getApplicationContext(), "randNum=" + randNum + " y listaFrases.length+1=" + (loading.listaFrases.length+1), Toast.LENGTH_LONG).show();
//Toast.makeText(getApplicationContext(), tiemposCargando.length + " - " + triggerTime.length + " final" + triggerTime[triggerTime.length-1] + " suma" + suma, Toast.LENGTH_LONG).show();
