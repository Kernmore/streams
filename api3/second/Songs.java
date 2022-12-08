package com.streams.api3.second;

import java.util.Arrays;
import java.util.List;

public class Songs {
    public static void main(String[] args) {
        Singer singer1 = new Singer("Freddie Mercury", new String[] { "We Are the Champions", "Somebody to Love" });
        Singer singer2 = new Singer("David Bowie",new String[] { "Space Oddity", "Let Me Sleep Beside You", "Suffragette City" });
        Singer singer3 = new Singer("James Paul McCartney", new String[] { "Can’t Buy Me Love", "Another Girl" });
        Singer[] rockStars = new Singer[] { singer1, singer2, singer3 };

        List<String> songs = Arrays.stream(rockStars)
                .flatMap(n -> Arrays.stream(n.getSongs()))
                .sorted()
                .limit(3)
                .toList();

        System.out.println(songs);
    }
}
