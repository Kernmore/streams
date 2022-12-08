package com.streams.api5.second;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ChooseLanguage {
    public static void main(String[] args) {
        ProgrammingLanguage lang1 = new ProgrammingLanguage("Haskell", DifficultyLevel.HARD);
        ProgrammingLanguage lang2 = new ProgrammingLanguage("Python", DifficultyLevel.EASY);
        ProgrammingLanguage lang3 = new ProgrammingLanguage("Java", DifficultyLevel.MEDIUM);
        ProgrammingLanguage lang4 = new ProgrammingLanguage("C++", DifficultyLevel.HARD);
        ProgrammingLanguage lang5 = new ProgrammingLanguage("JS", DifficultyLevel.EASY);

        List<ProgrammingLanguage> languages = List.of(lang1, lang2, lang3, lang4, lang5);

        System.out.println("Choose the difficulty: Easy, Medium, Hard");
        Scanner sc = new Scanner(System.in);
        String diff = sc.nextLine().toUpperCase();

        DifficultyLevel level = DifficultyLevel.valueOf(diff);


        Optional<ProgrammingLanguage> result = languages.stream()
                .filter(n -> n.getComplexity().equals(level))
                .findAny();

        System.out.println(result.get());

    }
}
