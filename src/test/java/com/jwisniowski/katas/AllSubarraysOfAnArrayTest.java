package com.jwisniowski.katas;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public abstract class AllSubarraysOfAnArrayTest {

    private final Supplier<AllSubarraysOfAnArray> sutProducer;

    private AllSubarraysOfAnArray sut;

    protected AllSubarraysOfAnArrayTest(Supplier<AllSubarraysOfAnArray> sutProducer) {
        this.sutProducer = sutProducer;
    }

    @Before
    public void setUp() throws Exception {
        sut = sutProducer.get();
    }

    @Test
    public void shouldGetAllSubarraysOfADistinctArray() throws Exception {
        // act
        List<List<Integer>> solution = Arrays.stream(sut.solve(new int[]{1, 2, 3}))
                .map(arr -> IntStream.of(arr).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());

        // verify
        assertThat(solution,
                containsInAnyOrder(
                        containsInAnyOrder(),
                        containsInAnyOrder(1),
                        containsInAnyOrder(2),
                        containsInAnyOrder(3),
                        containsInAnyOrder(1, 2),
                        containsInAnyOrder(1, 3),
                        containsInAnyOrder(2, 3),
                        containsInAnyOrder(1, 2, 3)));
    }

    @Test
    public void shouldGetAllSubarraysOfANonUniqueArray() throws Exception {
        // act
        List<List<Integer>> solution = Arrays.stream(sut.solve(new int[]{1, 2, 1}))
                .map(arr -> IntStream.of(arr).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());

        // verify
        assertThat(solution,
                containsInAnyOrder(
                        containsInAnyOrder(),
                        containsInAnyOrder(1),
                        containsInAnyOrder(2),
                        containsInAnyOrder(1, 2),
                        containsInAnyOrder(1, 1),
                        containsInAnyOrder(2, 1),
                        containsInAnyOrder(1, 2, 1)));
    }

}