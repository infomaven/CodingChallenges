package com.company.sorting;
/*
https://github.com/donbeave/interview#sorting-process-1

The heart of the mergesort algorithm is the merging of two already-sorted arrays.
 Merging two sorted arrays A and B creates a third array, C, that contains all
 the elements of A and B, also arranged in sorted order.

Assume the size of the left array is k, the size of the right array is m and the size of the total array is n (=k+m).
Create a helper array with the size n
Copy the elements of the left array into the left part of the helper array. This is position 0 until k-1.
Copy the elements of the right array into the right part of the helper array. This is position k until m-1.
Create an index variable i=0; and j=k+1
Loop over the left and the right part of the array and copy always the smallest value back into the original array.
 Once i=k all values have been copied back the original array. The values of the right array are already in place.

Worst case: O(n log n)
Avg case: same
Best case: same
Space Complexity: O(n)


 */

import com.company.datastructures.ListNode;


public class MergeSortLinkedList {

    public static void print(int[] array) {

        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.println("");
    }

    public static void mergeSort(int[] array, int start, int end) {

        if (start < end) {

            int middle = (start + end) / 2;

            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);

            merge(array, start, middle, end);
        }
    }

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public static void merge(int[] array,
                             int start, int middle, int end) {

        int length = middle + 1;
        int[] copyArray = new int[length];
        System.arraycopy(array, 0, copyArray, 0, length);

        int i = start;
        int j = middle + 1;
        int k = start;

        while (i <= middle && j <= end) {
            array[k++] = (array[j] < copyArray[i])
                    ? array[j++] : copyArray[i++];
        }

        while (i <= middle) {
            array[k++] = copyArray[i++];
        }
    }

    public static void main( String[] args )
    {
        int[] numbers = new int[] {5, 7, 3, 9, 2, 10, 4, 1, 6, 8};
        System.out.println("BEFORE SORTING: ");
        print( numbers );
        mergeSort( numbers );
        System.out.println("AFTER SORTING: ");

        print( numbers );

    }

}
