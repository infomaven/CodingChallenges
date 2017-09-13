package com.company.search;

import java.util.Random;
import java.util.Scanner;

/*
Searches for sequential pattern of integers in an array
Performs best when the array is sorted.
Best:
Worst:
Avg:

 */
public class BinarySequence {

    public static void findTheSequence(int[] array, int[] search ) {

        int first, last, middle;
        first = 0;
        last = array.length - 1;
        boolean flag =  true;
        for (int i = 0; i < search.length; i++ ) {
            middle = (first+last) / 2;
            while (first <= last && flag == true) {
                if (array[middle] < search[i]) {
                    first = middle + 1;
                } else if (array[middle] == search[i]) {
                    System.out.println( search[i] + " found at location: " + (middle+1) + "!");
                    first = 0;
                    last = array.length - 1;
                    break;
                } else {
                    last = middle - 1;
                }
                middle = (first+last) / 2;
            }
            if (first > last ) {
                System.out.println( search[i] + " is NOT present");
                flag = false;
            }
        }
    }

    public static void main( String args[] ) {

        int c, n, search[], array[];

        Scanner in = new Scanner( System.in );

        System.out.println( "Enter size of search pool: ");
        n = in.nextInt();
        // build the pool of values to search - must be 1 or more
        array = new int[n];
        Random rand = new Random();
        for (c = 0; c < n; c++ ) {
            array[c] = rand.nextInt(100);
        }
        System.out.println("Search Pool Generated: ");
        for ( int i = 0; i < array.length; i++ ) {
            System.out.print( array[i] + " ");
        }

        System.out.println( "\nEnter size of your search pattern: ");
        int m = in.nextInt();
        search = new int[m];
        if (m > array.length) {
            System.out.println("Search pattern is too big. Choose something smaller");
        }

        System.out.println( "Enter search pattern values (no spaces): ");
        for (int i = 0; i < m; i++) {
            search[i] = in.nextInt();
        }

        findTheSequence( array, search );
        in.close();
    }
}
