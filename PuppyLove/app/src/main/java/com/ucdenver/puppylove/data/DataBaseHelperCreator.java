package com.ucdenver.puppylove.data;

import android.content.Context;

public final class DataBaseHelperCreator {

    public DataManager Create(Context context) {
        DataManager response = new DataManager(context);
        return response;
    }
}
