package com.company.fileparsing;

import java.io.*;
import java.util.*;

/**
 * Created by nadine on 4/30/16.

 */
public class AlphabeticallySortLinesOfText {

    private static int NUMBER_OF_PAGES;
    private Map<String,Integer> masterList = new HashMap<String, Integer>();
    private static List<String> sortedList = new ArrayList<String>();
    private static String inputFile= "";
    private static String outputFile = "";


    public static void main(String[] args) throws Exception {
         inputFile = "testlog.txt";
         outputFile = "alpha_sorted.txt";

        FileReader fReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fReader);

        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null) {
            String lineAsText = inputLine;
            String[] lineTokens = lineAsText.split("\t");
            /// extract user and page columns to use for the sorting operation
            String filteredLine = lineTokens[1] + "\t" + lineTokens[2];
            sortedList.add(filteredLine);
        }
        fReader.close();

        /// sort by column 1 (userId)
        Collections.sort(sortedList);
        NUMBER_OF_PAGES = sortedList.size();

        FileWriter fileWriter = new FileWriter((outputFile));
        PrintWriter out = new PrintWriter(fileWriter);
        int linesInFile = sortedList.size();
        System.out.println("Program to sort lines from a text file by userId and pageId");
        System.out.println( "Lines in this file = " + linesInFile);
        System.out.println("*******************");
        for (String outputLine : sortedList) {
            System.out.println(outputLine);
        }
        out.flush();
        out.close();
        fileWriter.close();

    }

    /// todo: add a Constructor

    /// todo: add methods to encapsulate the operations done in main()

    protected void findPagePatterns(int startIndex, int patternLength, int numberOfPages)
    throws Exception {
        // check for multiple of 3
        if ( NUMBER_OF_PAGES % patternLength != 0 ) {
            // todo: figure out how to handle this unhappy path

        } else {
        // while NUMBER_OF_PAGES >  patternLength
        while (NUMBER_OF_PAGES > patternLength) {
            for (int i=startIndex; i < patternLength; i++ ) {
                // capture pageId at startIndex
                String p1 = sortedList.get(i);
                // capture pageId at startIndex + 1
                String p2 = sortedList.get( i + 1);
                // capture pageId at startIndex + 2
                String p3 = sortedList.get( i + 2);
                // concatenate pageIds to make a unique String -- userPath
                String path = p1 + p2 + p3;
                // add to master collection and update count
                if (masterList.containsKey(path)) {
                    /// GET VALUE AND INCREMENT

                } else {
                    /// create all new Entry

                }
                // if path is in collection, increment
                // set startIndex = startIndex + 1
                startIndex++;
                // decrement number_of_psges
                NUMBER_OF_PAGES--;
            }
            // repeat steps above
        }
        }

        /// todo: define private class members at end of file

    }

}
