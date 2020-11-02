package com.example.galgeleg;

import java.util.ArrayList;
import java.util.Random;

public class Library {

    ArrayList<String> listOfWords;

    public Library() {
        listOfWords = new ArrayList<String>();
        listOfWords.add("hangman");
        listOfWords.add("test");
        listOfWords.add("keyboard");
        listOfWords.add("kk");
        listOfWords.add("d");
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

    public void useListFromDR() {

    }

    public void clearList() {
        listOfWords.clear();
    }
}
