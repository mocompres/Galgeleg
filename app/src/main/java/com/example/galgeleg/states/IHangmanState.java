package com.example.galgeleg.states;

public interface IHangmanState {
    void startGame();
    void guessLetter(String letter);
    boolean isFinished();
    boolean isWon();
}
