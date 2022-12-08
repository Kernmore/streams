package com.streams.api3.third;

import java.io.File;
import java.util.Arrays;

public class CollectFiles {

    public static void main(String[] args) {

        File directory = new File("Rust");

        File[] files = directory.listFiles();

        Arrays.stream(files)
                .map(n -> n.getName())
                .filter(CollectFiles::isTextFile)
                .forEach(n -> System.out.println(n));
    }

    private static boolean isTextFile(String string) {
        String[] extension = string.split("\\.");
        if (extension[extension.length - 1].equals("txt")) {
            return true;
        }
        return false;
    }


}
