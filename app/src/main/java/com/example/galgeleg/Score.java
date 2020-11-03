package com.example.galgeleg;

public class Score implements Comparable<Score>    {

private String name = "";
private int points = 0;

public Score(String name, int score) {
        this.name = name;
        this.points = score;
        }

@Override
public int compareTo(Score score) {
        return this.points-score.getPoints();
        }

public int getPoints() {
        return points;
        }

public String getName() {
        return name;
        }

        }
