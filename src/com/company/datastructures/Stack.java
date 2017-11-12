package com.company.datastructures;
/*
Contract for methods that a Stack should implement
 */

public interface Stack<T> {
    Stack<T> push(T ele );
    T pop();
}


