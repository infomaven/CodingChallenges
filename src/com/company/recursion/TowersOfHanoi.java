package com.company.recursion;

import java.util.Scanner;

/**
 * Created by nadine on 5/31/16.
 * 3 rods used. A number of disks of different sizes.
 * 1) Disks can be moved one at a time to any rod
 * 2) Smallest should always be on top.
 * 3) Move = taking upper disk from one stack and placing it on another stack
 *
 */
public class TowersOfHanoi {

    public void solve(int n, String start, String aux, String end) {
        if (n ==1) {
            System.out.println( start + " -> " + end);
        } else {
            solve( n - 1, start, end, aux);
            System.out.println( start + " -> " + end);
            solve( n - 1, aux, start, end );
        }
    }

    public static void main( String[] args ) {
        TowersOfHanoi towers = new TowersOfHanoi();
        System.out.println( "Enter total number of disks to be moved: ");
        Scanner scanner = new Scanner( System.in);
        int discs = scanner.nextInt();
        towers.solve( discs, "A", "B", "C");

    }

}
