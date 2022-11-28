package com.streams.api1.first;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {

        Cats cat1 = new Cats("Luska", 5, "White");
        Cats cat2 = new Cats("Umka", 7, "Black");
        Cats cat3 = new Cats("Barsic", 2, "Red");
        Cats cat4 = new Cats("Kuzia", 3, "Grey");

        List<Cats> cats = new ArrayList<>(List.of(cat1, cat2, cat3, cat4));

        Optional<String> op = cats.stream()
                .map(Cats::getName)
                .max(Comparator.comparingInt(String::length));

        System.out.println(op.get());
    }
}
