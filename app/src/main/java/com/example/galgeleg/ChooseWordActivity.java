package com.example.galgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChooseWordActivity extends AppCompatActivity implements View.OnClickListener {

    private String playerName;
    Library lib;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseword);

        // Get info from last activity
        Intent i = getIntent();
        playerName = i.getStringExtra("playerName");

        // wordList
        lib = new Library();
        ArrayList<String> listofwords = lib.getListOfWords();

        // Adapter
        WordListAdapter wordListAdapter = new WordListAdapter(listofwords, this);

        // Listview
        ListView listView = findViewById(R.id.word_list_view);
        listView.setAdapter(wordListAdapter);

        // BTN
        Button startGameSelectBTN = findViewById(R.id.choose_word_btn);
        startGameSelectBTN.setOnClickListener(this);

        Button startGameRandomBTN = findViewById(R.id.choose_word_random);
        startGameRandomBTN.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String selectedWord = "";

        if (v.getId() == R.id.choose_word_btn) {

        } else {
            selectedWord = lib.getRandomWord();
        }

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("playerName", playerName);
        i.putExtra("wordToGuess", selectedWord);
        startActivity(i);
    }
}
