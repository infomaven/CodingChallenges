package com.company.recursion;

/**
 * Created by nadine on 5/26/16.
 */
public class PowerFunction {

    public static void main( String[] args) {

        int base = 5;
        int power = 4;

        int result = power( base, power );
        System.out.println( "Power of base: " + base + " with Exponent: " + power + " = " + result  );
    }

    private static int power( int base, int exponent ) {
        // base case
        if (exponent == 0)
            return 1;

        int recursive = 0;
        // handle negative exponent
        if (exponent < 0) {
            int exp = exponent * -1;
            recursive = 1 / power(base, exp + 1);
            return recursive;
        }
        // handle odd exponent
        if (exponent % 2 == 1) {
            recursive = power( base, exponent - 1) * base;
            return recursive;
        }
        // handle even exponent
        if (exponent % 2 == 0) {
            recursive = power(base, exponent - 1);
            return recursive * recursive;
        }
        return 0;
    }

}
