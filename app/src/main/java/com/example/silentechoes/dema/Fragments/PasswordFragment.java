package com.example.silentechoes.dema.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.silentechoes.dema.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PasswordFragment extends Fragment {

    public PasswordFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_password, container, false);
    }
}
