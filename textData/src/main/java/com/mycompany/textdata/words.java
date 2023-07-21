/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.textdata;


import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class words {

    /**
     * This method sets up the text from the URL to be displayed on the first
     * screen. it uses the readStringFromURL() method to take the text from the
     * website then removeHTMLalt(); to take that text and remove all the HTML
     * text. The text is put onlyPoem() method to return the result to the
     * screen
     *
     * @return Returns just the poem with all of the extra texts and characters
     * removed.
     * @throws IOException
     */
    public static String set() throws IOException {

        String URL = readStringFromURL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
        String noHTML = removeHTMLalt(URL);
        return onlyPoem(noHTML);

    }

    /**
     * This method sets up the text from the URL to be displayed on the first
     * screen.The text is set to all be lowercase.It uses the
     * readStringFromURL() method to take the text from the website then
     * removeHTML(); to take that text and remove all the HTML text. The text is
     * put into onlyPoem() where it puts all the words in a text is put in a
     * list. sorted() puts all of the words in the poem into a HashMap numbered
     * in order of frequency. Another HashMap is made narrowing the list down to
     * the top twenty most used words
     *
     * @return Returns the a list of the top 20 most used words in the poem with
     * a count of their occurrences.
     * @throws IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static String set1() throws IOException, ClassNotFoundException, SQLException {
        String stat = "";

        int count = 1;
        String URL = readStringFromURL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
        String lower = URL.toLowerCase();
        String noHTML = removeHTML(lower);
        ArrayList<String> wordList = biglist1(noHTML);

        // format HashMap
        Map<String, Integer> finalMap = sorted(wordList);
        {
            for (Map.Entry<String, Integer> en : finalMap.entrySet()) {
                Database.sql(en.getKey(), en.getValue());
                stat += (count + ":" + "\"" + en.getKey().trim() + "\"" + " occured " + en.getValue() + " times." + "\n");
                count++;
                if (count > 20) {
                    break;
                }
            }

        }
        return stat;

    }

    /**
     * A new scanner is created the scanner takes a Stream which is obtained
     * from a URL. OpenStream returns the stream Now the scanner can parse the
     * stream character by character with UTF-8 encoding The scanner scans the
     * url and if the scanner hasNext it will return it if not it will return
     * nothing.
     *
     * @param requestURL the URL that is going to be read from
     * @return returns the text from the given URL
     * @throws IOException
     */
    public static String readStringFromURL(String requestURL) throws IOException {
        try (Scanner scanner = new Scanner(new URL(requestURL).openStream(),
                StandardCharsets.UTF_8.toString())) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }

    /**
     * Removes the HTML tags from the text in different stages using
     * replaceAll() First it removes the long dash from the texts. Then all of
     * the HTML tags finally any punctuation and special characters.
     *
     * @param s The text from the URL that needs its HTML to be removed.
     * @return Returns the poem in plain text with all characters HTML and
     * punctuation removed.
     */
    public static String removeHTML(String s) {
        //removes long dash
        String removed = s.replaceAll("mdash", " ");
        //removes html
        String html = removed.replaceAll("<[^>]*>", "");

        //removes special characters
        String noCharacters = html.replaceAll("\\p{P}", "");

        return noCharacters;

    }

    /**
     * Removes the HTML tags from the text in different stages using
     * replaceAll() First it properly inserts the em dash. Then removes all of
     * the HTML tags. Finally all instances of the "&" are removed.
     *
     * @param s The text from the URL that needs its HTML to be removed.
     * @return Returns the poem in plain text with all characters and HTML
     * removed
     */
    public static String removeHTMLalt(String s) {
        //removes long dash
        String removed = s.replaceAll("mdash", "—");
        //removes html
        String html = removed.replaceAll("<[^>]*>", "");

        String noCharacters = html.replaceAll("&", "");

        return noCharacters;

    }

    /**
     * Narrows the text down to just the poem starting from the first word to
     * the last word. The entire webpage is presented as a single string. It
     * narrowed down to just the poem by creating a substring starting at the
     * fist word and ending at the last word
     *
     * @param d the text from the URL that is intended to be narrowed down to
     * just the poem.
     * @return The poem from the URL as a string
     */
    public static String onlyPoem(String d) {


        //narrow down text file to just the poem
        String result = d.substring(d.indexOf("Once "), d.lastIndexOf("nevermore") + 10);


        return result;

    }

    /**
     * Puts all of the words of the poem into a list. An array list is created
     * to hold all of the words.The entire webpage is presented as a single
     * string. It narrowed down to just the poem by creating a substring
     * starting at the fist word and ending at the last word. Another list is
     * created to removed the words that were connected by commas. It then
     * returns the poem as a list of words
     *
     * @param d the text from the URL that is intended to be narrowed down to
     * just the poem.
     * @return The poem from the URL as a list of words
     */
    public static ArrayList<String> biglist1(String d) {

        ArrayList<String> text = new ArrayList<>();
        //narrow down text file to just the poem
        String result = d.substring(d.indexOf("once "), d.lastIndexOf("nevermore") + 9);

        // removes instances of words connected by the previously removed commas 
        String[] werdz = result.split("\\W+");
        //adds to new list
        for (String x : werdz) {
            text.add("\n" + x);

        }

        return text;

    }

    /**
     * Creates a HashMap taking in an ArrayList. With the word and their
     * frequency being the keys and values. The first Map puts words of the poem
     * into a hash map counting the frequency of each word. A list is created of
     * the from elements of the HashMap. The list is sorted by their frequency.
     * A new list is created with the results ordered by their frequency.
     *
     * @param list A a list of words that need will be sorted into a HashMap
     * with their frequency.
     *
     * @return Returns a hashmap with the words of the poem in order of their
     * frequency.
     */
    public static Map<String, Integer> sorted(ArrayList<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {

            if (map.containsKey(list.get(i))) {
                map.put(list.get(i), map.get(list.get(i)) + 1);
            } else {
                map.put(list.get(i), 1);
            }
        }
        List<Map.Entry<String, Integer>> hash
                = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        // Sort  list
        Collections.sort(hash, (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
                -> (o2.getValue()).compareTo(o1.getValue()));
        //new list with the results
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : hash) {

            temp.put(aa.getKey(), aa.getValue());

        }
        return temp;

    }

}
