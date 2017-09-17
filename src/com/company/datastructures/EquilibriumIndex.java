package com.company.datastructures;

import java.util.*;

/**
 * Created by nadine on 5/3/16.
 * Given an ARRAY consisting of N elements, find index P
 * where sum of indexes less than P = sum of indexes greater than P
 *
 * Index i is an equilibrium index if sum of elements of sub-array A[0..i-1] is equal to sum of elements of sub-arrayA[i+1..n-1]
 *
 * Interview question on 20160503 (phone)
 *
 * Discussion of algorithms >
 * http://www.techiedelight.com/find-equilibrium-index-array/
 *
 */
public class EquilibriumIndex {

    public static void naiive(int[] array ) {
        // default value returned
        int equilibrium = -1;
        int markerIndex = 0;
        int n = array.length;

        if (n > 0 ) {
            while ( markerIndex <= array.length ) {
                for (int i = 0; i < array.length; i++) {
                    int startIndex = i;
                    markerIndex = i + 1;
                    int leftSum = calculateRange(startIndex, markerIndex, array);
                    // continue to end of the array and keep calculating
                    int rightSum = calculateRange(markerIndex + 1, array.length, array);
                    if ( leftSum == rightSum )  System.out.println("Equilibrium Index found at: " + i);

                }
            }
        } else {
            System.out.println("=1");
        }
    }

    public static void linear(int A[]) {
        // n is length of the array
        int n = A.length;
        System.out.println("Input array: " + writeMyArray(A) );
        int equilibrium = -1;

        if (n > 0 )  {
            // left[i] stores sum of elements of sub-array A[0..i-1]
            int left[] = new int[n];

            left[0] = 0;

            // traverse array from left to right
            for (int i = 1; i < n; i++)
                left[i] = left[i - 1] + A[i - 1];

            // right stores sum of elements of sub-array A[i+1..n)
            int right = 0;

            // traverse array from right to left
            for (int i = n - 1; i >= 0; i--) {
                // if sum of elements of sub-array A[0..i-1] is equal to
                // the sum of elements of sub-array A[i+1..n) i.e.
                // (A[0] + A[1] + .. + A[i-1]) = (A[i+1] + A[i+2] + .. + A[n-1])

                if (left[i] == right)
                    System.out.println("Equilibrium Index found at: " + i);

                // new right = A[i] + (A[i+1] + A[i+2] + .. + A[n-1])
                right += A[i];
            }
        } else {
            System.out.println("Equilibrium Index found at: " + -1);
        }
    }

    public static void optimizedAlgo( int A[] ) {

        // n is length of the array
        int n = A.length;

        // "total" stores sum of all elements in array
        int total = 0;
        for (int i = 0; i < n; i++ ) {
            total += A[i];
        }

        // right stores sum of element to the right
        int right = 0;

        // traverse array from right to left
//        for (int i = n-1; i >= 0; i-- ) {
//            if (right == total - (A[i] + right)) System.out.println( "Equiilibrium index found: " + i);
//
//            // update
//            right += A[i];
//        }

        // compare running sum to remaining sum to find equilibrium indices
        for (int i = n-1; i >= 0; i--) {
            if (right == total - (A[i] + right)) {
                System.out.println( "Equilibrium index found: " + i);
            }
            right += A[i];

        }
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

    public static void main( String[] args ) {       
        int[] test1  = new int[] {1, 2, 3, 6, 5, 1};  /// index = 3
        int[] test2 = new int[] {1, 1, 2, 2, 3, 8, 6, 17}; /// index = 6
        int[] test3 = new int[] {1}; /// index = 0
        int[] test4 = new int[] {2,4}; //// index = -1
        int[] test5 = new int[] {3,3}; /// index = -1
        int[] test6 = new int[] {2,4,2}; /// index= 1
        int[] test7 = new int[] {}; //// index = -1
        int[] test8 = new int[] {-7, 1, 5, 2, -4, 3, 0};
        List<int[]> ts = Arrays.asList(test1, test2, test3, test4, test5, test6, test7, test8 );

        long startTime = System.nanoTime();

        for ( int[] a : ts ) {
            System.out.println( writeMyArray(a) );
//            naiive(a);
//            linear( a );
            optimizedAlgo(a);
        }

        long elapsed = System.nanoTime() - startTime;
        System.out.println( String.format("Execution time: %s", elapsed) );

    }

}
