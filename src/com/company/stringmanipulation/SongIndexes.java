package com.company.stringmanipulation;

import java.util.*;

public class SongIndexes {

    protected static void printDict(Map input) {
        input.forEach( (k,v) -> System.out.println("Title: " + k + " Volume: " + v));

    }


    protected static Map buildIndex( List vols) {
        Map<String, List<String>> index = new HashMap<String, List<String>>();

        for ( int i  = 0; i < vols.size(); i++ ) {
//            for (int j = 0; j <= vols[i].length();  j++ ) {
//                String title = vols[i][j];
//                String volume = vols[i];
//                index.put( title, volume );
//            }
//            System.out.println(vols.get(i));
//            System.out.println( vols.get(i).getClass().getName());
            System.out.println("Volume: " + i );
            System.out.println( vols.get(i));
           // get inner arraylist  as an iterable object
            List volumeList = Arrays.asList(vols.get(i)) ;
            index.put( String.valueOf(i), volumeList );

//            for  ( Object title: volumeList  ) {
//                System.out.println( title );
//                index.put( String.valueOf(i), title.toString() );
//
//            }
//            System.out.println(index);


        }

        return index;

    }

    public static void main( String[] args ) {
        //sample volumes:
        List<String> vol1 =Arrays.asList("song one", "song two plus stuff", "song three");
        List<String> vol2 = Arrays.asList("song four", "song three", "song five", "song six is rather long in title...");
        List<String> vol3 =  Arrays.asList("song seven too", "song eight random length as well", "song nine");
        List<String> vol4 =  Arrays.asList("eight", "nine random length as well", "ten more more more nine");
        List<String>  vol5 = Arrays.asList("eleven too", "song twelve random length as well", "song thirteen");
        List<String>  vol6 = Arrays.asList("song fourteen do be doo too", "song fifteen random length", "song thirteen");

// problem: create a master index that can tell a user which volume contains a particular song title. A song can possibly be contained by more than one volume.

        Map<String, String> myDict = new HashMap<String, String>();
        List<List<String>> volumes = new ArrayList<>();
        volumes.add( vol1);
        volumes.add( vol2 );
        volumes.add( vol3 ) ;
        volumes.add( vol4 );
        volumes.add( vol5 );
        volumes.add( vol6 );

      myDict=  buildIndex( volumes );



    }
}
