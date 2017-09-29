package com.company.bitwise;


import java.util.Scanner;

/*
Collection of Java bitwise operators
 */
public class BitwiseOperators {

    private static Scanner sc;


    public static void main( String[] args ) {

        int a, b;
        sc = new Scanner( System.in );
        System.out.println( "Please enter two integer values: ");
        a = sc.nextInt();
        b = sc.nextInt();

        System.out.format("AND: %d & %d = %d\n", a, b, a & b);
        System.out.format("OR: %d | %d = %d\n", a, b, a | b );
        System.out.format("EOR: %d ^ %d = %d\n", a, b, a ^ b );
        System.out.format("NOT: ~%d = %d\n", a, ~a);

        System.out.format("LEFT SHIFT: %d << 1 = %d\n", a, a << 1 );
        System.out.format("RIGHT SHIFT: %d >> 1 = %d\n", a, a >> 1 );

    }

}
