package com.streams.api2.second;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RemoveSymbols {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        String text = "lets go 354534 іпаопвао";

//        List<String> array = Stream.of(chars)
//                .map(a -> String.valueOf(a))
//                .toList();
//
//        System.out.println(array);

        String[] array = text.split("");
        StringBuilder engText = new StringBuilder();

        Arrays.stream(array)
                .filter(a -> pattern.matcher(a).find())
                .forEach(a -> engText.append(a));

        System.out.println(engText);

        char[] newChar = text.toCharArray();
    }
}
