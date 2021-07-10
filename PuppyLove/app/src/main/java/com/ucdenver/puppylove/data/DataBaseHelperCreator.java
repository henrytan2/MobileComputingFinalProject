package com.ucdenver.puppylove.data;

import android.content.Context;

public final class DataBaseHelperCreator {

    public DataBaseHelper Create(Context context) {
        DataBaseHelper response = new DataBaseHelper(context);
        return response;
    }
}
