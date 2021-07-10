package com.ucdenver.puppylove.data;

import com.ucdenver.puppylove.data.instances.Dog;
import com.ucdenver.puppylove.data.interfaces.IDog;

public final class Interactor {

    static private IDog Dog;

    private Interactor() {
        this.Dog = new Dog();
    }

    static public IDog getDogInstance() {
        return Dog;
    }
}
