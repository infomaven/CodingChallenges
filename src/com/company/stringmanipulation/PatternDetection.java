package com.company.stringmanipulation;

/**
 * Created by nwhi12 on 12/29/16.
 * Solutions that find patterns within an array
 * For most, the array controls have to be "tweaked" to avoid going out of bounds
 */
public class PatternDetection {
    public static void main(String[] args) {
        PatternDetection pd = new PatternDetection();
        // shorten the loop. use i, i+2 with substring()
        int result = pd.countXX("foobarxxaxxbxx");
        System.out.println( "countXX result: " + result );
        int result2 = pd.last2("WitbeckShane");
        System.out.println( "last2 result: "+ result2);

    }

    /**
     * Detect frequency of text pattern occurring anywhere within a larger String.
     * It is possible to have overlaps between 3 chars.
     * Solution: 1) Treating the String as an array - iterate using indexed loop so we can leverage substring()
     * 2) Upper limit of the loop = str.length()-1
     * 3) Capture currentIndex and currentIndex + 2
     * 4) Compare these this to the pattern
     * @param str
     * @return frequency count for a pattern within larger String
     */
    protected int countXX(String str) {
        int count = 0;
        // todo: run this with debugger to better understand the looping adjustments
        // overlapping is allowed
        String pattern = "xx";
//        for (int i=0; i<str.length(); i++) {   /// this caused 'out of bounds' errors
          for (int i=0; i<str.length()-1; i++) {
//            if ( str.substring(i, i+1).equals(pattern) ) {    /// this failed to detect the pattern
              if ( str.substring(i, i+2).equals(pattern) ) {
                count++;
            }
        }

        return count;
    }

    /**
     * Detect frequency of last 2 chars of a String and count frequency from balance of same String
     * Solution: 1) Treat the String as an array - iterate using indexed loop so we can leverage substring()
     * 2) Upper limit of loop = str.length()-2
     * 3) Find out what last 2 chars are in the string (model pattern)
     * 3) Capture currentIndex and currentIndex+2 (temporary pattern)
     * 4) Compare temporary pattern to model pattern. If they match, count++
     * @param str
     * @return count
     */
    protected int last2(String str) {
        // eliminate String if it is shorter than 2 chars
        if (str.length() < 2) return 0;
        // capture last 2 chars (model pattern) f o o b a r
        String finalTwo = str.substring( str.length()-2);

        int count = 0;
        // iterate the String and create temp patterns for comparison against the model
        for (int i = 0; i < str.length()-2; i++) {
            String candidate = str.substring(i, i+2);
            if (candidate.equals(finalTwo)) {
                count++;
            }
        }
        return count;
    }


}
