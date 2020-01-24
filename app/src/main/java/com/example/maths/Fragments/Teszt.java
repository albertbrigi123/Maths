package com.example.maths.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.maths.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Teszt extends Fragment {
    EditText e1,e2,e3,e4,e5,e6,erd;
    Button kuld;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_teszt, container, false);

        e1=v.findViewById(R.id.elsovalasz);
        e2=v.findViewById(R.id.masodikvalasz);
        e3=v.findViewById(R.id.harmadikvalasz);
        e4=v.findViewById(R.id.negyedikvalasz);
        e5=v.findViewById(R.id.otodikvalasz);
        e6=v.findViewById(R.id.hatodikvalasz);

        kuld=v.findViewById(R.id.kuld);

        kuld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CheckDataEntered() == true) {
                    String e1S, e2S, e3S, e4S, e5S, e6S;
                    e1S = e1.getText().toString();
                    e2S = e2.getText().toString();
                    e3S = e3.getText().toString();
                    e4S = e4.getText().toString();
                    e5S = e5.getText().toString();
                    e6S = e6.getText().toString();
                    int db = 0;
                    if (Integer.parseInt(e1S) == 20) {
                        db++;
                    }
                    if (Integer.parseInt(e2S) == 314) {
                        db++;
                    }
                    if (Integer.parseInt(e3S) == 3) {
                        db++;
                    }
                    if (Integer.parseInt(e4S) == 10) {
                        db++;
                    }
                    if (Integer.parseInt(e5S) == 2) {
                        db++;
                    }
                    if (Integer.parseInt(e6S) == 4) {
                        db++;
                    }
                    String eddd="Gratulálunk, eredményed: " + db + "/6";
                    Toast.makeText(getContext(),eddd,Toast.LENGTH_SHORT).show();

                }
            }
        });

        BottomNavigationView bottomNavigationView = v.findViewById(R.id.bottomnav);
        bottomNavigationView.setSelectedItemId(R.id.navigation_teszt);
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

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    public boolean CheckDataEntered()
    {
        boolean dataValidation=true;
        if(isEmpty(e1))
        {
            e1.setError("Mező kitöltése kötelező!");
            dataValidation=false;
        }
        if(isEmpty(e2))
        {
            e2.setError("Mező kitöltése kötelező!");
            dataValidation=false;
        }

        if(isEmpty(e3))
        {
            e3.setError("Mező kitöltése kötelező!");
            dataValidation=false;
        }

        if(isEmpty(e4))
        {
            e4.setError("Mező kitöltése kötelező!");
            dataValidation=false;
        }

        if(isEmpty(e5))
        {
            e5.setError("Mező kitöltése kötelező!");
            dataValidation=false;
        }

        if(isEmpty(e6))
        {
            e6.setError("Mező kitöltése kötelező!");
            dataValidation=false;
        }


        return dataValidation;
    }
}
