package com.company.datastructures;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by nadine on 5/8/16.
 * Demonstrates different ways to iterate over Map entries in Java starting with Java 1.4
 */
public class MapWalkerTest {

    /// using generics to say Map key is Integer and value is String
    Map<Integer,String> map = new HashMap<>();

    public void setup() {
        map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Groovy");
        map.put(3, "Scala");
        map.put(4, "Clojure");
        map.put(5, "jRuby");

    }

    /**
     * This is Java 1.4 because of using an Iterator.
     * Use of 'while' loop is old as well.
     * However, using Generics is NOT java 1.4 compliant
     * @throws Exception
     */
    @Test
    public void testMapWithOldStyleIterator() throws Exception {
        List<String> jvmLangs = new ArrayList<>();
        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            /// hard cast is required for each element retrived. This is a generally a 'code smell'
            Map.Entry<Integer, String> entry = (Map.Entry<Integer,String>) iterator.next();
            jvmLangs.add( entry.getValue());

        }

        assert jvmLangs.size() == 5;
    }

    /**
     * Java 1.5 approach
     * Using for-each loop eliminates code smell of using a hard cast
     */
    @Test
    public void testMapWithForEach() {
        List<String> jvmLangs = new ArrayList<>();

        for (Map.Entry<Integer,String> entry : map.entrySet()) {
            /// for-each syntax preserves the data types so no casting is needed. Code smell eliminated.
            jvmLangs.add( entry.getValue());
        }

        assert jvmLangs.size() == 5;
    }

    /**
     * This is Java 1.8
     * Using Java8 lambdas to iterate over Map entries
     */
    @Test
    public void testMapWithLambdas() {
        final List<String> langs = new ArrayList<>();

        map.forEach((k, v) -> langs.add(v));

        assert langs.size() == 5;

    }





}
