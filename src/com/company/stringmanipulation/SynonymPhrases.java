package com.company.stringmanipulation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class SynonymPhrases {

    private static ArrayList<Collection> dict = initialize();

    private static ArrayList<Collection>  initialize() {

        ArrayList<String> list1 = new ArrayList<String>(
                Arrays.asList( encode256("having a wonderful time"), encode256("hawt"), encode256("liking it"), encode256("w00t")));
        ArrayList<String> list2 = new ArrayList<String>(
                Arrays.asList( encode256("film review"), encode256("movie report"), encode256("New York Times review")));
        ArrayList<String> list3  =  new ArrayList<String>(
                Arrays.asList( encode256("documentary film"), encode256("nonfiction movie"), encode256("biopic"), encode256("political message film")));

        ArrayList<Collection> dict = new ArrayList<Collection>(
                Arrays.asList( list1, list2, list3 ));

        return dict;
    }


    public static boolean findSynonyms( String phrase1, String phrase2 ) {

        String term1 = encode256( phrase1);
        String term2  = encode256( phrase2 );

        return ( found(term1) && found(term2) );

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

        boolean test1_expectingTRUE = findSynonyms( str1, str3 );
        System.out.println(test1_expectingTRUE );

        boolean test2_expectingFALSE =  findSynonyms( str2, str4 );
        System.out.println( test2_expectingFALSE );

    }


}
