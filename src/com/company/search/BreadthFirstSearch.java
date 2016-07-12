package com.company.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nadine on 6/12/16.
 * Assigns two values to each vertex v: 1) distance (min number of edges in any path from source vertext to vertex v)
 * 2) vertex v's predecesor  (aka shortest path from source vertex)
 * Start with all predecessors and distances set to Null
 * Uses a Queue structure to store the values
 * 
 */

public class BreadthFirstSearch {

    private Queue<Integer> queue;

    public BreadthFirstSearch() {
        queue = new LinkedList<Integer>();
    }

    public static void main( String[] args ) {

    }

    private void bfs() {
        // TODO: IMPLEMENT breadth-first search algorithm

    }
}
