package com.streams.api2.third;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Abra", 5);
        Cat cat2 = new Cat("Luska", 5);
        Cat cat3 = new Cat("Barsic", 2);
        Cat cat4 = new Cat("Kuzia", 3);
        Cat cat5 = new Cat("Doro", 4);

        List<Cat> list = new ArrayList<>(List.of(cat1, cat2, cat3, cat4, cat5));

        List<Cat> newCats = list.stream()
                .filter(a -> a.getAge() > 3)
                .sorted(Comparator.comparing(Cat::getName))
                .toList();

        System.out.println(newCats);
    }
}
