package com.company.stringmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by nadine on 4/2/16.
 */
public class UniqueAbbreviation {

    // dictionary object passed in from main()
    static List<String> dict;
    // track any duplicate abbreviations discovered during initialization of the dictionary
    static List<String> dups = new ArrayList<String>();
    // lookup for distionary abbreviations
    static Hashtable<String,String> abbrevs = new Hashtable<String,String>();

    UniqueAbbreviation(List<String> dict) {

        this.dict = dict;
    }

    public void init(List<String> dict) {

        for (int i = 0; i < dict.size(); i++) {
            String S = dict.get(i);
            if (S.length() == 0 || S.length() == 1  || S.length() == 2 ) {
                continue;
            } else {

                String abbrev = abbreviate( S );
                if (abbrevs.containsKey( (String) abbrev )) {
                   // final boolean add = dups.add(abbrev);// identify as a duplicate abbreviation
                    dups.add( abbrev);
                    abbrevs.put( abbrev, S); // replace existing key value with the duplicate

                } else {
                    abbrevs.put(abbrev, S);
                }
            }
        }
    }

     protected static String abbreviate(String originalWord) {
        String S = originalWord;
        Character first, last;
        String middle;
        String middleSize;
//        if (S.length() == 0 || S.length() == 1  || S.length() == 2 ) {
//            return;
//        }
        if (S.length() == 3) {
            first = S.charAt(0);
            middle = String.valueOf(S.charAt(1));
            middleSize = String.valueOf(middle.length());
            last = S.charAt(2);
        // optimal cases are words 4+ chars long
        } else {
            first = S.charAt(0);
            middle = S.substring(1, S.length() - 1);
            middleSize = String.valueOf(middle.length());
            last = S.charAt(S.length() - 1);
        }

        String abbrev = first + middleSize + last;

//        if ( abbrevs.contains( abbrev ) ) {
//            dups.add( abbrev);  // mark key as a dup
//            abbrevs.put( abbrev, S); // HT will remove extra entry to maintain unique keySet
//
//        } else {
//            abbrevs.put(abbrev, S);
//        }
         return abbrev;
    }

    /**
     * Leverages properties of the Java7 String class. There are built-in methods for indexOf and lastIndexOf
     * A String can be iterated like char [ ] without having to explicitly convert it to such
     */
    public static void main(String[] args) {
        /* Given an existing dictionary (List) of Strings, determine if a test String has an abbreviation that
         does not already exist in the List
         ex.
         {cow, pig, goat, dog, dig}
         dog - non-unique
        pig - unique
        dog - non-unique; it's abbreviation is same as that for *dig*
        Suzanna - unique no other word abbreviates to s5a
        at - at
        scope: do not abbreviate words of length 0, 1 or 2...there is no point
        unique = no other word in the dictionary has the same abbreviation.
        */
        // TODO: change testWord as desired when running this code
        List myList = Arrays.asList("cow", "pig", "goat", "ok", "r", "" ,"dog", "dig", "llama", "aardvark");
        // TODO: change testWord as desired when running this code
        String testWord = "dig";

        UniqueAbbreviation runner = new UniqueAbbreviation(myList);
        runner.init( myList );
        boolean result = isUnique(testWord);
        System.out.println("Testword - " + testWord + " is unique: " + result);

    }

    private static boolean isUnique(String testWord) {
        String testWordAbbrev = abbreviate( testWord);
        System.out.println( dups.toString() );
        return ( !dups.contains(testWordAbbrev ));

    }


}


