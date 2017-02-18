package com.company.datastructures;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by nadine on 1/5/17.
 */
public class ArrayInReverse {
    private int[] myArray;

    public static void main( String[] args ) {
        System.out.println( "Creating an array of ints...");
        Random rand = new Random();
        int[] inputArray = new int[5];
        for (int i=0; i<5; i++) {
            inputArray[i] = rand.nextInt();
        }
        ArrayInReverse test = new ArrayInReverse(inputArray);

        System.out.println("Array contains: " + Arrays.toString(inputArray));
        test.reverse(inputArray);
        System.out.println("After reversal, array contains: " + Arrays.toString(inputArray));

    }

    private ArrayInReverse(int[] input) {
        this.myArray = input;
    }

    private void reverse( int[] array ) {
        for (int i=0; i<array.length/2; i++ ) {
            int other = array.length-i-1; // capture element on far right side
            int temp = array[i];   // capture current value at index
            array[i] = array[other];  // exchange current index value for value from far right
            array[other] = temp; // exchange far right value for current value
        }
        this.myArray = array;
    }



}
