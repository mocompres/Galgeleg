package com.example.galgeleg;

import java.util.ArrayList;

public interface IHighScoreData {
    void saveHighScoreList(ArrayList<Score> list);
    ArrayList<Score> getHighScoreList();
}
