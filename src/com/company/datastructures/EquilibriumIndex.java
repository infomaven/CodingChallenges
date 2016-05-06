package com.company.datastructures;

/**
 * Created by nadine on 5/3/16.
 * Given an array consisting of N elements, find index P where sum of values having indexes 0 < P is equal to sum
 * of elements having indexes > P && < N.length
 * Interveiw question on 20160503 (phone)
 */
public class EquilibriumIndex {

    public static void main( String[] args ) {
        int[] array1  = new int[] {1, 2, 3, 6, 5, 1};  /// index = 3
        int[] array2 = new int[] {1, 1, 2, 2, 3, 8, 6, 17}; /// index = 6
        int[] array3 = new int[] {1}; /// index = 0
        int[] array5 = new int[] {2,4}; //// index = -1
        int[] array6 = new int[] {3,3}; /// index = -1
        int[] array7 = new int[] {2,4,2}; /// index= 1
        int[] array4 = new int[] {}; //// index = -1

        int result = findEquilibriumIndex( array3 );
        System.out.println( "Equilibrium index = " + result );
    }

    public static int findEquilibriumIndex( int[] array ) {
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

    protected static int calculateRange(int start, int stopIndex, int[] inputArray) {
        int sum = 0;
        for ( int i =start; i < stopIndex - start; i++ ) {
//            sum = inputArray[ start ] + inputArray[ start + 1 ];
            sum += inputArray[i];
        }
        return sum;
    }

}
