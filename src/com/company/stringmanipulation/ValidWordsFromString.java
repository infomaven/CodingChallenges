package com.company.stringmanipulation;

import java.util.*;

public class ValidWordsFromString {

    private static final Set<String> dictionary = new TreeSet<String>();
    static {
        dictionary.add("this");
    }

    private ValidWordsFromString() {}

    /**
     * Returns set of valid words given an input string. (no duplicates)
     */
    public static Set<String> findValidStrings( String str ) {
        if (str.length() == 0) {
            throw new IllegalArgumentException( "Strings of length 0 are illegal");
        }
        final Set<String> validWords = new HashSet<String>();
        for (int i = 0; i < str.length(); i++ ) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                sb.append( str.charAt(j));
                if (dictionary.contains( sb.toString())) {
                    validWords.add( sb.toString());
                }
            }
        }
        return validWords;
    }



    public static void main( String[] args ) {
        Set<String> expected = new HashSet<String>( Arrays.asList("awe", "is", "his", "awesome", "some", "this", "we"));
        System.out.println( expected );

        if( expected.equals(ValidWordsFromString.findValidStrings("thisisawesome"))) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
