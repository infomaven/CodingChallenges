package com.company.sorting;

/**
 * Created by nadine on 6/1/16.
 * Divide and conquer
 * Worst case is O(n^2), but avg-case running time is optimal (O(n lg n)).
 * Over time, this makes it out-perform merge sort, selection and insertion sort
 * Real work happens during divide step. Low memory consumption becuase all manipulations are done "in place"
 */
public class QuickSort {
    public static void main( String arg[] ) {

        QuickSort myQuick = new QuickSort();
        int[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        myQuick.quickSort( input );
        for (int i : input ) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    private int array[];
    private int length;

    public void quickSort( int[] inputArray ) {
        // base case
        if (inputArray == null || inputArray.length == 0) {
            return;
        }
        this.array   = inputArray;
        length  = inputArray.length;
        // natural recursion
        quickSort( 0, length - 1);
    }

    private void quickSort( int lowIndex, int highIndex ) {

        int i = lowIndex;
        int j = highIndex;
        // calculate index for the pivot value (this can be tweaked to optimize execution performance)
        int pivot = array[ lowIndex + (highIndex - lowIndex)/2 ];
        // split into two arrays
        while (i <= j) {
            // In each iteration, look on left side for numbers that are > pivot. If found, move it to right side
            // Look for numbers on right side that are < pivot. If found, move it to left side.
            // Once search finishes, exchange both numbers
            while ( array[i] < pivot ) {
                i++;
            }
            while ( array[j] > pivot ) {
                j--;
            }
            if( i <= j) {
                exchangeNumbers(i, j);
                // move index to next position on both sides
                i++;
                j++;
            }
        }
        // call quickSort recursively
        if (lowIndex < j)
            quickSort( lowIndex, j);
        if (i < highIndex)
            quickSort(i, highIndex);
    }

    private void exchangeNumbers( int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
