package com.company.fileparsing;

/*

For details, see java_PhilbertsFileProblem.txt


 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Paths.get;

public class Philbert {


    /**
     * Find pages visited by single user
     * @param user
     * @param pathSize
     * @return
     */
    private Integer countPagePaths( String user, Integer pathSize) {

        return 0;
    }

    private String quotify( String text ) {
        String  QUOTE = " ; ";
        return QUOTE + text + QUOTE;
    }


    //private Map<String, String> pagePaths = new HashMap();
    private TreeMap<String,String> userPaths = new TreeMap<String,String>();

    private Path fPath = null;
    private File inputFile = null;
    private static Charset UTF_8;
    private final static Charset ENCODING = UTF_8.defaultCharset();
    private static void log( Object obj ) {
        System.out.println( String.valueOf( obj));
    }


    public Philbert(String fName, int patternSize ) {

        fPath = Paths.get(fName);
        inputFile = new File(fName);

    }


    /**
     * This parse method does not allow for multiple values to be stored for each user
     * We definitely need that to accomodate the data
     * @param lineText
     */
    protected void parseLine( String lineText ) {
        Scanner scanner2 = new Scanner( lineText);
        scanner2.useDelimiter( "\t");
        if (scanner2.hasNext()) {
            // split line into String tokens and get tokens by index (zero-based index)
            // 2015-02-02 12:02:06	user38	/product/41	0.603s
            String line = scanner2.nextLine();
            String[] lineTokens = line.split("\t");
            String user = lineTokens[1];
            String page = lineTokens[2];

            //// todo: add logic to allow collection of pages for each user
            userPaths.put( user, page );
        }
    }

    protected void printTreeMap() {
        Set set = userPaths.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry currEntry = (Map.Entry) iterator.next();
            System.out.print("(" + currEntry.getKey() + "," + currEntry.getValue() + " ) ");
        }
    }


    public void processAndPrint() throws Exception, FileNotFoundException {
        //Scanner scanner = new Scanner( fPath, ENCODING.name());
        Scanner scanner = new Scanner( inputFile, ENCODING.name());
        try {
            // read each line using Scanner class
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                parseLine(scanner.nextLine());
                lineNumber++;
            }

            printTreeMap();

        } catch (Exception ex ) {
            ex.printStackTrace();
        }
    }





    public static void main( String[] args ) {
        // parse file into target class

        // iterate through entries and apply crawler (philparser) method

        // print results
    }



}
