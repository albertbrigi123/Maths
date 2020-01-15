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

public class Teglalap extends AppCompatActivity {
    ImageButton closeBtn;
    Button torol,szamol;
    EditText ertek1,ertek2;
    TextView kerulet,terulet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teglalap);

        closeBtn=findViewById(R.id.imageButton7);
        torol=findViewById(R.id.torol);
        szamol=findViewById(R.id.szamol);
        ertek1=findViewById(R.id.a);
        ertek2=findViewById(R.id.b);
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
                    Integer k, t;
                    k = 2 * a + 2 * b;
                    t = a * b;
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
        return dataValidation;
    }
}
