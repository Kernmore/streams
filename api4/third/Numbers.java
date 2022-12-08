package com.streams.api4.third;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Numbers {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>(List.of(4, 23, 431, 247, 342, 29, -45, 5, 88));

        integers.stream()
                .filter(n -> n > 10)
                .sorted(Comparator.comparingInt(Numbers::checkLastDigit))
                .forEach(n -> System.out.println(n));
    }
    
    private static int checkLastDigit(int number){
        String s = Integer.toString(number);
        return s.charAt(s.length() - 1);
    }
}
