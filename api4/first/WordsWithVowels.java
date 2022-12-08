package com.streams.api4.first;

import java.util.Arrays;

public class WordsWithVowels {

    public static void main(String[] args) {
        String text = "Shhh, sunshine has touched my skin, brr";

        String[] strings = text.split(" ");
        Arrays.stream(strings)
                .filter(a -> countVowels(a) != 0)
                .sorted(WordsWithVowels::compareWords)
                .forEach(n -> System.out.println(n));
    }

    private static int compareWords(String s, String s1) {
        return countVowels(s) - countVowels(s1);
    }

    private static int countVowels(String a) {
        int result = 0;
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(Vowels.isVowel(chars[i])){
                result++;
            }
        }
        return result;
    }

}
