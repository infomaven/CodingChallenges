package com.company.sorting;
/*
From https://www.programcreek.com/2012/11/leetcode-solution-sort-a-linked-list-using-insertion-sort-in-java/
Purpose: Sort a LinkedList using insertion sort algorithm. Alternatively, QuickSort or MergeSort can be used for this task as well.

- LinkedList can also use the Collections.sort() method from standard Java, or if using Java8, you can use LinkedList.sort() directly
- Under the hood, LinkedList is a doubly linked list, which supports traversal from head to tail and vice versa
- ArrayLists and LinkedLists do not provide random access by index, so any kind of sorting is  EXPENSIVE

Worst case: O(n^2)
Avg case:
Best case:

 */

import com.company.datastructures.ListNode;

public class InsertSortLinkedList {
    public static ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null)
            return null;

        // set first Node as head of the sorted list
        ListNode newHead = new ListNode(head.val);
        ListNode pointer = head.next;

        // loop through each element in the list
        while (pointer != null) {
            // insert this element to the new list

            ListNode innerPointer = newHead;
            ListNode next = pointer.next;

            if (pointer.val <= newHead.val) {
                ListNode oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            } else {
                while (innerPointer.next != null) {

                    if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
                        ListNode oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext;
                    }

                    innerPointer = innerPointer.next;
                }

                if (innerPointer.next == null && pointer.val > innerPointer.val) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }

            // finally
            pointer = next;
        }

        return newHead;
    }

    public static void printList(ListNode x) {
        if(x != null){
            System.out.print(x.val + " ");
            while (x.next != null) {
                System.out.print(x.next.val + " ");
                x = x.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);

        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n1 = insertionSortList(n1);

        printList(n1);

    }


}