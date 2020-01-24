package com.example.maths.Testek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.maths.R;

public class Kocka extends AppCompatActivity {
    ImageButton closeBtn;
    Button torol,szamol;
    EditText ertek;
    TextView felszin,terfogat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kocka);

        closeBtn = findViewById(R.id.imageButton7);
        torol = findViewById(R.id.torol);
        szamol = findViewById(R.id.szamol);
        ertek=findViewById(R.id.a);
        felszin=findViewById(R.id.felszine);
        terfogat=findViewById(R.id.terfogata);




        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        szamol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValue() == true) {
                    String x = ertek.getText().toString();
                    int a;
                    a = Integer.parseInt(x);
                    int f,t;
                    f = 6*a*a;
                    t = a*a*a;
                    felszin.setText("Felszíne: " + f);
                    terfogat.setText("Térfogata: " + t);
                }
            }
        });

        torol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                felszin.setText("");
                terfogat.setText("");
                ertek.setText("");
            }
        });
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    public boolean checkValue()
    {
        boolean dataValidation=true;
        if(isEmpty(ertek))
        {
            ertek.setError("Kérem adjon meg egy értéket");
            dataValidation=false;
        }
        return dataValidation;
    }
}
