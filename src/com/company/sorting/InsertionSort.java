package com.company.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by nadine on 5/24/16.
 * Simple sorting algo
 * Builds final sorted array one item at a time. Less efficient for large n. Worst run time = O(n^2)
 * Does not change relative order of elements having equal keys -> "stable"
 * Uses in-place memory.
 * Can sort a list as it receives it -> "Online"
 */
public class InsertionSort {
    private static int[] descInsertionSort(int[] array) {
        int j;
        int key;
        int i;
/// start with 1 instead of 0
        for (j = 1; j < array.length; j++) {
            key = array[j];
            for ( i = j - 1; (i >= 0 ) && (array[i] < key); i--) {
                array[i + 1] = array[i];
            }
            array[i + 1] = key;
        }

        return array;
    }

    private static int[] ascInsertionSort( int[] array) {
        int n = array.length;
        int temp;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) throws Exception {
        int[] array1 = setupArray();
        System.out.println("Descending order\n");
        array1 = descInsertionSort(array1);
        printSortedArray(array1);
        System.out.println("\n");
        System.out.println("**********\n");
        int[] array2 = setupArray();
        System.out.println("Ascending order\n");
        array2 = ascInsertionSort(array2);
        printSortedArray(array2);

    }

    private static void printSortedArray(int[] elementList) {
        System.out.println("\n");
        System.out.println( "Afterwards....");
        for (int j =0; j < elementList.length; j++) {
            System.out.print( elementList[j] + " ");
        }
    }

    private static int[] setupArray() throws IOException {
        String list = "";
        int i = 0, n = 0;

        ArrayList<Integer> arrList = new ArrayList<Integer>();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println( "Please enter list of elements that will be sorted with one element per line");
        System.out.println( "enter 'stop' for final element");
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        /// read console content into ArrayList of Integers
        while (!(list = bf.readLine()).equalsIgnoreCase("stop")) {
            int intElement = Integer.parseInt( list );
            arrList.add( intElement);
        }
        /// create array of Integers for easiier manipulation by the sorting algorithm
        int elementList[] = new int[ arrList.size()];
        Iterator<Integer> iter = arrList.iterator();
        for (int j = 0; iter.hasNext(); j++) {
            elementList[j] = iter.next();
        }
        System.out.println( "Before.... ");
        for (int j = 0; j < elementList.length; j++) {
            System.out.print( elementList[j] + " ");
        }
        return elementList;
    }
}
