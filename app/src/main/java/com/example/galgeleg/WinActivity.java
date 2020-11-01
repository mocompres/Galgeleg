package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Intent i = getIntent();

        ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.mainlayer);
        TextView textView = findViewById(R.id.textView);

        currentLayout.setBackgroundColor(Color.GREEN);
        textView.setText("Antal forsøg: " + i.getIntExtra("printObj", 0));
    }


    public void playAgain(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);

    }
}