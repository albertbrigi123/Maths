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

public class Gula extends AppCompatActivity {
    ImageButton closeBtn;
    Button torol,szamol;
    EditText ertek,ertek2;
    TextView felszin,terfogat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gula);

        closeBtn = findViewById(R.id.imageButton7);
        torol = findViewById(R.id.torol);
        szamol = findViewById(R.id.szamol);
        ertek=findViewById(R.id.a);
        ertek2=findViewById(R.id.m);
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
                    String y = ertek2.getText().toString();
                    int a,m, t;
                    a = Integer.parseInt(x);
                    m = Integer.parseInt(y);
                    Double f, mo;
                    mo = Math.sqrt(m+(a/2));
                    f = a*a+4*((a-mo)/2);
                    t = ((a*a)-m)/3;
                    felszin.setText("Felszine: " + f.toString());
                    terfogat.setText("Terfogata: " + t);
                }
            }
        });

        torol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                felszin.setText("");
                terfogat.setText("");
                ertek.setText("");
                ertek2.setText("");
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
        if(isEmpty(ertek2))
        {
            ertek2.setError("Kérem adjon meg egy értéket");
            dataValidation=false;
        }
        return dataValidation;
    }
}
