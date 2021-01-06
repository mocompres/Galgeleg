package com.example.galgeleg;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChooseWordActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private String playerName;
    Library lib;
    int selectedPosition = 1;
    ArrayList<String> listofwords;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseword);

        // Get info from last activity
        Intent i = getIntent();
        playerName = i.getStringExtra("playerName");

        // wordList
        lib = new Library();
        listofwords = lib.getListOfWords();

        // Adapter
        //WordListAdapter wordListAdapter = new WordListAdapter(listofwords, this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listofwords);

        // Listview
        ListView listView = findViewById(R.id.word_list_view);
        listView.setOnItemClickListener(this);
        //listView.setAdapter(wordListAdapter);
        listView.setAdapter(arrayAdapter);

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
            selectedWord = listofwords.get(selectedPosition);
        } else {
            selectedWord = lib.getRandomWord();
        }

        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("playerName", playerName);
        i.putExtra("wordToGuess", selectedWord);
        startActivity(i);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        selectedPosition = position;

        for (int j = 0; j < parent.getChildCount(); j++) {
            parent.getChildAt(j).setBackgroundColor(Color.WHITE);
            parent.getChildAt(j).setSelected(false);
        }

        //parent.getChildAt(position).setBackgroundColor(Color.GRAY);
        //parent.getChildAt(position).setSelected(true);
        System.out.println("Marking color at position" + position);
        view.setBackgroundColor(Color.GRAY);
        //view.setSelected(true);
    }
}
