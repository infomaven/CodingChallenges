package com.company.fileparsing;

import java.io.*;
import java.util.*;


/**
 * Created by nadine on 5/1/16.
 *  * Given a text file of page hits by users in a web site, find
 *  1. 3-page sequence that happens most frequently
 *  2. slowest 3-page sequence from the group

 Algorithm:

 We need to store the 3-page-patterns, elapsed time and frequency.
 There is a requirement to find max(ElapsedTime) as well as max(Occurrence)
 Implement the Comparable interface for this class to sort by occurrences first and then alphabetically if the number of occurrences is the same
 Implement method to findMaxOccurances. you create a new List of Comparable from your original map.
 You add the entries of this to your List
 Sort this list
 Take the n-first items of this list using subList
 Add Strings to the List<String> and you return it
 Another most read: Find more information on equals() and hashcode()
 */
public class PatternFrequencyCounter {
    private static int NUMBER_OF_PAGES;
    private static List<Page> pageList = new ArrayList<Page>();
    private static List<PagePattern> masterList = new ArrayList<PagePattern>();
    private static String inputFile= "";
    private static String outputFile = "";

    public static void main(String[] args) throws Exception {

        /*
        read file
        create Map to hold Pattern objects

         */
        inputFile = "testlog.txt";
        outputFile = "alpha_sorted.txt";

        int max = 0;
        String maxPattern = "";
        double maxTime = 0.0;
        Map storage = new HashMap<>();

        FileReader fReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fReader);

        String inputLine;
        Page currentPage;
        while ((inputLine = bufferedReader.readLine()) != null) {
            String lineAsText = inputLine;
            String[] lineTokens = lineAsText.split("\t");
            /// create Pattern objects and put them into a List collection
            /// sampleText =  2015-02-02 12:02:17	user44	/product/01	0.562s
//            String filteredLine = lineTokens[1] + "\t" + lineTokens[2];
//            pageList.add(filteredLine);
            String date = lineTokens[0];
            String user = lineTokens[1];
            String pageId = lineTokens[2];
            String time = lineTokens[3];
            /// collect data into objects
            currentPage = new Page( date, user, pageId, time );
            pageList.add( currentPage);

        }
        fReader.close();

        FileWriter fileWriter = new FileWriter((outputFile));
        PrintWriter out = new PrintWriter(fileWriter);
        int linesInFile = pageList.size();
        System.out.println("Program to sort lines from a text file by userId and pageId");
        System.out.println( "Lines in this file = " + linesInFile);
        System.out.println("*******************");

        ///// RUN THE ALGORITHM
        Page[] pageArray = pageList.toArray( new Page[pageList.size()]);
        for (int i = 0; i < pageArray.length; i++ ) {
            int localCount = 0;
                String patt1 = grabPattern(i, pageArray);
                Double pattTime1 = calcTime(i, pageArray);

                for (int j = i; j < pageArray.length; j++) {
                        String patt2 = grabPattern(j, pageArray);
                        Double pattTime2 = calcTime(j, pageArray);
                        if (patt1.equals(patt2)) {
                            localCount++;
                            if ( storage.containsKey( patt1)){
                                storage.put( patt1, localCount);
                            }
                            if (pattTime2 > maxTime) {
                                maxTime = pattTime2;
                            }
                        } else {
                            break;
                        }
                }
                max = localCount;
                maxPattern = patt1;
        }
        out.flush();
        out.close();
        fileWriter.close();

        Collection counts = storage.values();
        //max = (int) Collections.max( counts );

        System.out.println("Highest frequency count = " + max);
        System.out.println("Page pattern = " + maxPattern);
        System.out.println( "Longest running pattern = " + maxTime);

    }

    private static Double calcTime(int first, Page[] pageArray) {
        Double time = 0.0;
        if (first + 2 < pageArray.length) {
            int index1 = first;
            int index2 = first + 1;
            int index3 = first + 2;
            String str3 = pageArray[index3].timestamp.replace("s", "");
            String str2 = pageArray[index2].timestamp.replace("s","");
            String str1 = pageArray[index1].timestamp.replace("s", "");
            Double time3 = Double.parseDouble(str3);
            Double time2 = Double.parseDouble( str2);
            Double time1 = Double.parseDouble(str1);
             time = time3 + time2 +  time1;
        }
        return time;
    }

    private static String grabPattern( int firstIndex, Page[] pageFile) {
        String result = "";
        if ( firstIndex + 2 < pageFile.length) {
            int index1 = firstIndex;
            int index2 = firstIndex + 1;
            int index3 = firstIndex + 2;
            result = pageFile[index1].pageid + pageFile[index2].pageid + pageFile[index3].pageid;
        }

        return result;
    }

    static class Page {
        String date;
        String userid;
        String pageid;
        String timestamp;

        public Page(String date, String userid, String pageid, String timestamp) {
            this.date = date;
            this.userid = userid;
            this.pageid = pageid;
            this.timestamp = timestamp;

        }

        @Override
        public String toString() {

            return "PageId: " + pageid + "// Timestamp: " + timestamp;
        }
    }

    static class PagePattern {
        String concatPages;
        double[] pageTimes;

        public PagePattern( String concatPages, double[] pageTimes ) {
            this.concatPages = concatPages;
            this.pageTimes = pageTimes;

        }

        protected double calculateElapsedTime( Page page3, Page page1) {
            double page3Time = Double.parseDouble( page3.timestamp.replace("s", ""));
            double page1Time = Double.parseDouble( page1.timestamp.replace("s", ""));

            double elapsed = page3Time - page1Time;

            return elapsed;
        }

    }

}




