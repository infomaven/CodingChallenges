package com.company.timecomplexity;

/**
 * Created by nadine on 4/9/16.
 */
public class FrogJump {
/// https://codility.com/programmers/task/frog_jmp/
    /// 22% score (Correctness poor, performance poorer)
    public static int frogJump1(int X, int Y, int D) {

        int distanceCovered = X + D;
        int numJumps = 1;
        while (distanceCovered <= Y) {
            distanceCovered = distanceCovered + D;
            numJumps++;
        }
        return numJumps;
    }

    //// 44% score (25% correctness, 60% performance)
    public static int fromJump2(int X, int Y, int D) {
        int diff = Y - X;
        int mod;
        int numJumps = 0;
        if (D > 0) {

            numJumps = numJumps + (diff / D);

        }


        return numJumps;
    }

    /**
     * The solution need to be coded using diff operation instead of a for-loop
     * for the sake of time complexity or making the code run faster.
     * For-loops just wont do because of the seconds of time allowed it is running.
     * Then I used modulo operator (Mathematics) to find out if its even or odd number.
     * @param X  /// starting point
     * @param Y   /// destination
     * @param D    //// distance per jump
     * @return
     */
    public static int frogJump3( int X, int Y, int D ) {
        int distance = Y-X;
        if (distance % D ==0 ) {
            return distance/D;
        } else {
            return distance/D + 1;
        }
    }



}

