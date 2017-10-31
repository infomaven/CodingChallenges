package com.company.sorting;

import java.util.LinkedList;
import java.util.Queue;

/*
Stable-sort algorithm: iterates starting with lowest significant digit.
This makes the algorithm more stable - identical elements are sorted in same order that they appear in the input
 */
public class Radix {

    public static void sort( int[] arr ) {
        Queue<Integer>[] buckets = new Queue[10];

        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<Integer>();
        }
        boolean sorted = false;
        int expo = 1;

        while (!sorted ) {
            sorted = true;
            for ( int item:arr ) {
                int bucket = (item/expo) % 10;
                if (bucket > 0 ) {
                    sorted = false;
                }
                buckets[bucket].add(item);
            }
            expo *= 10;
            int index = 0;
            for (Queue<Integer> bucket : buckets ) {
                while( !bucket.isEmpty() ) {
                    arr[index++] = bucket.remove();
                }
            }
        }
        assert isSorted( arr );
    }

    // helper method (for testing)
    private static boolean isSorted( int[] arr ) {
        for ( int i = 1; i < arr.length; i++ ) {
            if( arr[i - 1] > arr[i] ) {
                return false;
            }
        }

        return true;
    }

    private static void printMe( int[] arr ) {
        for (int i =0; i < arr.length; i++ ) {
            System.out.println( arr[i] );
        }
    }

    public static void main( String[] args ) {
        int[] sortedResult = new int[]{};
        int[] intArray1 = new int[] {100, 20, 5, 4, 66, 8, 10, 250 };
        sort( intArray1 );
        printMe( intArray1 );
    }
}
