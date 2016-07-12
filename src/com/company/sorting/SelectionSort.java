package com.company.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by nadine on 5/23/16.
 * This algo changes relative order of elements that have equal keys. This makes it "Unstable"
 * Worst case  = O(n^2)
 * Best for small number of elements (< 1000), or if aux memory is limited
 * Divides input list into two parts - sublist of sorted items & sublist of unsorted items.
 * Iterates through the unsorted portion of list to find smallest value which is placed into the sorted list.
 * Each time a min value is found, it gets moved from unsorted subList to far right of the sorted subList
 * This causes start index of the unsorted list to increment while the end index stays steady.
* https://en.wikipedia.org/wiki/Selection_sort
 **/
public class SelectionSort {

    private static void swap( int[] a, int i , int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * Nested loops cause this algo to have O(^2) running time
     * @param list
     * @return
     */
public static int[] selectionSort( int[] list) {

    for (int i = 0; i < list.length - 1; i++) {
        // find index of the min value
        int minPos = i;
        for (int j = i + 1; j < list.length; j++) {
            if (list[j] < list[minPos]) {
                minPos = j;
            }
        }
        swap( list, minPos, i);
    }
    return list;
}

    public static void main(String args[]) throws Exception {
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
            System.out.println( elementList[j] + " ");
        }
        elementList = selectionSort( elementList );
        System.out.println("\n\n\n");
        System.out.println( "After... ");
        for (int j = 0; j < elementList.length; j++) {
            System.out.println( elementList[j] + " ");
        }
    }
}
