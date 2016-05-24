package com.company.search;

/**
 * Created by nadine on 5/12/16.
 */
public class Binary {

    public static void main( String[] args) {
        int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

        int actual = doSearch(primes, 73);
        int expected = 20;
        String testResult = (actual == expected) ? "PASS" : "FAIL:  Expected= " + expected + " Actual= " + actual;
        System.out.println( testResult );


    }

    /* Returns either the index of the location in the array,
  or -1 if the array did not contain the targetValue */
    protected static int doSearch (int[] array, int targetValue) {
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



}
