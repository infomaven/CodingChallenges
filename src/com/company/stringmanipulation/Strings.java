package com.company.stringmanipulation;

import java.util.ArrayList;

/**
 * Created by nadine on 4/2/16.
 */
public class Strings {

    /**
     * Leverages properties of the Java7 String class. There are built-in methods for indexOf and lastIndexOf
     * A String can be iterated like char [ ] without having to explicitly convert it to such
     */
    public static void FirstNonDupeSinglePass() {

        //String S = "a, b, c, d, b, b, a,b, 7, 8, 8, r, r, r, w, ,c";
        // String S = "abracadabra";
        //String S = "";
        String S = "how to fixXx foggy Headlights w";

        ArrayList<Character> nonDupes = new ArrayList<Character>();
        Character found;

        if (S.length() > 0) {
            for (int i = 0; i < S.length(); i++) {
                found = S.charAt(i);
                if (S.indexOf(found) == S.lastIndexOf(found))
                    nonDupes.add(found);
            }

            System.out.println("First NonDup Char = " + nonDupes.get(0));

        } else {
            System.out.println("Empty String");
        }
    }

    /// todo: code up more possible ways to do this



}
