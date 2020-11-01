package com.example.galgeleg;

import java.util.ArrayList;

public class HangmanController {
    String visiableWord;
    String wordToGuess;
    String guessedLetters;
    int cntWrongGuess;

    HangmanController(String word) { // libary to read a list of words
        visiableWord = "";
        wordToGuess = word;
        cntWrongGuess = 0;
        guessedLetters = "";
    }

    public void startGame() {
        // TODO: get word to guess import from a libary
        //wordToGuess = "hangman";
        constructVisiableWord();
    }

    public void guessLetter(String letter) {
        // TODO: check if letter is correct or not
        if (wordToGuess.contains(letter)) {
            guessedLetters += letter;
        }
        else {
            cntWrongGuess++;
        }

        constructVisiableWord();
    }

    public void constructVisiableWord() {
        // TODO: construct visiable word
        // use "_" if
        visiableWord = "";

        for (char c: wordToGuess.toCharArray()) {
            if (guessedLetters.indexOf(c) != -1)
                visiableWord += c;
            else
                visiableWord += "*";
        }
    }

    public boolean isFinished() {
        // TODO: test if game is done
        if (cntWrongGuess < 6 && visiableWord.contains("*")) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isWon() {
        // TODO: test is finish is won
        if (isFinished() && visiableWord.contains("*"))
            return false;
        else if (isFinished() && cntWrongGuess <= 6)
            return true;

        // else
        return false;
    }


    public String getVisiableWord() {
        return visiableWord;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public int getCntWrongGuess() {
        return cntWrongGuess;
    }
}
