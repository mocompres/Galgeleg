package com.example.galgeleg;

import android.provider.Telephony;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Library {

    ArrayList<String> listOfWords;

    public Library() {
        listOfWords = new ArrayList<String>();

        WordsFromWeb wordList = new WordsFromWeb("https://www.dr.dk");

        //listOfWords.add("hangman");
        try {
            String input = wordList.execute().get();
            convertWebToWordList(input);
            listOfWords.add("working");
           // useListFromDR();

        } catch (Exception e) {
            listOfWords.add("hangman");
        //    listOfWords.add("test");
        //    listOfWords.add("keyboard");
        //    listOfWords.add("galge");
        //    listOfWords.add("skærm");
        }


    }

    public ArrayList<String> getListOfWords() {
        return listOfWords;
    }

    public void addWord(String word) {
        listOfWords.add(word);
    }

    public String getRandomWord() {
        Random ran = new Random();
        int cntWords = listOfWords.size();

        return listOfWords.get(ran.nextInt(cntWords));
    }


    public void convertWebToWordList(String wordStr) throws Exception {

        String data = wordStr;
        ;

        /*
        ThreadFactory thrdfctry = Executors.defaultThreadFactory();
        Thread t = thrdfctry.newThread(new Runnable() {
            @Override
            public void run() {
               // data = hentUrl("https://www.dr.dk");
            }
        });
        t.start(); */

        //data = hentUrl("https://www.dr.dk");

        //System.out.println("data = " + data);

        data = data.substring(data.indexOf("<body")). // fjern headere
                replaceAll("<.+?>", " ").toLowerCase(). // fjern tags
                replaceAll("&#198;", "æ"). // erstat HTML-tegn
                replaceAll("&#230;", "æ"). // erstat HTML-tegn
                replaceAll("&#216;", "ø"). // erstat HTML-tegn
                replaceAll("&#248;", "ø"). // erstat HTML-tegn
                replaceAll("&oslash;", "ø"). // erstat HTML-tegn
                replaceAll("&#229;", "å"). // erstat HTML-tegn
                replaceAll("[^a-zæøå]", " "). // fjern tegn der ikke er bogstaver
                replaceAll(" [a-zæøå] "," "). // fjern 1-bogstavsord
                replaceAll(" [a-zæøå][a-zæøå] "," "); // fjern 2-bogstavsord

        listOfWords.clear();
        listOfWords.addAll(new HashSet<String>(Arrays.asList(data.split(" "))));

    }

    public static String hentUrl(String url) throws Exception {
        /*System.out.println("Henter data fra " + url);
        InputStream is = new URL(url).openStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String linje = br.readLine();
        while (linje != null) {
            sb.append(linje + "\n");
            linje = br.readLine();
        }
        return sb.toString(); */


        String line = "";
        try {

            URL urlTest = new URL("https://www.google.com/");

            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader(urlTest.openStream()));


            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();

        }
        catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }

        return line;

    }

    public void clearList() {
        listOfWords.clear();
    }
}
