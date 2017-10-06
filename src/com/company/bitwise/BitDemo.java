package com.company.bitwise;

public class BitDemo {

    public static void main( String[] args ) {
        int bitmask = 0x000F;
        int val = 0x2222;
        // expected: 2
        System.out.println( val & bitmask );
    }
}
