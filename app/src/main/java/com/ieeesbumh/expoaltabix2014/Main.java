package com.ieeesbumh.expoaltabix2014;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;




public class Main extends Activity {

    private DrawerLayout NavegadorDrawerLayout;
    private ListView NavegadorLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Añadimos dentro del onCreate la declaración del DrawerLayout y del ListView

        NavegadorDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavegadorLista = (ListView) findViewById(R.id.lista_items_menu);
    }



}
