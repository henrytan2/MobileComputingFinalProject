package com.ucdenver.puppylove.data;

import com.ucdenver.puppylove.data.models.Dog;
import com.ucdenver.puppylove.data.models.User;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {

    static private final String dbName = "puppylove";
    static private final int dbVersion = 1;

    public DataBaseHelper(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Dog.CreateTable(db);
            User.CreateTable(db);
        } catch(SQLException ex) {
            Log.i ("info", "In DataBaseHelper class onCreate method");
            Log.i ("info", ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // none
    }
}
