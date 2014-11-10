package com.ieeesbumh.expoaltabix2014;

/**
 * Created by Q on 06/11/2014.
 */
public class Cargando {

    public String fraseCargando = new String("Cargando, pero con calma.."); // inicializada aunque no se usa
    public int tiempoCargando;

    public String[] listaFrases = {
            "Desencriptando todas tus contraseñas",
            "Instalando troyano en tu dispositivo",
            "Precalentando el horno",
            "Añadiendo una cucharada de azúcar",
            "Solucionando error NullKudoException"
            };
    public int[] listaTiempos = {   //duracion de cada frase de listaFrases
            1500,
            1500,
            500,
            1700,
            1300
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
