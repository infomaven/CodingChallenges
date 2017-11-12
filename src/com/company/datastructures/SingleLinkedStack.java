package com.company.datastructures;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by nadine on 5/26/16.
 * LINKEDLIST is a doubly-linked impl of List and Deque interfaces.
 *
 * Implement a Stack from scratch
 * Single linked list used to store the data. Head is the only place to insert or remove items
 *
 * Performs best with ADD/REMOVE. Slower than arraylist for SEARCH

 */


public class SingleLinkedStack<T> implements Stack<T>, Iterable<T> {

    private Node lastNode = null;   // top of stack
    private int stackSize;

    private class Node {
        private T item;
        private Node next;

    }

    public SingleLinkedStack() {
        lastNode = null;
        stackSize = 0;
    }

    // refactor: add this to the interface
    public boolean isEmpty() {
        return lastNode ==null;
    }

    public int getStackSize() {
        return stackSize;
    }

    public SingleLinkedStack<T> push(T ele) {
        Node nextDown = lastNode;
        lastNode = new Node();
        lastNode.item = ele;
        lastNode.next = nextDown;
        stackSize++;

        return this;

    }

    public T pop() {
        if (stackSize == 0) {
            System.out.println("Stack is empty");
            return null;
        }
        T ele = lastNode.item;
        lastNode = lastNode.next;
        stackSize--;

        return ele;
    }

    // refactor: consider adding peek() to the interface
    public T  peek() {
        if (!isEmpty()) {
            T ele = lastNode.item;
            lastNode = lastNode.next;
            return ele;
        } else {
            System.out.println("Stack is empty");
            return null;
        }

    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = lastNode;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                T ele = current.item;
                current = current.next;
                return ele;
            }
        }


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator iterator = new SingleLinkedStack.ListIterator();
        while (iterator.hasNext()) {
            sb.append( iterator.next().toString());
        }
        return sb.toString();

        //return this.toString();       // this line triggered Stackoverflow!
    }

    public static void main(String[] args) {
        SingleLinkedStack<Integer> intTest = new SingleLinkedStack<Integer> ();
        intTest.push(17);
        System.out.format("Stack: %s", intTest.toString() );
        System.out.println("");
        int i = intTest.pop();
        System.out.format("pop: %4d%n", i);
        System.out.println("\n");

        SingleLinkedStack<String> strTest = new SingleLinkedStack<>();
        strTest.push("My dog");
        strTest.push(" has ");
        strTest.push( " fleas" );
        System.out.format("Stack: %s", strTest.toString());
        System.out.println("");
        System.out.format("peek() method: %s",  strTest.peek());
        System.out.println("");
        String s1 = strTest.pop();
        String s2 = strTest.pop();
        //fixme: SingleLinkedList needs to handle pop() of last element better
//        String s3 = strTest.pop();
//        System.out.format("pop(): %s %s %s", s1, s2, s3);
    }
}









