package com.example.patel.lab3checking;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

/**
 * Created by patel on 02/03/2018.
 */

public class ChatDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Messages.db";
    public static int VERSION_NUM= 4;
    public static final String KEY_ID= "id";
    public static final String KEY_Message = "message";
    public static final String TABLE_NAME = "Chat_window";

    public ChatDatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUM);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_Message + " TEXT)");
        Log.i("ChatDatabaseHelper", "Caling OnCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old_version, int new_version) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        Log.i("ChatDatabaseHelper", "to old database version " + old_version +" to new database version: " +  new_version );
        onCreate(db);
    }

    public void insertData(String msg){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_Message, msg);
        long insertResult = db.insert(TABLE_NAME, null, contentValues);
        Log.i("ChatDatabaseHelper", "insert data result: " + insertResult );
    }

}



