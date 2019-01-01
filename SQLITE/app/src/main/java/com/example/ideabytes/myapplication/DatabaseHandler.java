package com.example.ideabytes.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION= 1;
    private static final String DATABASE_NAME= "detailManager";
    private static final String TABLE_NAME= "details";
    private static final String KEY_ID= "id";
    private static final String KEY_NAME= "name";
    private static final String KEY_PASSWORD= "password";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public  void onCreate(SQLiteDatabase db){
        db.execSQL("create table " +TABLE_NAME+ " (id INTEGER PRIMARY KEY , name TEXT, password TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean onInsert(String ID, String NAME, String PASWD){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ID, ID);
        values.put(KEY_NAME, NAME);
        values.put(KEY_PASSWORD, PASWD);
       long k = db.insert(TABLE_NAME, null, values);
       if (k == -1){
           return false;
       }else {
           return true;
       }

    }
    public  int onDelete(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        int i =db.delete(TABLE_NAME, KEY_ID + " = ?",
                new String[] { id });
        return i;

    }
    public boolean onUpdate(String id,String name,String pswd){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,id);
        values.put(KEY_NAME,name);
        values.put(KEY_PASSWORD,pswd);
        db.update(TABLE_NAME, values, KEY_ID + " = ?",
                new String[] {id});
        return true;

    }
}
