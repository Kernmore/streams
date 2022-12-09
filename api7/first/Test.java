package com.streams.api7.first;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.*;
import java.util.stream.Collector;

public class Test {
    public static void main(String[] args) {
        List<Integer> integers = List.of(4, 5, 15, 3, 11);

        Predicate<Integer> predicate = a -> a % 2 == 1;

        Collector<Integer, Set<Integer>, Set<Integer>> collector = new ToSet(predicate);

        Set<Integer> set = integers.stream()
                .collect(collector);

        System.out.println(set);

    }
}

class ToSet implements Collector<Integer, Set<Integer>, Set<Integer>> {
    private Predicate<Integer> addToOrNot;

    public ToSet(Predicate<Integer> predicate) {
        this.addToOrNot = predicate;
    }

    @Override
    public Supplier<Set<Integer>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<Integer>, Integer> accumulator() {
        return (set, element) -> {
            if (addToOrNot.test(element)) {
                set.add(element);
            }
        };
    }

    @Override
    public BinaryOperator<Set<Integer>> combiner() {
        return (set1, set2) -> {
            Set<Integer> result = new HashSet<>();
            result.addAll(set1);
            result.addAll(set2);
            return result;
        };
    }

    @Override
    public Function<Set<Integer>, Set<Integer>> finisher() {
        return a -> {
            return new TreeSet<>(a);
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
