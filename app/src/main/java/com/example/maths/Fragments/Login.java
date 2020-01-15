package com.example.maths.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.maths.DatabaseHelper;
import com.example.maths.R;

public class Login extends Fragment {

    EditText emailET,passwordET;
    Button loginBtn,registerBtn;
    DatabaseHelper db;


    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        db = new DatabaseHelper(getActivity());
        emailET=v.findViewById(R.id.email);
        passwordET=v.findViewById(R.id.password);
        loginBtn=v.findViewById(R.id.LoginButton);
        registerBtn=v.findViewById(R.id.SignUpButton);

        //Login(Check data entered, Check email and password
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailET.getText().toString();
                String password = passwordET.getText().toString();
                Boolean CheckEmailPassword = db.checkLogin(email, password);
                if (CheckDataEntered() == true) {
                    if (CheckEmailPassword == true) {
                        SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
                        SharedPreferences.Editor edt = pref.edit();
                        edt.putString("EMAIL", email);
                        edt.commit();
                        SharedPreferences prefe = getActivity().getSharedPreferences("Alma",Context.MODE_PRIVATE);
                        SharedPreferences.Editor edti = prefe.edit();
                        edti.putString("EMAIL", email);
                        edti.commit();
                        FragmentTransaction fr=getFragmentManager().beginTransaction();
                        fr.replace(R.id.fragment_container,new Alakzatok());
                        fr.commit();
                        //Toast.makeText(getContext(),"Successfully login",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        //begin transaction - Go to the Register activity
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new Register());
                fr.commit();
            }
        });


        return v;
    }

    //Checked data entered
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    public boolean CheckDataEntered()
    {
        boolean dataValidation=true;
        if(isEmpty(emailET))
        {
            emailET.setError("Email is required!");
            dataValidation=false;
        }
        if(isEmpty(passwordET))
        {
            passwordET.setError("Password is required!");
            dataValidation=false;
        }
        return dataValidation;
    }
}
