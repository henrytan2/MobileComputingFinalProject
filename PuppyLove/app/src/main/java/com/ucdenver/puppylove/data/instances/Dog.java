package com.ucdenver.puppylove.data.instances;

import com.ucdenver.puppylove.data.DataSingleton;
import com.ucdenver.puppylove.data.interfaces.IDog;

import java.util.ArrayList;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class Dog implements IDog {
    @Override
    public ArrayList<com.ucdenver.puppylove.data.models.Dog> fetchAll() {
        Cursor cursor = null;
        String query = "select * from dogs";
        ArrayList<com.ucdenver.puppylove.data.models.Dog> response = null;
        try {
            cursor = DataSingleton.instance.getDB().rawQuery(query, null);
            while (cursor.moveToNext()) {
                response.add(new com.ucdenver.puppylove.data.models.Dog(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
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
            cursor = DataSingleton.instance.getDB().rawQuery(query, null);
            while (cursor.moveToNext()) {
                response = new com.ucdenver.puppylove.data.models.Dog(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
                );
            }
        } catch (Exception ex) {
            Log.i("info", ex.getMessage());
        }
        return response;
    }

    @Override
    public void insert(String name, int age, String breed, String description, String imageFilepath) {
        String query = "insert into dogs " +
                "(" + com.ucdenver.puppylove.data.models.Dog.nameColumn + ", " +
                com.ucdenver.puppylove.data.models.Dog.ageColumn + ", " +
                com.ucdenver.puppylove.data.models.Dog.breedColumn + ", " +
                com.ucdenver.puppylove.data.models.Dog.descriptionColumn + ", " +
                com.ucdenver.puppylove.data.models.Dog.imageFilePathColumn + ") values (" +
                "'" + name + "', " +
                "" + age + ", " +
                "'" + breed + "', " +
                "'" + description + "', " +
                "'" + imageFilepath + "');";
        try {
            DataSingleton.instance.getDB().execSQL(query);
        } catch (Exception ex) {
            Log.i("info", ex.getMessage());
        }
    }
}
