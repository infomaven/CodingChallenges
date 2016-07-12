package com.company.recursion;

import java.util.Scanner;

/**
 * Created by nadine on 5/26/16.
 */
public class Palindrone {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println( "Type in a word to check as Palindrone > ");
        String next = sc.nextLine();
        if (isPal( next ))
            System.out.println( next + " is a palindrone");
        else
            System.out.println( next + " is NOT a palindrone");

    }



    public static boolean isPal( String s ) {
        // base case
        if (s.length() == 0 || s.length() ==1 ) {
            return true;
        }
        // recursion with an update that brings it closer to the base case
        if (s.charAt(0) == s.charAt( s.length() - 1))
            return isPal( s.substring(1, s.length() - 1));
        // case not found (quick exit)
        return false;
    }
}
