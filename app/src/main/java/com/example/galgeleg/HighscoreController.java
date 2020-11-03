package com.example.galgeleg;

import java.util.ArrayList;
import java.util.Collections;

public class HighscoreController {

    ArrayList<Score> highscoreList;
    IHighScoreData data;

    public HighscoreController (IHighScoreData highScoreData) {
        highscoreList = new ArrayList<Score>();

        highscoreList.add(new Score("Oliver", 5));

        highscoreList.add(new Score("Compres", 1));

        highscoreList.add(new Score("Poulsen", 3));

        this.data = highScoreData;

        highscoreList = data.getHighScoreList();


    }

    public void addScore(Score score) {
        highscoreList.add(score);
        data.saveHighScoreList(highscoreList);

    }

    public Score getHighestScore() {

        return getHighScoreList().get(0);
    }

    public void setHighscoreList(ArrayList<Score> highscoreList) {
        this.highscoreList = highscoreList;
    }

    public ArrayList<Score> getHighScoreList() {
        Collections.sort(highscoreList);
        return highscoreList;
    }
}
