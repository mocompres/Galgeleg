package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity{

    Library lib;
    //static Galgelogik game = new Galgelogik();
    static HangmanController hGame;
    TextView textViewWordToDisplay;
    ImageView imageView;
    String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lib = new Library();
        hGame  = new HangmanController(lib.getRandomWord());
        //game.muligeOrd.clear();
        //game.muligeOrd.add("skovsnegl");

        //game.startNytSpil();
        hGame.startGame();

        imageView = findViewById(R.id.imageView);

        textViewWordToDisplay = findViewById(R.id.TxtViewVisibleWord);
        textViewWordToDisplay.setText("");

        viewStatusOnScreen();

        // Get player name for score list
        Intent i = getIntent();
        playerName = i.getStringExtra("playerName");

    }


    public void letterBTNPress(View v){
        Button btn = (Button) findViewById(v.getId());

        String text = btn.getText().toString().toLowerCase();

        //game.gætBogstav(text);
        hGame.guessLetter(text);

        viewStatusOnScreen();
        btn.setEnabled(false);

    }

    public void viewStatusOnScreen(){
        String visibleWord = hGame.getVisiableWord(); //= game.getSynligtOrd();

        textViewWordToDisplay.setText(visibleWord);

        int cntWrongLetters = hGame.getCntWrongGuess(); // game.getAntalForkerteBogstaver();
        if (cntWrongLetters != 0) {
            try {
                Field fieldToConvert = R.drawable.class.getDeclaredField("forkert" + Integer.toString(cntWrongLetters));
                imageView.setImageResource(fieldToConvert.getInt(fieldToConvert));
            } catch (Exception e) {
                imageView.setImageResource(R.drawable.galge);
            }

        } else {
            imageView.setImageResource(R.drawable.galge);
        }

        if (hGame.isFinished()) {

            Intent i = new Intent(this, EndOfGame.class);
            if (hGame.isWon()) {
                i.putExtra("printObj", hGame.getCntWrongGuess()); //game.getAntalForkerteBogstaver()
            }
            else {
                i.putExtra("printObj", hGame.getWordToGuess());
            }

            i.putExtra("hasWon", hGame.isWon()); //game.erSpilletVundet()
            i.putExtra("playerName", playerName);
            this.startActivity(i);

        }

    }
}