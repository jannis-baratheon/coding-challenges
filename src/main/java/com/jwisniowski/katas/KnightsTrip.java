package com.jwisniowski.katas;

/*

URL: https://open.kattis.com/problems/knightstrip

In chess, each move of a knight consists of moving by two squares horizontally and one square vertically, or by one
square horizontally and two squares vertically. A knight making one move from location (0,0)(0,0) of an infinite chess
board would end up at one of the following eight locations: (1,2)(1,2), (−1,2)(−1,2), (1,−2)(1,−2), (−1,−2)(−1,−2),
(2,1)(2,1), (−2,1)(−2,1), (2,−1)(2,−1), (−2,−1)(−2,−1).

Starting from location (0,0)(0,0), what is the minimum number of moves required for a knight to get to some other
arbitrary location (x,y)(x,y)?

Input
Each line of input contains two integers xx and yy, each with absolute value at most one billion. The integers designate
a location (x,y)(x,y) on the infinite chess board. The final line contains the word END.

Output
For each location in the input, output a line containing one integer, the minimum number of moves required for a knight
to move from (0,0)(0,0) to (x,y)(x,y).

Time limit: 1 second
Memory limit: 1024 MB

*/

import java.util.Scanner;

public class KnightsTrip {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KnightsTrip knightsTrip = new KnightsTrip();

        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            System.out.println(knightsTrip.solve(x, y));
        }
    }

    public int solve(int x, int y) {
        x = abs(x);
        y = abs(y);

        if (y < x) {
            int temp = x;
            x = y;
            y = temp;
        }

        int moves = getSpecialCaseSolution(x, y);

        if (moves != -1) {
            return moves;
        }

        int baseVal = getBaseVal(x, y);
        int val = getValAt(baseVal);
        int adjustment = getAdjustmentAt(x, y, baseVal);

        return val + adjustment;
    }

    private int abs(int n) {
        return n < 0 ? n * -1 : n;
    }

    private int getSpecialCaseSolution(int x, int y) {
        if (x == 0 && y == 1) {
            return 3;
        }

        if (x == 2 && y == 2) {
            return 4;
        }

        return -1;
    }

    private int getBaseVal(int x, int y) {
        if (y >= 2 * x) {
            return y;
        }

        return (int) ((x + y) * 2L / 3);
    }

    private int getValAt(int baseVal) {
        return baseVal / 4 * 2 + baseVal % 4;
    }

    private int getAdjustmentAt(int x, int y, int baseVal) {
        return  ((int)((x + y + (long)baseVal) % 2) * (baseVal / 2 % 2 * -2 + 1));
    }
}
