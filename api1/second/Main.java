package com.streams.api1.second;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(3, 4, 56, 72, 4345, 657, 12, 21));

        List<Integer> newList = list.stream()
                .filter(a -> a % 2 != 0)
                .sorted()
                .toList();

        System.out.println(newList);
    }
}
