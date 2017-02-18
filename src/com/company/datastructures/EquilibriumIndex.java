package com.company.datastructures;

/**
 * Created by nadine on 5/3/16.
 * Given an ARRAY consisting of N elements, find index P
 * where sum of values having indexes 0 < P is equal to sum of elements having indexes > P && < N.length
 * Interview question on 20160503 (phone)
 */
public class EquilibriumIndex {

    public static void main( String[] args ) {
        // TODO: put these into a collection so we can run through all the test cases
        int[] array1  = new int[] {1, 2, 3, 6, 5, 1};  /// index = 3
        int[] array2 = new int[] {1, 1, 2, 2, 3, 8, 6, 17}; /// index = 6
        int[] array3 = new int[] {1}; /// index = 0
        int[] array5 = new int[] {2,4}; //// index = -1
        int[] array6 = new int[] {3,3}; /// index = -1
        int[] array7 = new int[] {2,4,2}; /// index= 1
        int[] array4 = new int[] {}; //// index = -1


        int result = findEquilibriumIndex( array3 );
        System.out.print("Equilibrium for {"+ writeMyArray(array3) +"}= ");
        System.out.print( findEquilibriumIndex(array3));
        // TODO: genericize the previous three lines of code


    }

    private static int findEquilibriumIndex( int[] array ) {
        // default value returned
        int equilibrium = -1;
        int markerIndex = 0;
        while ( markerIndex <= array.length ) {
            for (int i = 0; i < array.length; i++) {
                int startIndex = i;
                 markerIndex = i + 1;
                int leftSum = calculateRange(startIndex, markerIndex, array);
                // continue to end of the array and keep calculating
                int rightSum = calculateRange(markerIndex + 1, array.length, array);

                return equilibrium;
            }
        }
        return equilibrium;
    }

    private static int calculateRange(int start, int stopIndex, int[] inputArray) {
        int sum = 0;
        for ( int i =start; i < stopIndex - start; i++ ) {
//            sum = inputArray[ start ] + inputArray[ start + 1 ];
            sum += inputArray[i];
        }
        return sum;
    }

    private static String writeMyArray(int[] myArray) {
        String result = "";
        for (int i =0; i < myArray.length; i++) {
            result = result + String.valueOf(myArray[i]);
        }

        return result;
    }

}
