package com.example.maths.Alakzatok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.maths.R;

public class Trapez extends AppCompatActivity {
    ImageButton closeBtn;
    Button torol,szamol;
    EditText ertek1,ertek2,ertek3,ertek4,ertek5;
    TextView kerulet,terulet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapez);

        closeBtn=findViewById(R.id.imageButton7);
        torol=findViewById(R.id.torol);
        szamol=findViewById(R.id.szamol);
        ertek1=findViewById(R.id.a);
        ertek2=findViewById(R.id.b);
        ertek3=findViewById(R.id.c);
        ertek4=findViewById(R.id.h);
        kerulet=findViewById(R.id.kerulete);
        terulet=findViewById(R.id.Terulete);

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
                    String x = ertek1.getText().toString();
                    int a;
                    a = Integer.parseInt(x);
                    String x2 = ertek2.getText().toString();
                    int b;
                    b = Integer.parseInt(x2);
                    String x3 = ertek3.getText().toString();
                    int c;
                    c = Integer.parseInt(x3);
                    String x4 = ertek4.getText().toString();
                    int d;
                    d = Integer.parseInt(x4);
                    String x5 = ertek5.getText().toString();
                    int m;
                    m = Integer.parseInt(x4);
                    Integer k, t;
                    k = a+b+c+d;
                    t = (a+c)*m/2;
                    kerulet.setText("Kerülete: " + k.toString());
                    terulet.setText("Területe: " + t.toString());
                }
            }
        });

        torol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                terulet.setText("");
                kerulet.setText("");
                ertek1.setText("");
                ertek2.setText("");
                ertek3.setText("");
                ertek4.setText("");
                ertek5.setText("");
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
        if(isEmpty(ertek1))
        {
            ertek1.setError("Kérem adjon meg egy értéket");
            dataValidation=false;
        }
        if(isEmpty(ertek2))
        {
            ertek2.setError("Kérem adjon meg egy értéket");
            dataValidation=false;
        }
        if(isEmpty(ertek3))
        {
            ertek3.setError("Kérem adjon meg egy értéket");
            dataValidation=false;
        }
        if(isEmpty(ertek4))
        {
            ertek4.setError("Kérem adjon meg egy értéket");
            dataValidation=false;
        } if(isEmpty(ertek5))
    {
        ertek5.setError("Kérem adjon meg egy értéket");
        dataValidation=false;
    }
        return dataValidation;
    }
}
