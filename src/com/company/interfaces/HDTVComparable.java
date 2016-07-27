package com.company.interfaces;

/**
 * Created by nadine on 7/25/16.
 * Comparable interface make it possible to compare instances of a class to each other using one class attribute/property
 * for comparison
 */
public class HDTVComparable implements Comparable<HDTVComparable> {
    private int size;
    private String brand;

    public HDTVComparable(int size, String brand) {
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

    @Override
    public int compareTo(HDTVComparable o) {

        if (this.getSize() > o.getSize())
            return 1;
        else if (this.getSize() < o.getSize())
            return -1;
        else
            return 0;
    }

    public static class Main {
        public static void main( String[] args) {

            HDTVComparable tv1 = new HDTVComparable( 55, "Samsung");
            HDTVComparable tv2 = new HDTVComparable( 60, "Sony");
            HDTVComparable tv3 = new HDTVComparable( 100, "Roku");
            if (tv1.compareTo( tv2 ) > 0 ) {
                System.out.println( tv1.getBrand() + " is better.");
            } else {
                System.out.println( tv3.getBrand() + " is better.");
            }
        }
    }
}
