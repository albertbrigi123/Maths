package com.example.maths.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maths.DatabaseHelper;
import com.example.maths.MainActivity;
import com.example.maths.R;
import com.example.maths.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Profil extends Fragment {
    DatabaseHelper db;
    TextView fname,lname;
    User user;
    Button logoutBtn,changePasswordBtn,chooseImageBtn,saveImageBtn;
    ImageView img;

    private static final int RESULT_LOAD_IMAGE=1;
    String path;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profil, container, false);

        SharedPreferences pref = getActivity().getPreferences(Context.MODE_PRIVATE);
        final String email = pref.getString("EMAIL", "empty");




        db =  new DatabaseHelper(getActivity());
        fname=v.findViewById(R.id.firstName);
        lname=v.findViewById(R.id.lastName);
        logoutBtn=v.findViewById(R.id.logout);
        changePasswordBtn=v.findViewById(R.id.changePassword);
        chooseImageBtn=v.findViewById(R.id.chooseImage);
        img=v.findViewById(R.id.userImage);

        ArrayList<String> datas = new ArrayList<>();
        datas = db.getDatas(email);
        fname.setText(datas.get(0));
        lname.setText(datas.get(1));
        final String psw=datas.get(3);
        Log.d("FFFA",psw);


        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });

        changePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View viewDialog=LayoutInflater.from(getContext()).inflate(R.layout.new_password,null);
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(viewDialog);
                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText newPassword = viewDialog.findViewById(R.id.newPassword);
                        EditText ConfNewPassword=viewDialog.findViewById(R.id.confirmNewPassword);
                        EditText valuePassword=viewDialog.findViewById(R.id.password);
                        if(newPassword.getText().toString().equals(ConfNewPassword.getText().toString())) {
                            if(psw.equals(valuePassword.getText().toString()))
                            {
                                db.updatePassword(email,newPassword.getText().toString());
                            }
                            else
                            {
                                Toast.makeText(getActivity(),"Passwords don't match",Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(getActivity(),"The new password and the confirm new password fiels don't match ",Toast.LENGTH_LONG).show();

                        }
                    }
                });
                AlertDialog d = builder.create();
                d.show();

            }
        });

        chooseImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery = new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery,RESULT_LOAD_IMAGE);
            }
        });

        BottomNavigationView bottomNavigationView = v.findViewById(R.id.bottomnav);
        bottomNavigationView.setSelectedItemId(R.id.navigation_profil);
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
