package com.company.sorting;

/**
 * Created by nadine on 6/1/16.
 * Merge function runs in O(n) time when merging n elements
 * Divide-and-Conquer. Uses more memory.
 * Real work is done during combine step
 */
public class MergeSort {

    private int[] array;
    private int[] tempArray;
    private int length;

    public static void main( String[] args) {

        int [] inputArr = {45, 23, 11, 89, 77, 98, 4, 28, 65, 43};
        System.out.println("BEFORE> ");
        for (int i : inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }

        MergeSort ms = new MergeSort();
        ms.sort( inputArr);

        System.out.println("\n\nAFTER> ");
        for (int i : inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    private void sort(int[] inputArr) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempArray = new int[ length ];
        startMerge(0, length - 1);

    }

    private void startMerge( int lowIndex, int highIndex) {
        if (lowIndex < highIndex ){
            int middle = lowIndex + (highIndex - lowIndex) / 2;
            // sort left side of array
            startMerge( lowIndex,middle );
            // sort right side of array
            startMerge( middle + 1, highIndex);
            // merge both sides
            mergeParts( lowIndex, middle, highIndex );
        }
    }

    private void mergeParts( int lowIndex, int middle, int highIndex ) {
        for (int i = lowIndex; i <= highIndex; i++) {
            tempArray[i] = array[i];
        }
        int i = lowIndex;
        int j = middle + 1;
        int k = lowIndex;
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
}
