package com.company.sorting;


/**
 * Created by nadine on 4/7/16.
 */
public class Sorting {
    public static void minSort() {
       // int[] A = {1,2,4,9,8,7,5,3};
       // int[] A = {10, 9,8,7,6,4,3,2,1};
       // int[] A = {10,7,9,5,7,3,2,1};
        int[] A = {100,105,100,100,90,4,5};
        for ( int i=0; i<A.length; i++ )
            for (int j=i+1; j<A.length; j++ )
                if (A[i] < A[j]) {
                    swap();
                }

    }

    private static void swap() {
        System.out.println("L < R");
    }
}
