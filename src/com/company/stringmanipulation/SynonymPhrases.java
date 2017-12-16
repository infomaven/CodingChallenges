package com.company.stringmanipulation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class SynonymPhrases {

    private static ArrayList<Collection> dict = initialize();

    private static ArrayList<Collection>  initialize() {

        ArrayList<String> list1 = new ArrayList<String>(
                Arrays.asList( "having a wonderful time", "hawt", "liking it", "w00t")
        );


        ArrayList<String> list2 = new ArrayList<String>(
                Arrays.asList( "film review", "movie report", "New York Times review")
        );


        ArrayList<String> list3  =  new ArrayList<String>(
                Arrays.asList( "documentary film", "nonfiction movie", "biopic", "political message film")
        );

        ArrayList<Collection> dict = new ArrayList<Collection>(
                Arrays.asList( list1, list2, list3 ));


        return dict;
    }

    public static void printDictionary() {
        System.out.println(dict);
    }


    public static boolean findSynonyms( String phrase1, String phrase2 ) {

        System.out.format("%s // %s\n ", phrase1, phrase2);
        return( found(phrase1) && found(phrase2) );

    }

    private static String encode256(String phrase) {

        MessageDigest messageDigest = null;
        try {
             messageDigest = MessageDigest.getInstance( "SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update( phrase.getBytes());
        return new String(messageDigest.digest());
    }


    /*
    synonym dictionary should be an array of ArrayLists
    ex.
    [ ("first search phrase", "second phrase", "third"), ("more stuff", "multiple words are supported as well", "even longer")]

     */

    private static boolean found(String searchTerm) {

        boolean result = false;
        for( Collection list : dict ) {
            if (result = list.contains( searchTerm)) break;
        }

        return result;
    }


    public static void main( String[] args ) {

        String str1 = "film review";
        String str2 = "not in our dictionary";
        String str3 = "movie report";
        String str4 = "documentary film";
        System.out.println("Known synonyms: ");
        printDictionary();

        boolean test1_expectingTRUE = findSynonyms( str1, str3 );
        System.out.println(test1_expectingTRUE );

        boolean test2_expectingFALSE =  findSynonyms( str2, str4 );
        System.out.println( test2_expectingFALSE );

    }


}
