package com.ucdenver.puppylove.data;

import android.database.sqlite.SQLiteDatabase;

public final class DataSingleton {
    static public DataManager instance;

    static public void SetInstance(DataManager _instance) {
        instance = _instance;
    }

}
