

/**
 * Created by javierlight on 7/11/14.
 */


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
public class Fragment_Quienes_Somos extends Fragment {
    public Fragment_Quienes_Somos(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.quienes_somos, container, false);
        return rootView;
    }
}
