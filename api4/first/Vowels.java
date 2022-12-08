package com.streams.api4.first;

import com.functional.function.second.Consonant;

public enum Vowels {
    a, e, i, o, u, y, A, E, I, O, U, Y;

    public static boolean isVowel(Character character) {

        for (Vowels c : Vowels.values()) {
            if(c.toString().equalsIgnoreCase(character.toString())){
                return true;
            }
        }
        return false;
    }
}
