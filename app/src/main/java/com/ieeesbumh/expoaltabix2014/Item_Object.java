package com.ieeesbumh.expoaltabix2014;

/**
 * Created by javierlight on 7/11/14.
 * Esta clase sirve para facilitar el uso del menú con el adaptador. Se declaran los métodos para
 * asignar título e icono a cada item del menú.
 */
public class Item_Object {
    private String titulo;
    private int icono;

    public Item_Object(String title, int icon){
        this.titulo=title;
        this.icono=icon;
    }
    public String getTitulo(){                  //Método para obtener el título.
        return titulo;
    }
    public void setTitulo(String titulo){       //Es un void porque no devuelve nada.
        this.titulo = titulo;
    }
    public int getIcono(){                      //Método para obtener el icono.
        return icono;
    }
    public void setIcono(){                     //Es un void porque no devuelve nada
        this.icono = icono;
    }

}
