package com.streams.api7.second;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

public class Main {
    public static void main(String[] args) {

        Predicate<String> predicate = string -> {
            char[] chars = string.toCharArray();
            for (char c : chars) {
                if (Vowels.isVowel(c)){
                    return true;
                }
            }
            return false;
        };
        String text = "Took a trip back home, went to Hell and then back " +
                "Hd dwn, I don't knw whr I'm t " +
                "Probably at the cemetery tkng dope to the head " +
                "Fifty blunts to the neck, with the team that's SESH ";

        Collector<String, Map<String, Integer>, Map<String, Integer>> collector = new WordsWithVowels(predicate);

        Map<String, Integer> map = Arrays.stream(text.split(" ")).collect(collector);

        System.out.println(map);

    }
}

class WordsWithVowels implements Collector<String, Map<String, Integer>, Map<String, Integer>>{
    private Predicate<String> isVowel;

    public WordsWithVowels(Predicate<String> isVowel){
        this.isVowel = isVowel;
    }
    @Override
    public Supplier<Map<String, Integer>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer <Map<String, Integer>, String> accumulator() {
        return (map, e ) -> {
            if(isVowel.test(e)){
                map.put(e, Vowels.countVowels(e));
            }
        };
    }

    @Override
    public BinaryOperator<Map<String, Integer>> combiner() {
        return (map1, map2) -> {
            HashMap result = new HashMap(map1);
            result.putAll(map2);
            return result;
        };
    }

    @Override
    public Function <Map<String, Integer>, Map<String, Integer>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED);
    }
}


enum Vowels {
    a, e, i, o, u, y, A, E, I, O, U, Y;

    public static boolean isVowel(Character character) {
        for (Vowels c : Vowels.values()) {
            if(c.toString().equalsIgnoreCase(character.toString())){
                return true;
            }
        }
        return false;
    }

    public static int countVowels(String a) {
        int result = 0;
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(com.streams.api4.first.Vowels.isVowel(chars[i])){
                result++;
            }
        }
        return result;
    }
}