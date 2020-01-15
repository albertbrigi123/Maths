package com.example.maths.Fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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


public class Register extends Fragment {

    EditText fnameET,lnameET,emailET,passwordET,confirmPasswordET;
    Button registerBtn;
    String fnameS,lnameS,emailS,passwordS,confirmPasswordS;
    DatabaseHelper db;

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        registerBtn=v.findViewById(R.id.registerButton);
        fnameET=v.findViewById(R.id.firstName);
        lnameET=v.findViewById(R.id.lastName);
        emailET=v.findViewById(R.id.email);
        passwordET=v.findViewById(R.id.password);
        confirmPasswordET=v.findViewById(R.id.confirmPassword);
        db=new DatabaseHelper(getActivity());

        //Register button- check data entered, check emial and insert User in the SQLite database
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fnameS=fnameET.getText().toString();
                lnameS=lnameET.getText().toString();
                emailS=emailET.getText().toString();
                passwordS=passwordET.getText().toString();
                confirmPasswordS=confirmPasswordET.getText().toString();
                if(CheckDataEntered()==true) {
                    if (passwordS.equals(confirmPasswordS))
                    {
                        if(db.checkEmail(emailS)==true) {
                            boolean insert=db.insertUser(fnameS, lnameS, emailS, passwordS);
                            if(insert==true) {
                               // Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_LONG).show();
                                FragmentTransaction fr=getFragmentManager().beginTransaction();
                                fr.replace(R.id.fragment_container,new Login());
                                fr.commit();
                            }
                        }
                        else
                        {
                            Toast.makeText(getActivity(), "Enter other email", Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(getActivity(), "The passwords don't match", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        return v;
    }


    //Checked data entered
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public boolean CheckDataEntered()
    {
        boolean dataValidation=true;
        if(isEmpty(fnameET))
        {
            fnameET.setError("First name is required!");
            dataValidation=false;
        }
        if(isEmpty(lnameET))
        {
            lnameET.setError("Last name is required!");
            dataValidation=false;
        }
        /*if(isEmail(emailET))
        {
            emailET.setError("Enter valid email!");
            dataValidation=false;
        }*/

        if(isEmpty(emailET))
        {
            emailET.setError("Email is required");
            dataValidation=false;
        }

        if(isEmpty(passwordET))
        {
            passwordET.setError("Password is required!");
            dataValidation=false;
        }

        if(isEmpty(confirmPasswordET))
        {
            confirmPasswordET.setError("Confirm password is required!");
            dataValidation=false;
        }
        return dataValidation;
    }


}
