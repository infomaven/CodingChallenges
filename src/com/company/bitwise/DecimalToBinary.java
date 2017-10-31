package com.company.bitwise;
/*
Takes in a decimal number and returns the binary representation

 */
public class DecimalToBinary {

    // Uses bitwise & shift operation to inspect each bit of the integer value and convert it to string representation
    public static String toBinIterative( int decimal ) {
        StringBuilder sb = new StringBuilder();
        if (decimal == 0) {
            return "0";
        } else {
            while( decimal > 0 ) {
                sb.append( decimal & 1 );
                decimal >>= 1;

            }
        }
        // use reverse() to represent least significant digit at right-most position
        return sb.reverse().toString();
    }

    // Uses division and modulus to recursively build a string representation
    public static String toBinRecursive( int decimal ) {
        return (decimal > 0)? toBinRecursive( decimal / 2 ) + (decimal % 2 ): "";

    }
}
