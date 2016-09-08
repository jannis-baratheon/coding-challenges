package com.jwisniowski.katas;

import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
import static org.junit.Assert.assertTrue;

public class AllPermutationsOfAStringTest {
    private AllPermutationsOfAString sut;

    @Before
    public void setUp() throws Exception {
        sut = new AllPermutationsOfAString();
    }

    @Test
    public void shouldPermutateWhenCharsAreUnique() throws Exception {
        // act
        String[] result = sut.solve("abc");

        // verify
        assertThat(result,
                IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(
                        "abc",
                        "acb",
                        "bac",
                        "cab",
                        "bca",
                        "cba"));
    }

    @Test
    public void shouldDealWithDuplicates() throws Exception {
        // act
        String[] result = sut.solve("aac");

        // verify
        assertThat(result,
                IsArrayContainingInAnyOrder.arrayContainingInAnyOrder(
                        "aac",
                        "aca",
                        "caa"));
    }

    @Test
    public void batchTest() throws Exception {
        // arrange
        String sample = "abcdefghij";

        for (int i = 0; i < sample.length(); i++) {
            String smallerSample = sample.substring(0, i);

            // act
            String[] result = sut.solve(smallerSample);

            // verify permutations' lengths
            assertTrue(Arrays.stream(result).allMatch(s -> s.length() == smallerSample.length()));
            // verify uniqueness
            assertThat(result, is(arrayWithSize((int) Arrays.stream(result).distinct().count())));
            // verify length
            assertThat(result, is(arrayWithSize(factorial(smallerSample.length()))));
        }
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return IntStream.rangeClosed(2, n).reduce(1, Math::multiplyExact);
    }
}