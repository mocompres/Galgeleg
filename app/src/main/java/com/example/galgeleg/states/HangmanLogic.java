package com.example.galgeleg.states;

import com.example.galgeleg.HangmanController;

public class HangmanLogic {

    private IHangmanState state;
    String visiableWord;
    String wordToGuess;
    String guessedLetters;
    int cntWrongGuess;

    public HangmanLogic(String word) {
        //HangmanController logic = new HangmanController("test");
        visiableWord = "";
        wordToGuess = word;
        cntWrongGuess = 0;
        guessedLetters = "";

        this.state = new HangmanInitial(this);
        this.state.startGame();
    }


    void changeState(IHangmanState state) {
        this.state = state;
    }

    public void guessLetter(String letter) {
        // TODO: check if letter is correct or not
        this.state.guessLetter(letter);
    }

    public void constructVisiableWord() {
        visiableWord = "";

        for (char c: wordToGuess.toCharArray()) {
            if (guessedLetters.indexOf(c) != -1)
                visiableWord += c;
            else
                visiableWord += "*";
        }
    }

    public boolean isFinished() {
        return this.state.isFinished();
    }

    public boolean isWon() {
        return this.state.isWon();
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
