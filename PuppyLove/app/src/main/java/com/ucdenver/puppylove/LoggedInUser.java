package com.ucdenver.puppylove;

import com.ucdenver.puppylove.data.models.User;

public final class LoggedInUser {
    static private com.ucdenver.puppylove.data.models.User instance;

    static public void setInstance(com.ucdenver.puppylove.data.models.User _instance) {
        instance = _instance;
    }

    static public User getInstance() {
        return instance;
    }

    static public void clearInstance() {
        instance = null;
    }
}
