package com.jwisniowski.katas;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static java.util.stream.Collectors.joining;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KnightsTripTest {

    private KnightsTrip sut;

    @Before
    public void setUp() throws Exception {
        sut = new KnightsTrip();
    }

    @Test
    public void cornerCaseTc1() {
        // act
        int result = sut.solve(1, 0);

        // assert
        assertThat(result, is(equalTo(3)));
    }

    @Test
    public void cornerCaseTc2() {
        int result = sut.solve(2, 2);

        assertThat(result, is(equalTo(4)));
    }

    @Test
    public void cornerCaseTc3() {
        // act
        int result = sut.solve(0, 1);

        // assert
        assertThat(result, is(equalTo(3)));
    }

    @Test
    public void cornerCaseTc4() {
        // act
        int result = sut.solve(0, -1);

        // assert
        assertThat(result, is(equalTo(3)));
    }

    @Test
    public void cornerCaseTc5() {
        // act
        int result = sut.solve(-1, 0);

        // assert
        assertThat(result, is(equalTo(3)));
    }

    @Test
    public void cornerCaseTc6() {
        // act
        int result = sut.solve(0, 0);

        // assert
        assertThat(result, is(equalTo(0)));
    }

    @Test
    public void cornerCaseTc7() {
        // act
        int result = sut.solve(1000000000, 1000000000);

        // assert
        assertThat(result, is(equalTo(666666668)));
    }

    @Test
    public void cornerCaseTc8() {
        // act
        int result = sut.solve(-1000000000, -1000000000);

        // assert
        assertThat(result, is(equalTo(666666668)));
    }

    @Test
    public void cornerCaseTc9() {
        // act
        int result = sut.solve(1000000000, -1000000000);

        // assert
        assertThat(result, is(equalTo(666666668)));
    }

    @Test
    public void cornerCaseTc10() {
        // act
        int result = sut.solve(-1000000000, 1000000000);

        // assert
        assertThat(result, is(equalTo(666666668)));
    }

    @Test
    public void basicTc1() {
        // act
        int result = sut.solve(7, 7);

        // assert
        assertThat(result, is(equalTo(6)));
    }

    @Test
    public void basicTc2() {
        // act
        int result = sut.solve(9, 4);

        // assert
        assertThat(result, is(equalTo(5)));
    }

    @Test
    public void basicTc3() {
        // act
        int result = sut.solve(9, 3);

        // assert
        assertThat(result, is(equalTo(6)));
    }

    @Test
    public void basicTc4() {
        // act
        int result = sut.solve(4, 2);

        // assert
        assertThat(result, is(equalTo(2)));
    }

    @Test
    public void basicTc5() {
        // act
        int result = sut.solve(5, 2);

        // assert
        assertThat(result, is(equalTo(3)));
    }

    @Test
    public void basicTc6() {
        // act
        int result = sut.solve(6, 2);

        // assert
        assertThat(result, is(equalTo(4)));
    }

    @Test
    public void basicTc7() {
        // act
        int result = sut.solve(7, -2);

        // assert
        assertThat(result, is(equalTo(5)));
    }

    @Test
    public void basicTc8() {
        // act
        int result = sut.solve(-1, 1);

        // assert
        assertThat(result, is(equalTo(2)));
    }

    @Test
    public void firstQuarterTc() {
        // act
        int rows = 13;
        int cols = 13;
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < cols; i++) {
            LinkedList<Integer> rowValues = new LinkedList<>();

            for (int j = 0; j < rows; j++) {
                rowValues.add(sut.solve(j, i));
            }

            resultBuilder.append(rowValues.stream().map(Object::toString).collect(joining(",")));
            resultBuilder.append("|");
        }

        // assert
        assertThat(resultBuilder.toString(),
            is(equalTo(
                "0,3,2,3,2,3,4,5,4,5,6,7,6|" +
                "3,2,1,2,3,4,3,4,5,6,5,6,7|" +
                "2,1,4,3,2,3,4,5,4,5,6,7,6|" +
                "3,2,3,2,3,4,3,4,5,6,5,6,7|" +
                "2,3,2,3,4,3,4,5,4,5,6,7,6|" +
                "3,4,3,4,3,4,5,4,5,6,5,6,7|" +
                "4,3,4,3,4,5,4,5,6,5,6,7,6|" +
                "5,4,5,4,5,4,5,6,5,6,7,6,7|" +
                "4,5,4,5,4,5,6,5,6,7,6,7,8|" +
                "5,6,5,6,5,6,5,6,7,6,7,8,7|" +
                "6,5,6,5,6,5,6,7,6,7,8,7,8|" +
                "7,6,7,6,7,6,7,6,7,8,7,8,9|" +
                "6,7,6,7,6,7,6,7,8,7,8,9,8|")));
    }
}