package com.example.galgeleg.states;

public class HangmanFinished implements IHangmanState {

    HangmanLogic game;

    HangmanFinished(HangmanLogic game) {
        this.game = game;
    }

    @Override
    public void startGame() {

    }

    @Override
    public void guessLetter(String letter) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean isWon() {
        if (this.game.visiableWord.contains("*"))
            return false;
        else if (this.game.cntWrongGuess <= 6)
            return true;

        return false;
    }

}
