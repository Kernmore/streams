package com.streams.api6.second;

import java.util.List;

public class ListMultiplication {
    public static void main(String[] args) {

        List<Integer> integers = List.of(4, 5, 10, 3);

        Integer result = integers.stream()
                .reduce(1, (a, b) -> a * b);

        System.out.println(result);
    }
}
