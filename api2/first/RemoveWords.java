package com.streams.api2.first;

import java.util.Arrays;
import java.util.List;

public class RemoveWords {
    public static void main(String[] args) {

        String text = "Find the selector and choose the required option to use the tool you wanted";

        String[] strings = text.split(" ");
        String[] newStrings = Arrays.stream(strings)
                .filter(a -> a.length() > 5)
                .toArray(String[]::new);

        System.out.println(Arrays.toString(newStrings));
    }
}
