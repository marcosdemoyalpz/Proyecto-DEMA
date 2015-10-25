package com.example.silentechoes.dema.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.silentechoes.dema.R;
import com.google.android.gms.maps.SupportMapFragment;


public class MapOneOrderFragment extends SupportMapFragment {



    public MapOneOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frg_map_all, container, false);
    }




}
