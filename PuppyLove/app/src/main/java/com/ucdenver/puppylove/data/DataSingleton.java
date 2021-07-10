package com.ucdenver.puppylove.data;

public final class DataSingleton {
    static public DataBaseHelper instance;

    static public void SetInstance(DataBaseHelper _instance) {
        instance = _instance;
    }
}
