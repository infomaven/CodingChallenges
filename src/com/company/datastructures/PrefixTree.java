package com.company.datastructures;

/**
 * Created by nadine on 4/10/16.
 */
public class PrefixTree {

     public static TrieNode createTree() {
         TrieNode newTree = new TrieNode( '\0', false);
        return newTree;
    }

    public static void insertWord( TrieNode root, String word) {
        int offset = 97;
        int len = word.length();
        char[] letters = word.toCharArray();
        TrieNode currentNode = root;

        for (int i = 0; i < 1; i++) {

        }
    }

    TrieNode rootNode;
    TrieNode currentNode;

    char currentLetter;

    public void insert(char newLetter, boolean isFullWord) {
        TrieNode currentNode;
        char currentLetter;
        /*
        1) set currentNode = root (empty)
        2) set currentLetter = first letter of searchWord (ex. "Postman")
        3) if currentNode contains link to currentLetter, update currentNode to match search node
        else create new node, set currentLetter = currentLetter and set currentNode = new node
        repeat step 3) until all letters of searchWord have been processed
         */
    }

    /**
     *
     1) set currentNode = root. Set currentLetter = first letter of searchWord
     2) if currentNode == null, word doesn't exist
     3) if currentNode has link containing currentLetter, set currentNode = referenced node, set currentLetter = letter of new node
     4) repeat steps 2 & 3 until all letters have been processed
     5) note: Now there are two possibilities that may indicate the letter is not there in the tree:
     a) the current letter is the last letter and there is no valid node containing this letter,
     and b) there is a valid node containing the last letter but the node does not indicate it
     contains a full word (marked with the "isFullWord" boolean field.
     6) if conditions of 5) are not met, then we have a match for search word in the Trie
    * @param root
     * @param searchWord
     * @return
     */
    public static boolean  find(TrieNode root, String searchWord) {
        char[] searchLetters = searchWord.toCharArray();
        int searchLength = searchLetters.length;
        int offset = 97; //// not sure what this magic number represents.....
        TrieNode currentNode = root;

        int i;
        
        /// todo: come up with explanation of what the code is really doing here
        for (i = 0; i < searchLength; i++) {
            //// exit early if root is not populated
           // REFACTOR: TRYING OUT YODA STYLE IF-STATEMENTS   :)    if (currentNode == null) {
                if (null == currentNode ) {

                    return false;
                }
            }
                currentNode = currentNode.links[ searchLetters[i] - offset];

        //// exit if you're at end of the search term
        // RAFACTOR: TRYING OUT YODA STYLE IF-STATEMENTS   :)    if (currentNode == null) {
//        if (i == searchLength && currentNode == null )
         if (searchLength == i   && null == currentNode ) {
            return false;
        }

        if (null != currentNode && !currentNode.isFullWord ) {
            return false;
        }

        return true;
    }


    public static void printTree( TrieNode root, int level, char[] branch) {
        if (root == null) {
            return;
        }
        for (int i=0; i < root.links.length; i++ ) {
            branch[ level ] = root.letter;
            printTree( root.links[i], level + 1, branch);

        }
        if (root.isFullWord ) {
            for (int j = 1; j <= level; j++ ) {
                System.out.print( branch[j]);
                System.out.println();
            }
        }
    }

    public static class TrieNode {
        char letter;
        TrieNode[] links;
        boolean isFullWord;

        TrieNode(char letter, boolean isFullWord) {
            this.letter = letter;
            this.isFullWord = isFullWord;
            links = new TrieNode[26];

        }



    }
}
