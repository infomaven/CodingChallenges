//package com.company.datastructures;
//
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Map;
//
///**
// * Created by nadine on 5/3/16.
// * Given an array consisting of N elements, find index P where sum of values having indexes 0 < P is equal to sum
// * of elements having indexes > P && < N.length
// * Interveiw question on 20160503 (phone)
// */
//public class EquilibriumIndexTest {
//    private int[] array1;
//    private int[] array2;
//    private int[] array3;
//    private int[] array4;
//    private int[] array5;
//    private int[] array6;
//    private int[] array7;
//
//    @Before
//    public void setup() {
//
//        array1 = new int[]{1, 2, 3, 6, 5, 1};  /// index = 3
//        array2 = new int[]{1, 1, 2, 2, 3, 8, 6, 17}; /// index = 6
//        array3 = new int[]{1}; /// index = 0
//        array5 = new int[]{2, 4}; //// index = -1
//        array6 = new int[]{3, 3}; /// index = -1
//        array7 = new int[]{2, 4, 2}; /// index= 1
//        array4 = new int[]{}; //// index = -1
//    }
//
//    @Test
//   public void TestArray1(){
//        int result = EquilibriumIndex.findEquilibriumIndex( array3);
//        System.out.println( "Equilibrium index = " + result );
//    }
//
//    @Test
//    public  void TestArray2() {
//
//    }
//
//
//
//}
