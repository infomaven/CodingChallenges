package com.company.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by nadine on 5/24/16.
 */
public class QueueImplementedWithStacks {

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
            }

        return sb.toString();
    }

    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        String testInput = "test input";
        System.out.println(myFunction(testInput));
}
}
