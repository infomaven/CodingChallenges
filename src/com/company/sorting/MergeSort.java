package com.company.sorting;

/**
 * Created by nadine on 6/1/16.
 * Merge function runs in O(n) time when merging n elements
 * Divide-and-Conquer. Uses more memory.
 * Real work is done during combine step
 *
 * Worst case: O(n log n)
 Avg case: same
 Best case: same
 Space Complexity: O(n)
 */
public class MergeSort {

    private int[] array;
    private int[] tempArray;
    private int length;

    public static void print(int[] array) {

        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println("");
    }

    public void sort(int[] inputArr) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempArray = new int[ length ];
        splitAndOrder(0, length - 1);

    }

    public void splitAndOrder(int lowIndex, int highIndex) {
        if (lowIndex < highIndex ){
            int middle = lowIndex + (highIndex - lowIndex) / 2;
            // sort left side of array
            splitAndOrder( lowIndex,middle );
            // sort right side of array
            splitAndOrder( middle + 1, highIndex);
            // merge both sides
            combineLeftAndRight( lowIndex, middle, highIndex );
        }
    }

    public void combineLeftAndRight(int lowIndex, int middle, int highIndex ) {
        for (int i = lowIndex; i <= highIndex; i++) {
            tempArray[i] = array[i];
        }
        int i = lowIndex;
        int j = middle + 1;
        int k = lowIndex;       //todo: verify this is really 'lowIndex' and not 'highIndex'
        while (i <= middle && j <= highIndex) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while ( i <= middle ) {
            array[k] = tempArray[i];
            k++;
            i++;
        }
    }

    public static void main( String[] args) {

        System.out.println("MergeSort\n");
        int [] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        System.out.println("BEFORE> ");
        print(inputArr);

        MergeSort ms = new MergeSort();
        ms.sort( inputArr);

        System.out.println("\n\nAFTER> ");
        print(inputArr);
    }
}
