package com.example.galgeleg.states;

public class HangmanRunning implements IHangmanState {

    HangmanLogic game;

    HangmanRunning(HangmanLogic game) {
        this.game = game;
    }

    @Override
    public void startGame() {

    }

    @Override
    public void guessLetter(String letter) {
        if (this.game.wordToGuess.contains(letter)) {
            this.game.guessedLetters += letter;
        }
        else {
            this.game.cntWrongGuess++;
        }

        this.game.constructVisiableWord();

        if (this.game.cntWrongGuess < 6 && this.game.visiableWord.contains("*")) {
            // game not finished
        } else {
            this.game.changeState(new HangmanFinished(this.game));
        }


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
