package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button startGameBTN = findViewById(R.id.startGameBTN);
        startGameBTN.setOnClickListener(this);

        Button highscoreBTN = findViewById(R.id.highscoreBTN);
        highscoreBTN.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.startGameBTN:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.highscoreBTN:
                // do stuff later;
                break;
            default:
                break;
        }
    }
}