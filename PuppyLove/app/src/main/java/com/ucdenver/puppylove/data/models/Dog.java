package com.ucdenver.puppylove.data.models;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Dog {
    static public final String tableName = "dogs";
    static public final String idColumn = "id";
    static public final String nameColumn = "name";
    static public final String ageColumn = "age";
    static public final String breedColumn = "breed";
    static public final String descriptionColumn = "description";
    static public final String imageFilePathColumn = "imageFilePath";

    static public void CreateTable(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + tableName
                + "(" + idColumn + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + nameColumn + "TEXT, "
                + ageColumn + "TEXT, "
                + breedColumn + "TEXT, "
                + descriptionColumn + "TEXT, "
                + imageFilePathColumn + "TEXT)";
        try {
            db.execSQL(createTableQuery);
        } catch (SQLException ex) {
            Log.i("info" , ex.getMessage());
        }
    }

    private int id;
    private String name;
    private int age;
    private String breed;
    private String description;
    private String imageFilePath;

    public Dog() {}

    public Dog(int id, String name, int age, String breed, String imageFilePath) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.imageFilePath = imageFilePath;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed(String breed) {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageFilePath() {
        return this.imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }
}
