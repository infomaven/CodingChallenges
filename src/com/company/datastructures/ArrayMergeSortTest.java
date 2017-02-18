package com.company.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by nadine on 1/19/17.
 */
public class ArrayMergeSortTest {

    @org.junit.Test
    public void lengthOfFinalArray_equalsLengthOfBothInputs() throws Exception {
        int[] result = ArrayMergeSort.transform( ArrayMergeSort.getArrayOne(), ArrayMergeSort.getArrayTwo());

        int lengthOne = ArrayMergeSort.getArrayOne().length;
        int lengthTwo = ArrayMergeSort.getArrayTwo().length;
        assertTrue( result.length == lengthOne + lengthTwo);

    }

    @Test
    public void firstIndexValue_lessThanLastIndexValue() throws Exception {
        int[] result = ArrayMergeSort.transform( ArrayMergeSort.getArrayOne(), ArrayMergeSort.getArrayTwo());

        int firstValue = result[0];
        int lastValue = result[result.length - 1];
        assertTrue( firstValue < lastValue);

    }

}
