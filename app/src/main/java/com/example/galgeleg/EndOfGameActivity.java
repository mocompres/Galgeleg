package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

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

        // sound init
        MediaPlayer mpLoser = MediaPlayer.create(this,R.raw.loser);
        MediaPlayer mpWinner = MediaPlayer.create(this,R.raw.winner);

        // animation from 3. party lib
        LottieAnimationView animationView = findViewById(R.id.animationView);


        // has won
        if (isWon) {
            currentLayout.setBackgroundColor(Color.GREEN); // color
            mpWinner.start(); // sound play
            animationView.setAnimation(R.raw.winner_animation); // animation
            points = i.getIntExtra("printObj", 0);
            textView.setText("Antal forsøg: " + Integer.toString(points)); // print

        } else { // has lost
            currentLayout.setBackgroundColor(Color.RED); // color
            mpLoser.start(); // sound play
            animationView.setAnimation(R.raw.loser_animation); // animation
            textView.setText("Du har tabt! \n Ordet var: " + i.getStringExtra("printObj")); // print

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