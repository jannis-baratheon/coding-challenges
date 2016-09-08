package com.jwisniowski.katas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class AllSubarraysOfAnArray_bits implements AllSubarraysOfAnArray {
    public int[][] solve(final int[] arr) {
        final List<Integer> inputAsList = Arrays.stream(arr).boxed().collect(toList());

        return IntStream
                .range(0, powOf2(arr.length))
                .mapToObj(m -> applyMask(inputAsList, m))
                .distinct()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    private List<Integer> applyMask(final List<Integer> baseCollection, final int mask) {
        if (mask == 0) {
            return Collections.emptyList();
        }

        return IntStream
                .range(0, baseCollection.size())
                .filter(i -> (mask & (powOf2(i))) != 0)
                .map(i -> baseCollection.get(i))
                .boxed()
                .collect(toList());
    }

    private int powOf2(int pow) {
        return 1 << pow;
    }
}
