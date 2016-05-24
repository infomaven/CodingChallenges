package com.company.fileparsing;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nadine on 5/1/16.
 *  * Find Maximum Occurrence of Words from given Text File

 Here is a logic for getting top element:

 Create a class  that can store the String value of the word and the number of occurrences it appears.
 Implement the Comparable interface for this class to sort by occurrences first and then alphabetically if the number of occurrences is the same
 Implement method to findMaxOccurances. you create a new List of Comparable from your original map.
 You add the entries of this to your List
 Sort this list
 Take the n-first items of this list using subList
 Add Strings to the List<String> and you return it
 Another most read: Find more information on equals() and hashcode()
 */
public class WordFrequencyCounter {


    public static void main(String[] args) throws FileNotFoundException {


    }

    public static List<String> findMaxOccurances(Map<String, Integer> map, int n) {
        List<String> sortedList = new ArrayList<>();

        return sortedList;
    }

    class PathComparable implements Comparable<PathComparable> {
        public String userPath;
        public int numberOfOccurances;

        public PathComparable(String userSession, int numberOfOccurances) {
            super();
            this.userPath = userSession;
            this.numberOfOccurances = numberOfOccurances;

        }

        protected void findSessionPages( int sizePattern ) {
            /// AlphabeticallySortLinesOfText.findPagePatterns()



        }

        @Override
        public int compareTo(PathComparable o) {
            int compare = Integer.compare(o.numberOfOccurances, this.numberOfOccurances);

            return compare != 0 ? compare : userPath.compareTo(o.userPath);
        }

        @Override
        public int hashCode() {
            final int uniqueNumber = 42;
            int result = 22;
            result = uniqueNumber * result + numberOfOccurances;
            result = uniqueNumber * result + ((userPath == null) ? 0 : userPath.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }

            PathComparable other = (PathComparable) obj;
            if (numberOfOccurances != other.numberOfOccurances) {
                return false;
            }
            if (userPath == null) {
                if (other.userPath != null) {
                    return false;
                } else if (!userPath.equals(other.userPath)) {
                    return false;
                }

            }
            return true;
        }


    }
}
