package com.streams.api8.second;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileSize {
    public static void main(String[] args) {
        File directory = new File(System.getProperty("user.home"));

        Function<File, String> function = file -> {
            String temp;
            double size = file.length();
            if (size < 1000) {
                temp = "small";
            } else if (size < 100000) {
                temp = "average";
            } else {
                temp = "big";
            }
            return temp;
        };

        Map<String, List<File>> map = Arrays.stream(directory.listFiles())
                .collect(Collectors.groupingBy(function));


        map.forEach((k, v) -> System.out.println(k + ": " + v));

    }
}
