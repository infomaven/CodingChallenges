package com.company.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nadine on 5/25/16.
 * If n = 0, declare that n! = 1
 * Otherwise, n must be positive.
 * Solve the subproblem of computing (n - 1)!, multiply that by n & set  equal to n!.
 * Keep going until all you have is a simple case of n! = x -> this will be the "base case" for recursion
 */
public class Factorial {

   private static int iterativeFactorial(int n) {

       int result = 1;
       for (int i = n; i > 0; i-- ) {
           result = result * i;
       }

       return result;

    }

    private static int recursiveFactorial( int n ) {

        /// base case
        if (n == 0) {
            return 1;
        } else {
            return recursiveFactorial( n - 1) * n;
        }

    }

    public static void main( String[] args) throws IOException {
        System.out.println("Please enter a number to use for the iterativeFactorial calculation: ");
        BufferedReader bf = new BufferedReader(( new InputStreamReader((System.in))));
        String input = bf.readLine();
        int inputValue = Integer.parseInt(input);

        //int outputValue = iterativeFactorial(inputValue);
        int outputValue = recursiveFactorial( inputValue);

        System.out.println( "Factorial of " + inputValue + " =  " + outputValue);

    }
}
