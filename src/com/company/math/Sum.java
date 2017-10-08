package com.company.math;

public class Sum {


    protected static int sumOddMembers(int[] arr) {

        int sum = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if ((arr[i] % 2 == 1) || (arr[i] % 2 == -1)) {
                sum += arr[i];
            }

        }

        return sum;
    }


    public static void main(String[] args) {
        int[] arr = {18, -71, 65, 24, -33};     // expected = -71 + 65 -33 -> -39
        int[] arr2 = { 2, 3, 6, 7 };        // expected = 3 + 7 -> 10

        int result = 0;
        result = sumOddMembers( arr);
        assert( result == -39 );
        System.out.println( result );

        result = sumOddMembers( arr2);
        assert( result == 10);
        System.out.println( result );

    }

}
