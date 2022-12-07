package com.streams.api2.fourth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Xml {
    public static void main(String[] args) {
        String xml = "<dependency>\n" +
                "<groupId>junit</groupId>\n" +
                "<artifactId>junit</artifactId>\n" +
                "<version>4.4</version>\n" +
                "<scope>test</scope>\n" +
                "</dependency>\n" +
                "<dependency>\n" +
                "<groupId>org.powermock</groupId>\n" +
                "<artifactId>powermock-reflect</artifactId>\n" +
                "<version>3.2</version>\n" +
                "</dependency>";

        xml = xml.replaceAll("<", " ");
        xml = xml.replaceAll(">", " ");
        String[] arr = xml.split(" ");

//        System.out.println(Arrays.toString(arr));
        List<String> list = Arrays.stream(arr)
                .peek(a -> a.trim())
                .dropWhile(a -> (!a.equals("groupId")))
                .dropWhile(a -> (a.equals("groupId")))
                .takeWhile(a -> (!a.equals("/groupId")))
                .toList();

        List<String> list2 = Arrays.stream(arr)
                .peek(a -> a.trim())
                .dropWhile(a -> (!a.equals("/groupId")))
                .dropWhile(a -> (!a.equals("groupId")))
                .dropWhile(a -> (a.equals("groupId")))
                .takeWhile(a -> (!a.equals("/groupId")))
                .toList();

        List<String> result = new ArrayList<>(list);
        result.addAll(list2);
        System.out.println(result);

    }
}
