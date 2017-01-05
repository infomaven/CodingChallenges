package com.company.datastructures;

import java.util.Stack;

/**
 * Created by nadine on 5/24/16.
 * Takes in an array of Strings from the command line
 * Starting with index 0, first element added will be the first returned (FIFO)
 * Internally we use a Stack to receive the individual args. Then we pop these elements out and immedidately push them
 * onto a second Stack. THis effectively reverses the order (elements
 */
public class Queue_Using2Stacks {

    /**
     *
     * @param arg String text  (ex. superfly, come, home)
     * @return Words in same order, but now as a String
     */
        public static String myFunction(String arg) {
            // write the body of your function here
            String[] argList = arg.split(",");
            Stack stack1 = new Stack();
            Stack stack2 = new Stack();
            StringBuilder sb = new StringBuilder( argList.length);
            for( int i = 0; i < argList.length; i++ ) {
                stack1.push( argList[i]);
            }
            while (!stack1.empty()) {
                String found = (String)stack1.pop();
                stack2.push( found );
            }
            while (!stack2.empty()){
                String found2 = (String) stack2.pop();
                sb.append( found2);
                sb.append(",");
            }
            String result = sb.toString(); // String with extra ',' at the end
            //result = result.substring(0, result.lastIndexOf(result));

        return result.trim();
    }

    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        String testInput = "rabbit, sir, please";
        String testemptyList = "";
        String testOneWord = "boo";
        String testSingleCharWords = "the, q, b, f, jumped";

        System.out.println(myFunction(testInput));
        System.out.println( myFunction(testemptyList));
        System.out.println( myFunction(testOneWord));
        System.out.println( myFunction(testSingleCharWords));
}
}
