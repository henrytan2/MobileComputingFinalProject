package com.ucdenver.puppylove.data;

import com.ucdenver.puppylove.data.instances.Dog;
import com.ucdenver.puppylove.data.instances.User;
import com.ucdenver.puppylove.data.interfaces.IDog;
import com.ucdenver.puppylove.data.interfaces.IUser;

public final class Interactor {
    static private Interactor instance;
    static private IDog Dog;
    static private IUser User;

    private Interactor() {
        this.Dog = new Dog();
        this.User = new User();
    }

    static public Interactor getInstance() {
        if (instance == null) {
            instance = new Interactor();
        }
        return instance;
    }

    static public IDog getDogInstance() {
        return Dog;
    }

    static public IUser getUserInstance() {
        return User;
    }
}
