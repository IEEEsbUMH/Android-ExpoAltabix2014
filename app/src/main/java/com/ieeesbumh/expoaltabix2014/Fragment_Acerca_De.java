package com.ieeesbumh.expoaltabix2014;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by javierlight on 7/11/14.
 */
public class Fragment_Acerca_De extends Fragment {
    public Fragment_Acerca_De(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.acerca_de, container, false);
        return rootView;
    }
}
