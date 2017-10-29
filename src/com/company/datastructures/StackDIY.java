package com.company.datastructures;

/**
 * Created by nadine on 5/26/16.
 *
 * StackDIY.java
 * Implement Stack using an Array of long primitives
 *
 */


public class StackDIY {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public static void main( String[] args) {
        StackDIY st = new StackDIY(5);
        System.out.println( "Value prepopulated in the stack >");

        st.push(20);
        st.push(30);
        st.push(10);
        st.push(50);
        st.push(2);

        while( !st.isEmpty()) {
            long value = st.pop();
            System.out.println( value );
        }

    }

    public StackDIY(int size) {
        this.maxSize = size;
        this.stackArray = new long[maxSize];
        this.top = -1;

    }



    public void push(long j) {
        if ( !isFull()) {
            top++;
            stackArray[top] = j;
            System.out.println("pushed: " + j);
        } else {
            System.out.println("StackDIY is full");
        }
    }

    public long pop() {

        if ( !isEmpty()) {
            long topValue = stackArray[top];
            top--;
            return topValue;
        } else {
            System.out.println("StackDIY is empty.");
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
