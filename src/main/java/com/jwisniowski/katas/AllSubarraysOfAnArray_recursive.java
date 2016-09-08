package com.jwisniowski.katas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class AllSubarraysOfAnArray_recursive implements AllSubarraysOfAnArray {
    public int[][] solve(int[] input) {
        List<Integer> inputAsList = Arrays.stream(input).boxed().collect(toList());

        return getSublists(inputAsList)
                .stream()
                .distinct()
                .map(c -> c.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    private List<List<Integer>> getSublists(List<Integer> input) {
        if (input.size() == 0) {
            return Collections.singletonList(Collections.emptyList());
        }

        List<Integer> tail = input.stream().skip(1).collect(toList());
        List<List<Integer>> sublistsOfTail = getSublists(tail);

        Stream<List<Integer>> sublists = sublistsOfTail
                .stream()
                .map(s -> union(s, Collections.singletonList(input.get(0))));

        return Stream
                .concat(sublistsOfTail.stream(), sublists)
                .collect(toList());
    }

    private static List<Integer> union(List<Integer> listA, List<Integer> listB) {
        return Stream.concat(listA.stream(), listB.stream()).collect(toList());
    }
}
