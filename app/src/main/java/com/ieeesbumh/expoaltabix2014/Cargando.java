package com.ieeesbumh.expoaltabix2014;

import android.content.Intent;
import android.provider.AlarmClock;

/**
 * Created by Q on 06/11/2014.
 */
public class Cargando {

    public String fraseCargando = new String("Cargando, pero con calma.."); // inicializada aunque no se usa
    public int tiempoCargando;

    public String[] listaFrases = {
            "Desencriptando todas sus contraseñas",
            "Instalando troyano en el dispositivo",
            "Precalentando el horno",
            "Añadiendo mucha azúcar",
            "Esperando por una maldita SplashScreen ofensiva!!"
            };
    public int[] listaTiempos = {   //duracion de cada frase de listaFrases
            1500,
            1500,
            500,
            1000,
            3000
            };

    public String setFraseCargando(int idFrase) {   //posiblemente redundante
        fraseCargando = listaFrases[idFrase];
        return fraseCargando;
    }

    public int setTiempoCargando(int idFrase) {
        tiempoCargando = listaTiempos[idFrase];
        return tiempoCargando;
    }

}
