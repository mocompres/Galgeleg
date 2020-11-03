package com.example.galgeleg;

import java.util.ArrayList;
import java.util.Collections;

public class HighscoreController {

    ArrayList<Score> highscoreList;

    public HighscoreController () {
        highscoreList = new ArrayList<Score>();

        highscoreList.add(new Score("Oliver", 5));

        highscoreList.add(new Score("Compres", 1));

        highscoreList.add(new Score("Poulsen", 3));

    }

    public void addScore(Score score) {
        highscoreList.add(score);
    }

    public Score getHighestScore() {

        return getHighScoreList().get(0);
    }

    public ArrayList<Score> getHighScoreList() {
        Collections.sort(highscoreList);
        return highscoreList;
    }
}
