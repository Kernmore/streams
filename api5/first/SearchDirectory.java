package com.streams.api5.first;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

public class SearchDirectory {
    public static void main(String[] args) {
        File directory = new File(System.getProperty("user.home"));
        File[] directories = directory.listFiles();

        Optional<File> optional = Arrays.stream(directories)
                .filter(File::isDirectory)
                .filter(SearchDirectory::hasMoreThanThree)
                .findAny();

        if (optional.isPresent()) {
            File result = optional.get();
            System.out.println(result.getAbsoluteFile());
        }
    }

    private static boolean hasMoreThanThree(File directory) {
        File[] files = directory.listFiles();
        int count = 0;
        if (files != null) {
            for (File file : files) {
                if (count >= 3) {
                    return true;
                }
                if (file.isFile()) {
                    if (isTextFile(file.getName())) {
                        count++;
                    }
                }
            }
        }
        return false;
    }


    private static boolean isTextFile(String string) {
        String[] extension = string.split("\\.");
        return extension[extension.length - 1].equals("txt");
    }
}
