package com.ieeesbumh.expoaltabix2014;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;

/**
 * Created by javierlight
 */
public class Fragment_Juego extends Fragment {
    public Fragment_Juego(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.inicio, container, false);

        Intent lanzarJuego = new Intent(getActivity(), juego.class);
        startActivity(lanzarJuego);

        return rootView;
    }
}