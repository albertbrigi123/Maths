package com.example.maths;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users_db";
    public static final String TABLE_NAME="users";
    public static final String COLUMN_FIRST_NAME="FIRST_NAME";
    public static final String COLUMN_LAST_NAME="LAST_NAME";
    public static final String COLUMN_EMAIL="EMAIL";
    public static final String COLUMN_PASSWORD="PASSWORD";
    public static final String COLUMN_IMAGE="IMAGE";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_FIRST_NAME + " TEXT, "
                    + COLUMN_LAST_NAME + " TEXT, "
                    + COLUMN_EMAIL + " TEXT PRIMARY KEY , "
                    + COLUMN_PASSWORD + " TEXT, "
                    + COLUMN_IMAGE + " TEXT "
                    + ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    //insert User data to SQLite datbase
    public boolean insertUser(String fname,String lname,String email,String password)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("FIRST_NAME",fname);
        values.put("LAST_NAME",lname);
        values.put("EMAIL",email);
        values.put("PASSWORD",password);
        long ins=db.insert(TABLE_NAME,null,values);
        if(ins==-1) return false;
        else return true;
    }

    //checking if email exists;
   public boolean checkEmail(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT* FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + "=?",new String[]{email});
        if(cursor.getCount()>0)return false;
        else return true;
    }

    //checking the email and the password(Login Fragment)
    public boolean checkLogin(String email,String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(email != null && password != null) {
            cursor = db.rawQuery("select * from " + TABLE_NAME + " where " + COLUMN_EMAIL + "=?" +" and " + COLUMN_PASSWORD + " =?", new String[]{email, password});
        }
        if(cursor.getCount()>0)
            return true;
        else return false;
    }

    public User getUser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT " + COLUMN_FIRST_NAME + " FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + "=?", new String[]{email});
        if (c != null)
            c.moveToFirst();

        User u = new User();
        u.setEMAIL(c.getString(c.getColumnIndex(COLUMN_EMAIL)));
        u.setFIRST_NAME((c.getString(c.getColumnIndex(COLUMN_FIRST_NAME))));
        u.setLAST_NAME((c.getString(c.getColumnIndex(COLUMN_LAST_NAME))));
        u.setPASSWORD(c.getString(c.getColumnIndex(COLUMN_PASSWORD)));

        return u;
    }

    public String getFirstName()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = {COLUMN_FIRST_NAME};
        String selection = COLUMN_FIRST_NAME + " = ? ";
        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        //cursor.moveToFirst();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME));
            buffer.append(name);

        }
        return buffer.toString();
    }

    public ArrayList<String> getDatas(String email) {
        ArrayList<String> datas = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT* FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + "=?", new String[]{email});
        if (result.moveToFirst()) {
            datas.add(result.getString(result.getColumnIndex(COLUMN_FIRST_NAME)));
            datas.add(result.getString(result.getColumnIndex(COLUMN_LAST_NAME)));
            datas.add(result.getString(result.getColumnIndex(COLUMN_EMAIL)));
            datas.add(result.getString(result.getColumnIndex(COLUMN_PASSWORD)));
            return datas;
        }
        return null;
    }

    public int updatePassword(String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PASSWORD, password);
        return db.update(TABLE_NAME, values, COLUMN_EMAIL + " = ?",
                new String[] {email});
    }

    public long insertImage(String img) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IMAGE,img);
        return db.insert(TABLE_NAME, null,values);
    }



}
