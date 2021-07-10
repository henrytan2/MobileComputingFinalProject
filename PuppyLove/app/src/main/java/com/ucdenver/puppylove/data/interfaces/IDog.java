package com.ucdenver.puppylove.data.interfaces;
import com.ucdenver.puppylove.data.models.Dog;

import java.util.ArrayList;

public interface IDog {
    ArrayList<Dog> fetchAll();
    Dog fetchRandom();
}
