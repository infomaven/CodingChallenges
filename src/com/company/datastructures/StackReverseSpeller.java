package com.company.datastructures;

/**
 * Created by nadine on 5/26/16.
 *
 * Implement a Stack from scratch (LIFO)
 * A stack can manage tracking of parentheses when parsing code of an algebraic equation
 *
 */


public class StackReverseSpeller {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public static void main( String[] args) {

  System.out.println("Filling Stack with a new word. It will be printed with reverse spelling");
        String inputWord = "aardvark";

        StackReverseSpeller st = new StackReverseSpeller( inputWord.length());

        for (int i = 0; i < inputWord.length(); i++ ) {
            st.push(inputWord.charAt(i));
            System.out.print(inputWord.charAt(i));
        }
        System.out.println("Size of the Stack  = " + st.stackArray.length);


        System.out.println("\n");
        System.out.println("Time for the reversal...");

        while( !st.isEmpty()) {
            char value = st.pop();
            System.out.print(value);
        }

    }

    public StackReverseSpeller(int size) {
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.top = -1;

    }


    public void push(char j) {
        if ( !isFull()) {
            top++;
            stackArray[top] = j;
        } else {
            System.out.println("Stack is full");
        }
    }

    public char pop() {

        if ( !isEmpty()) {
            char topValue = stackArray[top];
            top--;
            return topValue;
        } else {
            System.out.println("Stack is empty.");
            return ' ';
        }
    }

    public char peek() {
        char topValue = stackArray[top];

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
