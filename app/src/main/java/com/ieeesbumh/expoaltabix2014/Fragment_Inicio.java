package com.ieeesbumh.expoaltabix2014;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by javierlight on 7/11/14.
 *
 * Fragment para mostrar como pantalla el layout especificado.
 */
public class Fragment_Inicio extends Fragment {
    public Fragment_Inicio(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.inicio, container, false);
        return rootView;
    }
}
