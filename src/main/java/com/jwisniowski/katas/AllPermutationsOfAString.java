package com.jwisniowski.katas;

import java.util.HashSet;
import java.util.Set;

/*

Given a string, write a function to print all permutations of given string. The output collection should be unique.
The input may contain duplicate characters

Write a function:
class Solution { public String[] solve(String str); }
that given a String str returns an array of all of its permutations. The returned array should be unique.

*/

public class AllPermutationsOfAString {
    public String[] solve(final String str) {
        return permutate(str);
    }

    private String[] permutate(String str) {
        if (str.length() < 2) {
            return new String[]{str};
        }

        if (str.length() == 2) {
            return new String[]{str, new StringBuilder(str).reverse().toString()};
        }

        String head = str.substring(0, 1);
        String tail = str.substring(1);

        String[] tailPermutations = permutate(tail);
        Set<String> result = new HashSet<>();

        for (String tailPermutation : tailPermutations) {
            for (int i = 0; i < tailPermutation.length() + 1; i++) {
                String left = tailPermutation.substring(0, i);
                String right = tailPermutation.substring(i);

                result.add(left + head + right);
            }
        }

        return result.stream().toArray(String[]::new);
    }
}
