package com.streams.api8.first;

import java.util.HashMap;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EvenOrOdd {
    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 45, 6, 734, 23, 4);

        Function<Integer, String> keyMapper = a -> (a % 2 == 0) ? "Even" : "Odd";
        Function<Integer, String> valueMapper = a -> a + "";

        BinaryOperator<String> binaryOperator = (a, b) -> a + ";" + b;

        HashMap<String, String> map = integers.stream()
                .collect(Collectors.toMap(keyMapper, valueMapper, binaryOperator, HashMap::new));

        System.out.println(map);
    }
}
