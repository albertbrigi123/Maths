package com.example.maths.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.maths.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Testek extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_testek, container, false);
        BottomNavigationView bottomNavigationView = v.findViewById(R.id.bottomnav);
        bottomNavigationView.setSelectedItemId(R.id.navigation_testek);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment=null;
                switch (item.getItemId()) {
                    case R.id.navigation_profil:
                        selectedFragment = new Profil();
                        break;
                    case R.id.navigation_szamologep :
                        selectedFragment=new Szamologep();
                        break;
                    case R.id.navigation_testek:
                        selectedFragment=new Testek();
                        break;
                    case R.id.navigation_alakzatok:
                        selectedFragment=new Alakzatok();
                        break;
                }
                getActivity().getSupportFragmentManager().
                        beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                return true;
            }
        });
        return v;
    }
}
