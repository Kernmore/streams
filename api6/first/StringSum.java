package com.streams.api6.first;

import java.util.Arrays;
import java.util.Optional;

public class StringSum {
    public static void main(String[] args) {

        String text = "Happy New Year and Christmas";
        String[] strings = text.split(" ");

        Optional<Integer> sumString = Arrays.stream(strings)
                .filter(string -> string.length() > 4)
                .map(n -> n.length())
                .reduce((n, m) -> n + m);

        System.out.println(sumString.get());
    }
}
