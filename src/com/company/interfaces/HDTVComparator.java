package com.company.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by nadine on 7/25/16.
 * Comparable interface make it possible to compare instances of a class to each other using one class attribute/property
 * for comparison
 */
public class HDTVComparator {
    private int size;
    private String brand;

    public HDTVComparator(int size, String brand) {
        this.size = size;
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}

class CompareBySize implements Comparator<HDTVComparator> {
    @Override
    public int compare( HDTVComparator tv1, HDTVComparator tv2 ) {
        int tv1Size = tv1.getSize();
        int tv2Size = tv2.getSize();

        if (tv1Size > tv2Size ) {
            return 1;
        } else if (tv1Size < tv2Size) {
            return -1;
        } else {
            return 0;
        }
    }
}

class CompareByBrand implements Comparator<HDTVComparator> {
    /**
     *
     * @param o1
     * @param o2
     * @return 0 -> equal,
     */
    @Override
    public int compare(HDTVComparator o1, HDTVComparator o2) {
        String brand1 = o1.getBrand();
        String brand2 = o2.getBrand();
        // strip out first char
        Character b1, b2;
        b1 = brand1.charAt(0);
        b2 = brand2.charAt(0);
        int res;
        // 0 -> equal, > 0 -> first char is greater, < 0 -> second char is greater
        res = b1.compareTo(b2);

        return res;
    }
}


class Main {
    public static void main( String[] args) {
        HDTVComparator tv1 = new HDTVComparator(55, "Samsung");
        HDTVComparator tv2 = new HDTVComparator(60, "Sony");
        HDTVComparator tv3 = new HDTVComparator(42, "Panasonic");

        ArrayList<HDTVComparator> al = new ArrayList<HDTVComparator>();
        al.add( tv1);
        al.add( tv2 );
        al.add( tv3);

        Collections.sort( al, new CompareBySize());
        for (HDTVComparator a : al ) {
            System.out.println( a.getSize());
        }

        Collections.sort( al, new CompareByBrand());
        for (HDTVComparator a : al) {
            System.out.println( a.getBrand());
        }

    }

}




