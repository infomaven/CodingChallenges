package com.codility.TimeComplexity;

/**
 * Created by nadine on 6/19/16.
 */
public class FrogJump {

    public static void main( String[] args) {
        Solution s = new Solution();
         s.solution(  10, 85, 30)
;    }

    static class Solution {
        public int solution(int X, int Y, int D) {
            // write your code in Java SE 8
            int distanceToCover = Y - X;
            if ( distanceToCover % D == 0) {
                return distanceToCover / D;

            } else {
                return (distanceToCover / D) + 1;

            }
        }
    }


}
