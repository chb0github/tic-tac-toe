package org.bongiorno.algorithms.search;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TrieSearch {

    private static char[] CHARS_TO_NUMBER = new char[26];
    static {
        // map the character of the word to it's corresponding number.
        // by mapping from char to char we can leverage the existing code
        CHARS_TO_NUMBER['a' -'a'] = '2';
        CHARS_TO_NUMBER['b' -'a'] = '2';
        CHARS_TO_NUMBER['c' -'a'] = '2';
        
        CHARS_TO_NUMBER['d' -'a'] = '3';
        CHARS_TO_NUMBER['e' -'a'] = '3';
        CHARS_TO_NUMBER['f' -'a'] = '3';

        CHARS_TO_NUMBER['g' -'a'] = '4';
        CHARS_TO_NUMBER['h' -'a'] = '4';
        CHARS_TO_NUMBER['i' -'a'] = '4';
        
        CHARS_TO_NUMBER['j' -'a'] = '5';
        CHARS_TO_NUMBER['k' -'a'] = '5';
        CHARS_TO_NUMBER['l' -'a'] = '5';

        CHARS_TO_NUMBER['m' -'a'] = '6';
        CHARS_TO_NUMBER['n' -'a'] = '6';
        CHARS_TO_NUMBER['o' -'a'] = '6';
        
        CHARS_TO_NUMBER['p' -'a'] = '7';
        CHARS_TO_NUMBER['q' -'a'] = '7';
        CHARS_TO_NUMBER['r' -'a'] = '7';
        CHARS_TO_NUMBER['s' -'a'] = '7';

        CHARS_TO_NUMBER['t' -'a'] = '8';
        CHARS_TO_NUMBER['u' -'a'] = '8';
        CHARS_TO_NUMBER['v' -'a'] = '8';
        
        CHARS_TO_NUMBER['w' -'a'] = '9';
        CHARS_TO_NUMBER['x' -'a'] = '9';
        CHARS_TO_NUMBER['y' -'a'] = '9';
        CHARS_TO_NUMBER['z' -'a'] = '9';


    }
    

    public static void main(String[] args) throws IOException {

        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        TrieSearch dawg = new TrieSearch();

        while(r.ready() ) {
            String s = r.readLine();
            dawg.addWord(s.toLowerCase());
        }
        StringBuffer buff = new StringBuffer();
        do{
            BufferedReader cmdReader = new BufferedReader(new InputStreamReader(System.in));
            int c = cmdReader.read();
            System.out.println(c);
            
        } while(buff.length() < 10);

//        Set<String> results = search.find("jack");
    }


    private Node rootNode = new Node((char)0);

    public TrieSearch(Set<String> words) {
        rootNode.associateWords(words);
    }

    public TrieSearch() {

    }

    public void load() {
        for (String word : rootNode.getAssociatedWords()) {
            addWord(word);
            addNumber(word);
        }
    }

    private String tn(String word) {
        StringBuilder buff = new StringBuilder(word.length());

        for (char c : word.toCharArray())
            buff.append(CHARS_TO_NUMBER[c - 'a']);

        return buff.toString();
    }


    public void addNumber(String word) {
        String number = tn(word);
        Node current = rootNode;
        for (char c : number.toCharArray()) {
            Node next = current.getNextNode(c);
            if (next == null) {
                next = new Node(c);
            }
            next.associateWord(word);
            next.associateWord(number);
            current.addChild(next);
            current = next;

        }
    }
    public void addWord(String input) {
        String number = tn(input);
        Node current = rootNode;
        for (char c : input.toCharArray()) {
            Node next = current.getNextNode(c);
            if (next == null) {
                next = new Node(c);
            }
            next.associateWord(input);
            current.addChild(next);
            current = next;

        }
    }

    public Set<String> find(String input) {
        Set<String> results = rootNode.getAssociatedWords();
        Node current = rootNode;
        
        for (char c : input.toCharArray()) {   // this is O(M)
            // this lookup uses a perfect hash, O(1)
            Node next = current.getNextNode(c);
            if (next == null) {
                results = Collections.emptySet();
                break;
            }

            results = next.getAssociatedWords();
            current = next;

        }
        return results;
    }


    private static class Node {
        private char czar;
        protected Node[] children = new Node[26];
        private Set<String> associatedWords = new HashSet<String>();



        private Node(char czar) {
            this.czar = czar;
        }


        public boolean associateWord(String word) {
            return this.associatedWords.add(word);
        }

        public Node addChild(Node child) {
            if (child != null) {
                int index = child.czar - 'a';
                if(index < 0)
                    index = child.czar - '0';
                children[index] = child;
            }
            return this;
        }

        @Override
        public String toString() {
            return "" + czar + "-->" + associatedWords;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            return czar == node.czar;

        }

        @Override
        public int hashCode() {
            return (int) czar;
        }

        public Node getNextNode(char c) {

            int index = c - 'a';
            if(index < 0)
                index = c - '0';
            return children[index];
        }

        public Set<String> getAssociatedWords() {
            return associatedWords;
        }

        public void associateWords(Set<String> words) {
            this.associatedWords = words;
        }

    }
    private static class NumericNode extends Node {

        private NumericNode(char czar) {
            super(czar);
        }

        @Override
        public Node getNextNode(char c) {
            return children[c - '0'];
        }

        @Override
        public Node addChild(Node child) {
            if (child != null)
                children[child.czar - '0'] = child;

            return this;
        }
    }
}
