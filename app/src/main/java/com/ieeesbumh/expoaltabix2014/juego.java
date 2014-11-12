package com.ieeesbumh.expoaltabix2014;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class juego extends Activity {


    TextView tiempo;
    int h=0,m=0,s=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Botones hello = new Botones();
        fragmentTransaction.replace(R.id.juego, hello);
        fragmentTransaction.commit();

    }

    public class Salida extends Fragment{
        View v;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState){

            final View rootView = inflater.inflate(R.layout.loser, container, false);
            v=rootView;
            final Button retry = (Button)rootView.findViewById(R.id.button);
            final Button exit = (Button)rootView.findViewById(R.id.button2);


            retry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Botones hello = new Botones();
                    fragmentTransaction.replace(R.id.juego, hello);
                    fragmentTransaction.commit();
                }
            });

            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                }
            });

            return rootView;
        }

    }

    public class Ganador extends Fragment{
        View v;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState){


            setContentView(R.layout.win);

            final View rootView = inflater.inflate(R.layout.win, container, false);
            v=rootView;

            final Button retry = (Button)rootView.findViewById(R.id.button);
            final Button exit = (Button)rootView.findViewById(R.id.button2);

//            TextView textScore = (TextView) findViewById(R.id.puntuacion);

            final long yourScore = getArguments().getLong("lastScore", 136631);  // 136631 default
//            textScore.setText(Long.toString(yourScore));
            Toast.makeText(v.getContext(), Long.toString(yourScore),Toast.LENGTH_LONG).show();
            String tutex = "FOKKER";
            TextView scoreText = (TextView) v.findViewById(R.id.puntuacion);
            scoreText.setText(tutex);


            retry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Botones hello = new Botones();
                    fragmentTransaction.replace(R.id.juego, hello);
                    fragmentTransaction.commit();
                }
            });

            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);

                }
            });

            return rootView;
        }


    }


    public class Botones extends Fragment{

        final int[] orden = new int[8];
        int turno = 0;
        View v;


        public void salir(){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Salida hello = new Salida();
            fragmentTransaction.replace(R.id.juego,hello);
            fragmentTransaction.commit();

        }

        public void ganador(long score){
            Bundle args = new Bundle();
            args.putLong("lastScore", score);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Ganador hello = new Ganador();
            hello.setArguments(args);

            fragmentTransaction.replace(R.id.juego,hello);
            fragmentTransaction.commit();




        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState){

            final View rootView = inflater.inflate(R.layout.buttons, container, false);
            v=rootView;
            final Chronometer myChronometer = (Chronometer)rootView.findViewById(R.id.chronometer);
            myChronometer.start();
            final Button button = (Button)rootView.findViewById(R.id.button);
            final Button button2 = (Button)rootView.findViewById(R.id.button2);
            final Button button3 = (Button)rootView.findViewById(R.id.button3);
            final Button button4 = (Button)rootView.findViewById(R.id.button4);
            final Button button5 = (Button)rootView.findViewById(R.id.button5);
            final Button button6 = (Button)rootView.findViewById(R.id.button6);
            final Button button7 = (Button)rootView.findViewById(R.id.button7);
            final Button button8 = (Button)rootView.findViewById(R.id.button8);
<<<<<<< HEAD
//            final TextView scoreText= (TextView)rootView.findViewById(R.id.puntuacion);
=======
            final TextView scoreText= (TextView)rootView.findViewById(R.id.puntuacion);
            final String almacen="nuevo score flipante";
>>>>>>> 5220dbe79efcbb486e5c6085f8d9e5e42d5e2247


            hacerOrden();
            Random rand = new Random();
            int randomNum = rand.nextInt((8 - 1) + 1) + 1;
            boolean uno=false,dos=false,tres=false,cuatro=false,cinco=false,seis=false,siete=false,ocho=false;
            int cont=0;

            while(cont < 8){

                if(randomNum == 1 && !uno){
                    if(cont == 0){
                        button.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 1){
                        button2.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 2){
                        button3.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 3){
                        button4.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 4){
                        button5.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 5){
                        button6.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 6){
                        button7.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 7){
                        button8.setText(Integer.toString(randomNum));
                    }
                    uno=true;
                    cont++;
                }
                else if(randomNum == 2 && !dos){
                    if(cont == 0){
                        button.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 1){
                        button2.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 2){
                        button3.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 3){
                        button4.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 4){
                        button5.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 5){
                        button6.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 6){
                        button7.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 7){
                        button8.setText(Integer.toString(randomNum));
                    }
                    dos=true;
                    cont++;
                }
                else if(randomNum == 3 && !tres){
                    if(cont == 0){
                        button.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 1){
                        button2.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 2){
                        button3.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 3){
                        button4.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 4){
                        button5.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 5){
                        button6.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 6){
                        button7.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 7){
                        button8.setText(Integer.toString(randomNum));
                    }
                    tres=true;
                    cont++;
                }
                else if(randomNum == 4 && !cuatro){
                    if(cont == 0){
                        button.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 1){
                        button2.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 2){
                        button3.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 3){
                        button4.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 4){
                        button5.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 5){
                        button6.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 6){
                        button7.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 7){
                        button8.setText(Integer.toString(randomNum));
                    }
                    cuatro=true;
                    cont++;
                }
                else if(randomNum == 5 && !cinco){
                    if(cont == 0){
                        button.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 1){
                        button2.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 2){
                        button3.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 3){
                        button4.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 4){
                        button5.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 5){
                        button6.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 6){
                        button7.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 7){
                        button8.setText(Integer.toString(randomNum));
                    }
                    cinco=true;
                    cont++;
                }
                else if(randomNum == 6 && !seis){
                    if(cont == 0){
                        button.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 1){
                        button2.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 2){
                        button3.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 3){
                        button4.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 4){
                        button5.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 5){
                        button6.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 6){
                        button7.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 7){
                        button8.setText(Integer.toString(randomNum));
                    }
                    seis=true;
                    cont++;
                }
                else if(randomNum == 7 && !siete){
                    if(cont == 0){
                        button.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 1){
                        button2.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 2){
                        button3.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 3){
                        button4.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 4){
                        button5.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 5){
                        button6.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 6){
                        button7.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 7){
                        button8.setText(Integer.toString(randomNum));
                    }
                    siete=true;
                    cont++;
                }
                else if(randomNum == 8 && !ocho){
                    if(cont == 0){
                        button.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 1){
                        button2.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 2){
                        button3.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 3){
                        button4.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 4){
                        button5.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 5){
                        button6.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 6){
                        button7.setText(Integer.toString(randomNum));
                    }
                    else if(cont == 7){
                        button8.setText(Integer.toString(randomNum));
                    }
                    ocho=true;
                    cont++;
                }

                randomNum = rand.nextInt((8 - 1) + 1) + 1;
            }

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (orden[turno] == Integer.parseInt(button.getText().toString())) {
                        button.setVisibility(View.INVISIBLE);
                        turno++;
                        if(turno == 8){
                            myChronometer.stop();
                            long score = SystemClock.elapsedRealtime() - myChronometer.getBase();

//                            TextView scoreText= (TextView)rootView.findViewById(R.id.puntuacion);
                            //scoreText.setText("lo has conseguidoooo");
                            ganador(score);
                        }
                    }
                    else {
                        salir();
                    }
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String numero = button2.getText().toString();
                    if (orden[turno] == Integer.parseInt(numero)) {
                        button2.setVisibility(View.INVISIBLE);
                        turno++;
                        if(turno == 8){
                            myChronometer.stop();
                            long score = SystemClock.elapsedRealtime() - myChronometer.getBase();
<<<<<<< HEAD

                              ganador(score);
=======
                            String almacen=String.valueOf(score);
                              ganador();
>>>>>>> 5220dbe79efcbb486e5c6085f8d9e5e42d5e2247
                        }
                    }
                    else {
                        salir();
                    }
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (orden[turno] == Integer.parseInt(button3.getText().toString())) {
                        button3.setVisibility(View.INVISIBLE);
                        turno++;
                        if(turno == 8){
                            myChronometer.stop();
                            long score = SystemClock.elapsedRealtime() - myChronometer.getBase();
<<<<<<< HEAD

//                            TextView scoreText= (TextView)rootView.findViewById(R.id.puntuacion);
                           // scoreText.setText("lo has conseguidoooo");
                            ganador(score);
=======
                            String almacen=String.valueOf(score);
                            ganador();
>>>>>>> 5220dbe79efcbb486e5c6085f8d9e5e42d5e2247
                        }
                    }
                    else {
                        salir();
                    }
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (orden[turno] == Integer.parseInt(button4.getText().toString())) {
                        button4.setVisibility(View.INVISIBLE);
                        turno++;
                        if(turno == 8){
                            myChronometer.stop();
                            long score = SystemClock.elapsedRealtime() - myChronometer.getBase();
<<<<<<< HEAD

//                            TextView scoreText= (TextView)rootView.findViewById(R.id.puntuacion);
                            //scoreText.setText("lo has conseguidoooo");
                            salir();
=======
                            String almacen=String.valueOf(score);
                            ganador();
>>>>>>> 5220dbe79efcbb486e5c6085f8d9e5e42d5e2247
                        }
                    }
                    else {
                        salir();

                    }


                }

            });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (orden[turno] == Integer.parseInt(button5.getText().toString())) {
                        button5.setVisibility(View.INVISIBLE);
                        turno++;
                        if(turno == 8){
                            myChronometer.stop();
                            long score = SystemClock.elapsedRealtime() - myChronometer.getBase();
                            String almacen=String.valueOf(score);
                            ganador();
                        }
                    }
                    else {
                        salir();
                    }
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (orden[turno] == Integer.parseInt(button6.getText().toString())) {
                        button6.setVisibility(View.INVISIBLE);
                        turno++;
                        if(turno == 8){
                            myChronometer.stop();
                            long score = SystemClock.elapsedRealtime() - myChronometer.getBase();
<<<<<<< HEAD

//                            TextView scoreText= (TextView)rootView.findViewById(R.id.puntuacion);
                          //  scoreText.setText("lo has conseguidoooo");
                            ganador(score);
=======
                            String almacen=String.valueOf(score);
                            ganador();
>>>>>>> 5220dbe79efcbb486e5c6085f8d9e5e42d5e2247
                        }
                    }
                    else {
                        salir();
                    }
                }
            });
            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (orden[turno] == Integer.parseInt(button7.getText().toString())) {
                        button7.setVisibility(View.INVISIBLE);
                        turno++;
                        if(turno == 8){
                            myChronometer.stop();
                            long score = SystemClock.elapsedRealtime() - myChronometer.getBase();
<<<<<<< HEAD
//                            TextView scoreText= (TextView)rootView.findViewById(R.id.puntuacion);
                           // scoreText.setText("lo has conseguidoooo");
=======
                            String almacen=String.valueOf(score);
>>>>>>> 5220dbe79efcbb486e5c6085f8d9e5e42d5e2247

                            ganador(score);
                        }
                    }
                    else {
                        salir();
                    }
                }
            });
            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (orden[turno] == Integer.parseInt(button8.getText().toString())) {
                        button8.setVisibility(View.INVISIBLE);
                        turno++;
                        if(turno == 8){
                            myChronometer.stop();
                            long score = SystemClock.elapsedRealtime() - myChronometer.getBase();
<<<<<<< HEAD
//                            TextView scoreText= (TextView)rootView.findViewById(R.id.puntuacion);
                          //  scoreText.setText("lo has conseguidoooo");
                            ganador(score);
=======
                            String almacen=String.valueOf(score);
                            ganador();
>>>>>>> 5220dbe79efcbb486e5c6085f8d9e5e42d5e2247
                        }
                    }
                    else {
                        salir();
                    }
                }
            });

            return rootView;
        }

        public void hacerOrden(){
            Random rand = new Random();
            int randomNum = rand.nextInt((8 - 1) + 1) + 1;
            boolean uno=false,dos=false,tres=false,cuatro=false,cinco=false,seis=false,siete=false,ocho=false;
            int cont=0;

            while(cont < 8){
                if(randomNum == 1 && !uno){
                    uno=true;
                    orden[cont] = 1;
                    cont++;
                }
                else if(randomNum == 2 && !dos){
                    orden[cont] = 2;
                    dos=true;
                    cont++;
                }
                else if(randomNum == 3 && !tres){
                    orden[cont] = 3;
                    tres=true;
                    cont++;
                }
                else if(randomNum == 4 && !cuatro){
                    orden[cont] = 4;
                    cuatro=true;
                    cont++;
                }
                else if(randomNum == 5 && !cinco){
                    orden[cont] = 5;
                    cinco=true;
                    cont++;
                }
                else if(randomNum == 6 && !seis){
                    orden[cont] = 6;
                    seis=true;
                    cont++;
                }
                else if(randomNum == 7 && !siete){
                    orden[cont] = 7;
                    siete=true;
                    cont++;
                }
                else if(randomNum == 8 && !ocho){
                    orden[cont] = 8;
                    ocho=true;
                    cont++;
                }

                randomNum = rand.nextInt((8 - 1) + 1) + 1;
            }
            String mostrar = Integer.toString(orden[0]) + " - " +
                    Integer.toString(orden[1]) + " - " +
                    Integer.toString(orden[2]) + " - " +
                    Integer.toString(orden[3]) + " - " +
                    Integer.toString(orden[4]) + " - " +
                    Integer.toString(orden[5]) + " - " +
                    Integer.toString(orden[6]) + " - " +
                    Integer.toString(orden[7]);
            Toast.makeText(v.getContext(),mostrar,Toast.LENGTH_LONG).show();
        }
    }
}
