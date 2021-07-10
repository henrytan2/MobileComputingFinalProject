package com.ucdenver.puppylove.data.instances;

import com.ucdenver.puppylove.data.DataSingleton;
import com.ucdenver.puppylove.data.interfaces.IDog;

import java.util.ArrayList;

import android.database.Cursor;
import android.util.Log;

public class Dog implements IDog {
    @Override
    public ArrayList<com.ucdenver.puppylove.data.models.Dog> fetchAll() {
        Cursor cursor = null;
        String query = "select * from dogs";
        ArrayList<com.ucdenver.puppylove.data.models.Dog> response = null;
        try {
            cursor = DataSingleton.instance.getReadableDatabase().rawQuery(query, null);
            while (cursor.moveToNext()) {
                response.add(new com.ucdenver.puppylove.data.models.Dog(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getString(4)
                ));
            }
        } catch (Exception ex) {
            Log.i("info", ex.getMessage());
        }
        return response;
    }

    @Override
    public com.ucdenver.puppylove.data.models.Dog fetchRandom() {
        Cursor cursor = null;
        String query = "select * from dogs order by random() limit 1";
        com.ucdenver.puppylove.data.models.Dog response = null;
        try {
            cursor = DataSingleton.instance.getReadableDatabase().rawQuery(query, null);
            while (cursor.moveToNext()) {
                response = new com.ucdenver.puppylove.data.models.Dog(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getString(4)
                );
            }
        } catch (Exception ex) {
            Log.i("info", ex.getMessage());
        }
        return response;
    }
}
