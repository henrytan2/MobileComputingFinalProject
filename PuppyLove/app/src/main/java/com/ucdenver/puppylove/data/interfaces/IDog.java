package com.ucdenver.puppylove.data.interfaces;
import com.ucdenver.puppylove.data.models.Dog;

import java.util.ArrayList;

public interface IDog {
    ArrayList<Dog> fetchAll();
    Dog fetchRandom();
    void insert(String name, int age, String breed,
                String description, String imageFilepath);
}
