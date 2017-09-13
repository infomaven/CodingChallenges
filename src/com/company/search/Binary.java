package com.company.search;

/**
 * Created by nadine on 5/12/16.
 */
public class Binary {
    /*
    @about: Returns either the index of the location in the array,or -1 if not found
 *  1. Input must be sorted   2. Collection must allow random access (indexing) -> Array structure implied
 - Worst case : O(log n)
 - Avg case time: O(log n)
 - Best case : O(1)
  */
    protected static int iterativeBinary(int[] array, int targetValue) {
        int min = 0;
        int max = array.length - 1;
        int  guess;

        while( min <= max ) {
            guess = (min + max) / 2;

            if (array[guess] == targetValue) {return guess;}
            if(array[guess] < targetValue){min = guess + 1;}
            if (array[guess] > targetValue) {max = guess - 1;}
        }
        return -1;
    }

    public static void main( String[] args) {
        int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        int actual = iterativeBinary(primes, 73);
        int expected = 20;
        String testResult = (actual == expected) ? "PASS" : "FAIL:  Expected= " + expected + " Actual= " + actual;
        System.out.println( testResult );


    }

}
