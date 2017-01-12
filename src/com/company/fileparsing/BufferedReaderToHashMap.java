package com.company.fileparsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nwhi12 on 12/22/16.
 * Sample lines from file:
 *
 */
public class BufferedReaderToHashMap {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader((new File("input.txt"))));
        String inputLine = null;
        Map<String, Integer> dictionary = new HashMap();
        while ((inputLine = reader.readLine()) != null) {
            // split input line
            String[] words = inputLine.split("\\s+");
            // ignore empty lines
            if (inputLine.equals(" "))
                continue;

            for (String word : words) {
                // strip out commas and dots
                word = word.replace(".", " ");
                word = word.replace(",", " ");

                if (dictionary.containsKey(word)) {
                    Integer val = (Integer) dictionary.get(word);
                    dictionary.put(word, val + 1);
                } else {
                    dictionary.put(word, 1);
                }
            }

            // print out all words stored in the map
            for (String key: dictionary.keySet())
                System.out.println( key + ": " + dictionary.get(key));
            reader.close();
        }
    }
}
