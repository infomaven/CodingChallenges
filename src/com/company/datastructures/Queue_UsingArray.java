package com.company.datastructures;

/**
 * Created by nadine on 5/26/16.
 * FIFO - First in First Out
 * 1. insert to the array
 *
 */
public class Queue_UsingArray {

    private int maxSize; /// initializes with set number
    private long[] queueArray; /// slots to store the data
    private int front; /// index position of first element
    private int rear; /// index position of last element
    private int nItems; /// number of items in queue

    public static void main( String[] args) {
        Queue_UsingArray myQ = new Queue_UsingArray(5);
        myQ.insert(100);
        myQ.insert(1000);
        myQ.insert(14);
        myQ.insert(99);
        myQ.insert(99);
        myQ.insert(99);
         myQ.view();
    }

    public Queue_UsingArray(int size) {
        this.maxSize = size;
        this.queueArray = new long[size];
        front = 0; /// index of first slot in array
        rear = -1; /// there is nothing at the rear yet
        nItems = 0; /// no elements in the array yet
    }

    public void insert( long j) {
        if ( rear == maxSize - 1) {
            rear = -1; /// this makes it a circular queue -- auto-refresh.
            // There is option to have it just notify user when condition is met and just exit without any action
        } else {
            rear++;
            queueArray[rear] = j;
            nItems++;
        }

    }

    public void view() {
        System.out.print("[ ");
        for (int i = 0; i < queueArray.length; i++) {
            System.out.println( queueArray[i]);
        }
        System.out.println(" ]");
    }

    public long remove() { /// remove items from front of queue}
        long temp = queueArray[front];
        front++;
        if (front == maxSize) {
            front = 0; /// reset to zero so the array can be used again
        }
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queueArray[front]; /// just looking; no index updates
    }

    public boolean isEmpty() {
        return (nItems ==0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

}
