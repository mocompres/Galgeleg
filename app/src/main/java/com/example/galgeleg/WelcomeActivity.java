package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText playerName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button startGameBTN = findViewById(R.id.startGameBTN);
        startGameBTN.setOnClickListener(this);

        Button highscoreBTN = findViewById(R.id.highscoreBTN);
        highscoreBTN.setOnClickListener(this);

        playerName = findViewById(R.id.nameEditText);

    }

    @Override
    public void onClick(View view)
    {
        Intent i;

        switch (view.getId()) {
            case R.id.startGameBTN:
                i = new Intent(this, MainActivity.class);
                i.putExtra("playerName", playerName.getText().toString());
                startActivity(i);
                break;
            case R.id.highscoreBTN:
                // do stuff later;
                i = new Intent(this, HighScoreActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}