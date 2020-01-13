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

public class Kor extends AppCompatActivity {
    ImageButton closeBtn;
    Button torol,szamol;
    EditText ertek;
    TextView kerulet,terulet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kor);

        closeBtn=findViewById(R.id.imageButton7);
        torol=findViewById(R.id.torol);
        szamol=findViewById(R.id.szamol);
        ertek=findViewById(R.id.a);
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
                    String x = ertek.getText().toString();
                    int a;
                    a = Integer.parseInt(x);
                    Double k,t;
                    k = 2*3.14*a;
                    t = 3.14+a+a;
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
