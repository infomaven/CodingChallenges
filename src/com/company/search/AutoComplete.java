package com.company.search;

/*
Title: Automcomplete
Purpose: Class that returns all dictionary words that match a given prefix

Usage: javac Autocomplete.java && java Autocomplete

 */

import java.util.*;


public class AutoComplete {

    // Trie (a type of tree structure)  is especially well suited for finding matches with chars. It stores one letter per Node
    private class Node {
        String prefix;
        HashMap<Character, Node>children;

        // flag to mark last character of a word in the trie
        boolean isWord;

        private Node( String pfix ) {
            this.prefix = pfix;
            this.children = new HashMap<Character, Node>();
        }
    }

    // the trie
    private Node trie;

    // construct trie from input dictionary
    public AutoComplete( String[] dict ) {
        trie = new Node("");
        for ( String s : dict ) {
            insertWord(s);
        }

    }


    /*
  Purpose: inserts individual chars from each string into the trie
   */
    private void insertWord(String s) {
        // create base Node
        Node curr = trie;

        for (int i = 0; i < s.length(); i++ ) {
            if (!curr.children.containsKey(s.charAt(i))) {
                curr.children.put( s.charAt(i), new Node( s.substring(0, i + 1)) );
            }
            curr = curr.children.get( s.charAt(i));
            // set flag when you reach final index of the string
            if ( i == s.length() - 1 ) {
                curr.isWord = true;
            }
        }

    }

    /*
    Purpose: find child words under a given prefix
     */
    private void findAllChildWords(Node curr, List<String> results) {

        if (curr.isWord) {
            results.add(curr.prefix );
            for ( Character c : curr.children.keySet()) {
                findAllChildWords( curr.children.get(c), results);
            }
        }
    }

    /*
    Purpose: compare content of 2 given Array structures
    todo: write a method that can compare LinkedLists, since that is the actual data type we are handling in this program

     */
    private static boolean compareArrays( String[] s1, String[] s2 ) {
        // exit early if the arrays are obviously not the same
        if (s1.length != s2.length ) return false;
        Arrays.sort( s1 );
        Arrays.sort( s2 );

        for  (int i = 0; i < s1.length; i++) {
            if (!s1[i].equals( s2[i]) ) return false;
        }

        return true;
    }



    /*
 Purpose; find all words that start with a given prefix
 @input: value of the prefix
 @output: List of Words that start with that prefix
  */
    public List<String> getWordsForPrefix( String pre ) {

        List<String> results = new LinkedList<>();
        Node curr = trie;
        for  (char c : pre.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return results;
            }
        }
        // find child words recursively
        findAllChildWords( curr, results);
        return results;
    }


    //================================================================

    /*
    Time for some exercise!
     */
    public static void main( String[] args ) {

        AutoComplete a = new AutoComplete(new String[]{"abc", "acd", "bcd", "def", "a", "aba"});

        assert compareArrays((String[])a.getWordsForPrefix("").toArray(new String[6]),
                new String[]{"abc", "acd", "bcd", "def", "a", "aba"}):
                "Empty string";
        assert compareArrays((String[])a.getWordsForPrefix("a").toArray(new String[4]),
                new String[]{"abc", "acd", "a", "aba"}):
                "Single character prefix";
        assert compareArrays((String[])a.getWordsForPrefix("def").toArray(new String[1]),
                new String[]{"def"}):
                "Prefix the length of the string";
        assert compareArrays((String[])a.getWordsForPrefix("abcd").toArray(new String[0]),
                new String[]{}):
                "No results";
        System.out.println("Passed all test cases");

        // alternate test cases
        System.out.println("Starting set 2 of tests   :)\n\n ");
        List<String> expected1 = new LinkedList<>( Arrays.asList(""));
        List<String> actual1 = a.getWordsForPrefix("");
        assert expected1.equals(actual1);

        List<String> expected2 = new LinkedList<>( Arrays.asList("abc", "acd", "a", "aba", "foo"));
        System.out.println("size expected: " + expected2.size());
        List<String> actual2 = a.getWordsForPrefix("a");
        System.out.println("size actual: " + actual2.size());
        assert actual2.equals(expected2);

        List<String> expected3 = new LinkedList<>( Arrays.asList( "def" )) ;
        List<String> actual3 = a.getWordsForPrefix("def");
        assert expected3.equals( actual3 );

        List<String> expected4 = Collections.EMPTY_LIST;
        List<String> actual4 = a.getWordsForPrefix("abcd");
        assert expected4.equals( actual4);
        }

    }


