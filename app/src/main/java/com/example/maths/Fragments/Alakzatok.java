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
import android.widget.Button;

import com.example.maths.Alakzatok.Haromszog;
import com.example.maths.Alakzatok.Kor;
import com.example.maths.Alakzatok.Negyzet;
import com.example.maths.Alakzatok.Paralelogramma;
import com.example.maths.Alakzatok.Teglalap;
import com.example.maths.Alakzatok.Trapez;
import com.example.maths.R;
import android.content.Intent;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Alakzatok extends Fragment {
    ImageButton img1,img2,img3,img4,img5,img6;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alakzatok, container, false);

        img1=v.findViewById(R.id.imageButton);
        img2=v.findViewById(R.id.imageButton2);
        img3=v.findViewById(R.id.imageButton3);
        img4=v.findViewById(R.id.imageButton4);
        img5=v.findViewById(R.id.imageButton5);
        img6=v.findViewById(R.id.imageButton6);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Negyzet.class);
                startActivity(i);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Kor.class);
                startActivity(i);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Haromszog.class);
                startActivity(i);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Teglalap.class);
                startActivity(i);
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Trapez.class);
                startActivity(i);
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), Paralelogramma.class);
                startActivity(i);
            }
        });




        BottomNavigationView bottomNavigationView = v.findViewById(R.id.bottomnav);
        bottomNavigationView.setSelectedItemId(R.id.navigation_alakzatok);
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
