package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class EndOfGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_of_game);
        Intent i = getIntent();

        ConstraintLayout currentLayout =
                (ConstraintLayout) findViewById(R.id.mainlayer);
        TextView textView = findViewById(R.id.textView);

        // has won
        if (i.getBooleanExtra("hasWon", false)) {
            currentLayout.setBackgroundColor(Color.GREEN);
            textView.setText("Antal forsøg: " + i.getIntExtra("printObj", 0));
        } else { // has lost
            currentLayout.setBackgroundColor(Color.RED);
            textView.setText("Du har tabt! \n Ordet var: " + i.getStringExtra("printObj"));

        }

    }


}