package com.streams.api6.third;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class NewMaxMethod {
    public static void main(String[] args) {

        List<Integer> integers = List.of(4, 5, 15, 3, 11);

        BinaryOperator<Integer> bop = (a, b) -> a > b ? a : b;

        Optional<Integer> maxElement = integers.stream()
                .reduce(bop);

        System.out.println(maxElement.get());
    }
}
