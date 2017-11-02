package com.company.sorting;

public class Heap {

    private static int total;

    // swaps two array elements
    private static void swap( Comparable[] arr, int a, int b ) {

        Comparable tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;

    }

    // Builds a MIN heap from array elements.
    private static void heapify( Comparable[] arr, int i ) {

        int left = i * 2;
        int right = left + 1;
        int root = i;

        if ( left <= total && arr[left].compareTo( arr[root] ) > 0 )  {
            root = left;
        }
        if ( right <= total && arr[right].compareTo( arr[root] ) > 0 ) {
             root = right;
        }
        if ( root != i ) {
            swap( arr, i, root );
            heapify( arr, root );
        }
    }

    public static void sort( Comparable[] arr ) {
        total = arr.length - 1;

        // create heap from first half of the initial array
        for( int i = total / 2; i >= 0; i-- ) {
            heapify( arr, i );
        }

        /* remove an element from end of array/right side, rebuild heap and sort. Repeat until middle is reached */
        for( int i = total; i > 0; i-- ) {
            swap( arr, 0, i );
            total--;
            heapify( arr, 0 );
        }
    }

    public static void main( final String[] args ) {
        Integer[] arr = new Integer[] { 3, 2, 1, 5, 4 };

        System.out.println( java.util.Arrays.toString(arr) );
        sort( arr );
        System.out.println( java.util.Arrays.toString(arr) );

     }
}
