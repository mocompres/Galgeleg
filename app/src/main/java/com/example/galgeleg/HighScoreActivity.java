package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity implements View.OnClickListener   {

    // RecyclerView stuff
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    // HighScore stuff
    private HighscoreController highscore;

    private Button playAgainBTN;
    private Button menuBTN;
    private String playername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        IHighScoreData data = new SharedPrefData(this);
        highscore = new HighscoreController(data);

        //highscore.setHighscoreList(getHighScoreList());



        Intent intent = getIntent();
        playername = intent.getStringExtra("playerName");

        if(intent.getBooleanExtra("isWon", false)) {

            int point = intent.getIntExtra("score",0);

            highscore.addScore(new Score(playername, point));
        }

       // saveHighScoreList(highscore.getHighScoreList());

        playAgainBTN = findViewById(R.id.playAgainBTN);
        playAgainBTN.setOnClickListener(this);

        menuBTN = findViewById(R.id.menuBTN);
        menuBTN.setOnClickListener(this);
        // use a linear layout manager
        initRecyclerView();


    }

    void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.highscorelist);

        // specify an adapter (see also next example)
        mAdapter = new HighScoreAdapter(highscore.getHighScoreList(), this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.playAgainBTN:
                i = new Intent(this, ChooseWordActivity.class);
                i.putExtra("playerName", playername);
                startActivity(i);
                break;
            case R.id.menuBTN:
                i = new Intent(this, WelcomeActivity.class);
                startActivity(i);
                break;
        }
    }
}