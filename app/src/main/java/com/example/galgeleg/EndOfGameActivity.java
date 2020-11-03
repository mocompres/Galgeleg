package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndOfGameActivity extends AppCompatActivity {

    Boolean isWon;
    String playerName;
    int points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_game);
        Intent i = getIntent();

        ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.mainlayer);
        TextView textView = findViewById(R.id.textView);

        playerName = i.getStringExtra("playerName");

        isWon = i.getBooleanExtra("hasWon", false);
        // has won
        if (isWon) {
            currentLayout.setBackgroundColor(Color.GREEN);
            points = i.getIntExtra("printObj", 0);
            textView.setText("Antal forsøg: " + Integer.toString(points));

        } else { // has lost
            currentLayout.setBackgroundColor(Color.RED);

            textView.setText("Du har tabt! \n Ordet var: " + i.getStringExtra("printObj"));

        }

    }

    public void viewHighScore(View v) {
        Intent intent = new Intent(this, HighScoreActivity.class);
        intent.putExtra("isWon", isWon);
        if (isWon) {
            intent.putExtra("playerName", playerName);
            intent.putExtra("score", points);
        }
        this.startActivity(intent);
    }


}