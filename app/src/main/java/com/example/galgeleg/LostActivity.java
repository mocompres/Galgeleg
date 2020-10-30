package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class LostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);

        Intent i = getIntent();

        ConstraintLayout currentLayout = (ConstraintLayout) findViewById(R.id.mainlayer);
        TextView textView = findViewById(R.id.textView);

        currentLayout.setBackgroundColor(Color.RED);
        textView.setText( "Du har tabt! \n Ordet var: " + i.getStringExtra("printObj"));

        }
}