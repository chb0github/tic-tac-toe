package org.bongiorno.algorithms.search;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class IncrementalTest {

    @org.junit.Test
    public void testDawg() throws Exception {
        TrieSearch dawg = new TrieSearch(new HashSet<String>(Arrays.asList("christian","bongiorno","christmas","chime","joeseph","joe")));
        dawg.load();
        Set<String> results = dawg.find("chr");
        
        HashSet<String> expected = new HashSet<String>(Arrays.asList("christian", "christmas"));
        assertEquals(expected,results);

        results = dawg.find("chi");

        expected = new HashSet<String>(Arrays.asList("chime"));
        assertEquals(expected,results);

        // wip
//        results = dawg.find("247");   // chi as numbers on a phone keypad
//
//        expected = new HashSet<String>(Arrays.asList("chime"));
//        assertEquals(expected,results);

    }

    @Test
    public void testCycleTest() throws Exception {
        TrieSearch dawg = new TrieSearch(new HashSet<String>(Arrays.asList("boot","bot","bottom","cat","car","cannee")));
        dawg.load();
        Set<String> results = dawg.find("boot"); 
        assertEquals(new HashSet<String>(Arrays.asList("boot")),results);

        results = dawg.find("bot");
        assertEquals(new HashSet<String>(Arrays.asList("bot","bottom")),results);

        results = dawg.find("bottom");
        assertEquals(new HashSet<String>(Arrays.asList("bottom")),results);
    }

    @Test
    public void testloadFile() throws Exception {

        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/christian/cleanwords.txt")));
        TrieSearch dawg = new TrieSearch();
        Random rand = new Random();
        
        for(int count = 0; r.ready() || count <= 10000; ) {
            String s = r.readLine();
//            if (rand.nextInt(101) == 100) {
                dawg.addWord(s);
//                count++;
//            }

        }
        Set<String> results = dawg.find("jack");

        System.out.println(results);

    }
}
