package com.company.search;

/**
 * Created by nadine on 9/11/17.
 * Time complexity is logarithmic because array size gets halved each time
 * 1. Input array must be sorted   2. Collection must allow random access (indexing)
 - Worst case performance: O(log n)
 - Best case performance: O(1)
 */
public class RecursiveBinary {

    public static int recursiveBinary( int[] sortedArray, int start, int end, int key ) {

        if (start < end ) {
            // shorten the array
            int mid = start + (end - start)/2;
            if (key < sortedArray[mid] ) return recursiveBinary( sortedArray, start, mid, key);
            else if ( key > sortedArray[mid] ) return recursiveBinary( sortedArray, mid + 1, end, key );
            else return mid; }
        return - (start + 1);
    }

    public static void main( String[] args ) {

        int[] arr1 = {2, 45, 234, 567, 876, 900, 976, 999 };
        int index = recursiveBinary( arr1, 0, arr1.length, 45 );
        System.out.println( "Found 45 at " + index + " index");

        index = recursiveBinary( arr1, 0, arr1.length, 999 );
        System.out.println("Found 999 at " + index  + " index");

        index = recursiveBinary( arr1, 0, arr1.length, 876 );
        System.out.println("Found 876 at " + index + " index");

        }
    }

