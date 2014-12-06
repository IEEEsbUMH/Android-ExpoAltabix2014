package com.ieeesbumh.expoaltabix2014;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by javierlight on 7/11/14.
 * Esta clase es la que alojará la clase principal de la app.
 */


public class Main extends Activity {

    private DrawerLayout NavegadorDrawerLayout;     //Objeto DrawerLayout que contiene el FrameLayout principal del XML.
    private ListView NavegadorLista;                //Objeto ListView que contendrá el ListView del XML.
    private String[] titulos;                       //Vector para almacenar los títulos de los items del menú.
    private ArrayList<Item_Object> NavegadorItems;  //Objeto ArrayList que se sirve de la clase Item_object para asignar nombre e icono.
    private TypedArray NavegadorIconos;
    NavigationAdapter NavegadorAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence NavAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Declaración del DrawerLayout y del ListView
        NavegadorDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavegadorLista = (ListView) findViewById(R.id.lista_items_menu);

        //Declaración del header (cabecera)
        View cabecera = getLayoutInflater().inflate(R.layout.cabecera, null); //Devuelve null.

        //Establecimiento de la cabecera
        NavegadorLista.addHeaderView(cabecera);

        //Se toma el listado de los iconos desde @drawable
        NavegadorIconos = getResources().obtainTypedArray(R.array.iconos);

        //Se toma el listado de títulos desde desde el string-array "titulos"
        titulos= getResources().getStringArray(R.array.titulos);

        //Declaración del listado de items de la barra de navegación
        NavegadorItems = new ArrayList<Item_Object>(); //Utiliza la clase Item_object

        //Agregamos objetos con la clase Item_object al array

        for (int i=0; i<6; i++) {
            NavegadorItems.add(new Item_Object(titulos[i], NavegadorIconos.getResourceId(i, -1)));
        }

        //Declaramos y establecemos el adaptador al que le vamos a pasar el Array con los títulos
        NavegadorAdapter=new NavigationAdapter(this,NavegadorItems);
        NavegadorLista.setAdapter(NavegadorAdapter);

        /**Hasta aquí el menú aparece automáticamente sin deslizar. Toca darle acción.**/

        //Declaramos el mDrawerToggle y las imágenes que vamos a utilizar
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                               //host activity
                NavegadorDrawerLayout,              //Objeto DrawerLayout
                R.drawable.ic_drawer,               //ic_drawer lo he sacado de la carpeta del pack de imágenes para Bar
                R.string.app_name,                  // descripción del drawer abierto
                R.string.hello_world           // descripción del drawer cerrado (nos da igual)

        ) {
            /**Llamada cuando el drawer se ha establecido completamente en un estado cerrado**/
        public void onDrawerClosed(View view){
            Log.e("Cerrado completado","!");
        }
            /**Llamada cuando el drawer se ha establecido completamente en un estado abierto**/
        public void onDrawerOpen(View view){
            Log.e("Apertura completa","!");
        }
        };

        //Establecemos que el mDrawerToggle que acabamos de declarar actúe como DrawerListener
        NavegadorDrawerLayout.setDrawerListener(mDrawerToggle);

        //Establecemos que la actionbar muestre el botón de Home
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //Establecemos la acción que se realizará al pulsar un item del menú.
        NavegadorLista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id){
                MostrarFragment(position);
            }
        });

        //Para que por defecto cargue la pantalla de inicio:
        MostrarFragment(1);

    }

    //Fuera del onCreate vamos a crear el método MostrarFragment()

    //Le pasamos como argumento la posición del item que hemos pulsado en el menú.

    private void MostrarFragment(int position) {
        //actualiza el contenedor main.xml reemplazando Fragments
        Fragment fragment = null;
        switch (position) {
            case 1:
                fragment = new Fragment_Inicio();
                break;
            case 2:
                fragment = new Fragment_Quienes_Somos();
                break;
            case 3:
                // Esta estructura es necesaria para iniciar el fragment adecuado
                Bundle args = new Bundle();
                args.putInt("idGrupo",0);       // En este caso, el grupo Android
                fragment = new Fragment_Grupos_Trabajo();
                fragment.setArguments(args);
                break;
            case 4:
                fragment = new Fragment_Contacto();
                break;
            case 5:
                fragment = new Fragment_Juego();
                break;
            case 6:
                fragment = new Fragment_Acerca_De();
                break;

            default:
                //Si la opción no está disponible aparecerá un Toast y nos envía a Inicio.
                Toast.makeText(getApplicationContext(), "¡FIEEESTA!", Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), "Opcion " + titulos[position - 1] + " no disponible", Toast.LENGTH_SHORT).show();
                fragment = new Fragment_Inicio();
                position = 1;
                break;
        }

        //Si el fragment no es nulo, validamos
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            //Actualizamos el content según la opción que hayamos escogido:
            NavegadorLista.setItemChecked(position, true);
            NavegadorLista.setSelection(position);
            //Cambiamos el título
            setTitle(titulos[position - 1]);
            //Cerramos el menú deslizable
            NavegadorDrawerLayout.closeDrawer(NavegadorLista);
        } else {
            Log.e("Error.", "MostrarFragment" + position);
        }

    }
}
