package com.example.utopiacities.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.utopiacities.model.Utopia;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    private String TAG = "Gioi";
    private static final String DATABASE_NAME = "utopia_manager";
    private static final String TABLE_NAME = "utopia";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SUBTITLES = "subtitles";
    private static final String NUMBER = "number";
    private static final int VERSION = 1;

    private Context context;
    private String SQLQuery ="CREATE TABLE "+TABLE_NAME +" ("+
            ID + " integer primary key, "+
            NAME + " TEXT, "+
            SUBTITLES +" TEXT, " +
            NUMBER + " TEXT)";
    //
    public DBManager (Context context){
        super(context,DATABASE_NAME,null,VERSION);
        this.context = context;
        Log.d(TAG, "DBManager: ");
    }
    //

    public void hello(){
        Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG, "onUpgrade: ");
    }

    public void addUtopia(Utopia utopia) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, utopia.getName());
        values.put(SUBTITLES, utopia.getSubTitles());
        values.put(NUMBER, utopia.getNumber());

        db.insert(TABLE_NAME, null, values);
        db.close();
        Log.d(TAG, "addUtopia: ");
    }

    public List<Utopia> getAllUtopia(){
        List<Utopia> listUtopia = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                Utopia utopia = new Utopia();
                utopia.setName(cursor.getString(1));
                utopia.setSubTitles(cursor.getString(2));
                utopia.setNumber(cursor.getString(3));
                listUtopia.add(utopia);
            }while (cursor.moveToNext());
        }
        db.close();
        return listUtopia;
    }
}
