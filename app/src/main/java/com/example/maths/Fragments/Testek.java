package com.example.maths.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.maths.R;
import com.example.maths.Testek.Gomb;
import com.example.maths.Testek.Gula;
import com.example.maths.Testek.Henger;
import com.example.maths.Testek.Kocka;
import com.example.maths.Testek.Kup;
import com.example.maths.Testek.Teglatest;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Testek extends Fragment {
    ImageButton kocka,gomb,gula,teglatest,henger, kup;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_testek, container, false);

        kocka = v.findViewById(R.id.imageButton);
        gomb = v.findViewById(R.id.imageButton2);
        gula = v.findViewById(R.id.imageButton3);
        teglatest = v.findViewById(R.id.imageButton4);
        henger = v.findViewById(R.id.imageButton5);
        kup = v.findViewById(R.id.imageButton6);

        kocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Kocka.class);
                startActivity(intent);
            }
        });

        gomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Gomb.class);
                startActivity(intent);
            }
        });

        gula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Gula.class);
                startActivity(intent);
            }
        });

        teglatest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Teglatest.class);
                startActivity(intent);
            }
        });

        henger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Henger.class);
                startActivity(intent);
            }
        });

        kup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Kup.class);
                startActivity(intent);
            }
        });
        BottomNavigationView bottomNavigationView = v.findViewById(R.id.bottomnav);
        bottomNavigationView.setSelectedItemId(R.id.navigation_testek);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment=null;
                switch (item.getItemId()) {
                    case R.id.navigation_teszt:
                        selectedFragment=new Teszt();
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
