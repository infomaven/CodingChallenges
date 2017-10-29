package com.company.datastructures;
/*
Stack that uses an ArrayList for storage. This eliminates the need to resize when the Stack fills up.
Supports Generic objects rather than a specific data type

Since Stack is a LIFO structure (last-in-first-out), it only needs to track value of last-added element (aka 'top')

 */

import java.util.*;

public class StackArray<T> implements Stack<T> {
    private ArrayList<T> stackGuts  = new ArrayList<T> ();
    private int total = 0;

    public int size() {
        return total;
    }

    public StackArray<T> push( T ele ) {
        stackGuts.add( total++, ele );

        return this;
    }

    public T pop() {
        if (total == 0) {
            System.out.println("Stack is empty");
            return null;
        }
        //System.out.format("DEBUG: last index - %s\n ", total);
        T ele = stackGuts.remove(total - 1);
        total--;

        return ele;
    }

    public T peek() {
        if (total == 0) {
            System.out.println("Stack is empty");
            return null;
        }
        T ele = stackGuts.get(total - 1);

        return ele;

    }

    @Override
    public String toString() {

        return stackGuts.toString();
    }

    public static void main( String[] args ) {
        StackArray<Integer> intTest = new StackArray<Integer> ();
        intTest.push(17);
        System.out.format("Stack contents: %s", intTest.toString() );
        System.out.println("");
        int i = intTest.pop();
        System.out.format("items popped from Stack: %4d%n", i);
        System.out.println("\n");

        StackArray<String> strTest = new StackArray<>();
        strTest.push("My dog");
        strTest.push(" has ");
        strTest.push( " fleas" );
        System.out.format("Stack contents: %s", strTest.toString());
        System.out.println("");
        System.out.format("peek() method yields %s",  strTest.peek());
        System.out.println("");
        String s1 = strTest.pop();
        String s2 = strTest.pop();
        String s3 = strTest.pop();
        System.out.format("items popped from Stack: %s %s %s", s1, s2, s3);
    }

}
