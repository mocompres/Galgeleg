package com.example.galgeleg.states;

public class HangmanInitial implements IHangmanState {

    HangmanLogic game;

    HangmanInitial(HangmanLogic game) {
        this.game = game;
    }

    @Override
    public void startGame() {
        this.game.constructVisiableWord();
        this.game.changeState(new HangmanRunning(this.game));
    }

    @Override
    public void guessLetter(String letter) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isWon() {
        return false;
    }


}
