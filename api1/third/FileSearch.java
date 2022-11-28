package com.streams.api1.third;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class FileSearch {
    public static void main(String[] args) {

        String pathToFiles = "Rust";
        File directory = new File(pathToFiles);
        File[] files = directory.listFiles();
        Optional<String> max = Arrays.stream(files)
                .max(Comparator.comparing(File::length))
                .map(File::getName);

        String maxFile = max.get();
        System.out.println(maxFile);
    }
}
