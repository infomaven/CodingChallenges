package com.company.datastructures;

/**
 * Created by nadine on 5/26/16.
 *
 * Implement a Stack from scratch
 * This stack expects Long data types
 */


public class Stack_UsingArray {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public static void main( String[] args) {

        System.out.println( "Please enter the values that will go in the Stack. ");

        Stack_UsingArray st = new Stack_UsingArray(5);
        st.push(20);
        st.push(30);
        st.push(10);
        st.push(50);
        st.push(2);
        long lastIn = st.peek();
        System.out.println("Last element added = " + lastIn);
        System.out.println("Now it's time to unload the Stack! THis is a LIFO (last-in-first-out)\n");

        while( !st.isEmpty()) {
            long value = st.pop();
            System.out.println( value );
        }

    }

    public Stack_UsingArray(int size) {
        this.maxSize = size;
        this.stackArray = new long[maxSize];
        this.top = -1;

    }



    public void push(long j) {
        if ( !isFull()) {
            top++;
            stackArray[top] = j;
        } else {
            System.out.println("Stack is full");
        }
    }

    public long pop() {

        if ( !isEmpty()) {
            long topValue = stackArray[top];
            top--;
            return topValue;
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public long peek() {
        long topValue = stackArray[top];

        return topValue;
    }

    private boolean isEmpty() {

        boolean empty = false;
        if ( top == -1)
            empty = true;

        return empty;
    }

    private boolean isFull() {

        boolean full = false;
        if ( top == (maxSize + 1) )
            full = true;

        return full;
    }
}
