package com.ieeesbumh.expoaltabix2014;

/**
 * Created by kudo on 06/11/2014.
 */
public class Cargando {

    // Se puede añadir cualquier nueva frase sin problemas
    public String[] listaFrases = {
            "Desencriptando todas tus contraseñas",
            "Instalando troyano en tu dispositivo",
            "Precalentando el horno",
            "Añadiendo una cucharada de azúcar",
            "Solucionando error NullKudoException"
            };
    // Son tiempos aleatorios, no hay relación directa entre esta lista y la de frases.
    // Se van asignando al azar en el método 'getTiemposCargando'
    public int[] listaTiempos = {
            1000,
            1500,
            800,
            1300,
            1700
            };

    // Arrays que recogerá las frases ya mezcladas
    public String[] frasesCargando = new String[listaFrases.length];
    // Array que recogerá un tiempo de duración para cada frase, por eso depende de 'listaFrases'
    public int[] tiemposCargando = new int[listaFrases.length];

    // Devuelve el array 'listaFrases' con sus frases desordenadas (rotadas)
    public String[] getFrasesCargando(int idFraseInicial) {
        // Rotamos el array para empezar en frase aleatoria
        for (int i = 0; i < listaFrases.length; i++) {      // cuando llega ha cogido el último,
            if (idFraseInicial+i == listaFrases.length) {   // vuelve al principio del array
                idFraseInicial = 0 - i;    // asi vuelve al indice 0
            }
            frasesCargando[i] = listaFrases[idFraseInicial+i];
        }

        return frasesCargando;
    }

    // Devuelve un array de tiempos totalmente aleatorio con valores sacados de 'listaTiempos'
    public int[] getTiemposCargando(int idFraseInicial) {
        // Aleatorizamos el array de tiempos (rotamos hacia atrás)
        for (int i = 0; i < listaFrases.length; i++) {
            if (idFraseInicial-i < 0) {                 // cuando llega al primero,
                idFraseInicial = listaFrases.length;    // sigue hacia atrás desde el último
            }
            tiemposCargando[i] = listaTiempos[idFraseInicial-i];
        }
        return tiemposCargando;
    }

}
