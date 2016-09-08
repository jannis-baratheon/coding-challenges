package com.jwisniowski.katas;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class AllSubarraysOfAnArray_bigInteger implements AllSubarraysOfAnArray {
    @Override
    public int[][] solve(final int[] arr) {
        BigInteger numSubarrays = BigInteger.ZERO.setBit(arr.length);
        Set<LinkedList<Integer>> subarrays = new HashSet<>();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(numSubarrays) < 0; i = i.add(BigInteger.ONE)) {
            LinkedList<Integer> subarray = new LinkedList<>();

            for (int j = 0; j < arr.length; j++) {
                if (i.testBit(j)) {
                    subarray.add(arr[j]);
                }
            }

            subarrays.add(subarray);
        }

        return subarrays.stream().map(s -> s.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}