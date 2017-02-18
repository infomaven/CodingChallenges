package com.company;

import com.company.fileparsing.ReadWithScanner;

public class Main {
    public static void main(String[] args) throws Exception {
//// transform sorting algorithm
        // Strings.FirstNonDupeSinglePass();
        //Sorting.minSort();
       // int result = TimeComplexity.frogJump3(10, 85, 30);
       // System.out.println(result);

///// transform the Trie
//        PrefixTree.TrieNode tree = PrefixTree.createTree();
//
//        String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};
//        for (int i = 0; i < words.length; i++)
//            insertWord(tree, words[i]);
//
//        char[] branch = new char[50];
//        printTree(tree, 0, branch);
//
//        String searchWord = "all";
//        if ( PrefixTree.find(tree, searchWord)) {
//            System.out.println("The word was found");
//        } else {
//            System.out.println("The word was NOT found");
//        }

//// transform Log scanner
        ReadWithScanner rs = new ReadWithScanner( "testlog.txt");
        rs.processAndPrint();


    }
}



