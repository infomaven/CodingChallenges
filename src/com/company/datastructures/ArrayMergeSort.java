package com.company.datastructures;

import java.util.Arrays;

/**
 * Created by nadine on 1/5/17.
 * Merges two sorted Arrays into a third that has the same sort order. Duplicates are OK
 */
public class ArrayMergeSort {
    private static int[] arrayOne = {1,5,7,12,15,16,18};  // 7 elements
    private static int[] arrayTwo = {13,15,17,20,22};       // 5 elements
    // desired result => {1,5,7,12,13, 15, 15,16,17,18,20,22}  // 12 elements.
    private static int[] result = new int[getArrayOne().length + getArrayTwo().length];

    public static void main( String[] args ) {

        System.out.println("First array: " + Arrays.toString(getArrayOne()));
        System.out.println("Second array: " + Arrays.toString(getArrayTwo()));
        result = ArrayMergeSort.transform(getArrayOne(), getArrayTwo());
        System.out.println("After merge, array contains: " + Arrays.toString(result));

    }


    public static int[] transform(int[] first, int[] second ) {
        int L1 = first.length;
        int L2 = second.length;
        int [] result = new int[ L1 + L2];
        int secondStartIndex = L1;

        for (int i = 0; i < L1; i++) {
            result[i] = first[i];
        }

        for (int i =secondStartIndex; i < L2; i++) {
            result[i] = second[i];
        }

        // sort the result array using built-in Java method
        Arrays.sort(result);

        return result;

    }

    public static int[] getArrayOne() {
        return arrayOne;
    }

    public static void setArrayOne(int[] arrayOne) {
        ArrayMergeSort.arrayOne = arrayOne;
    }

    public static int[] getArrayTwo() {
        return arrayTwo;
    }

    public static void setArrayTwo(int[] arrayTwo) {
        ArrayMergeSort.arrayTwo = arrayTwo;
    }
}

/*
discussion of solution tradeoffs: http://softwareengineering.stackexchange.com/questions/267406/algorithm-to-merge-two-sorted-arrays-with-minimum-number-of-comparisons
- merge sort algorithm is the best general approach. It will require n + m - 1 comparisons, where one array is size n and the other is size m

a better solution: http://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
// size of C array must be equal or greater than sum of A and B arrays' sizes
// set the loop condition to equal sum of the two input arrays

public void merge(int A[], int m, int B[], int n) {
	int i = m - 1;
	int j = n - 1;
	int k = m + n - 1;

	while (k >= 0) {
		if (j < 0 || (i >= 0 && A[i] > B[j]))
			A[k--] = A[i--];
		else
			A[k--] = B[j--];
	}
}


 */
