package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity{

    static Button[] letterBTN = new Button[29];
    //static Galgelogik game = new Galgelogik();
    static HangmanController hGame = new HangmanController();
    TextView textViewWordToDisplay;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadBTN();

        //game.muligeOrd.clear();
        //game.muligeOrd.add("skovsnegl");

        //game.startNytSpil();
        hGame.startGame();

        imageView = findViewById(R.id.imageView);

        textViewWordToDisplay = findViewById(R.id.TxtViewVisibleWord);
        textViewWordToDisplay.setText("");

        viewStatusOnScreen();

    }

    public void loadBTN() {
        // stuff to reload the game
        letterBTN[0] = findViewById(R.id.buttonA);
        letterBTN[1] = findViewById(R.id.buttonB);
        letterBTN[2] = findViewById(R.id.buttonC);
        letterBTN[3] = findViewById(R.id.buttonD);
        letterBTN[4] = findViewById(R.id.buttonE);
        letterBTN[5] = findViewById(R.id.buttonF);
        letterBTN[6] = findViewById(R.id.buttonG);
        letterBTN[7] = findViewById(R.id.buttonH);
        letterBTN[8] = findViewById(R.id.buttonI);
        letterBTN[9] = findViewById(R.id.buttonJ);
        letterBTN[10] = findViewById(R.id.buttonK);
        letterBTN[11] = findViewById(R.id.buttonL);
        letterBTN[12] = findViewById(R.id.buttonM);
        letterBTN[13] = findViewById(R.id.buttonN);
        letterBTN[14] = findViewById(R.id.buttonO);
        letterBTN[15] = findViewById(R.id.buttonP);
        letterBTN[16] = findViewById(R.id.buttonQ);
        letterBTN[17] = findViewById(R.id.buttonR);
        letterBTN[18] = findViewById(R.id.buttonS);
        letterBTN[19] = findViewById(R.id.buttonT);
        letterBTN[20] = findViewById(R.id.buttonU);
        letterBTN[21] = findViewById(R.id.buttonV);
        letterBTN[22] = findViewById(R.id.buttonW);
        letterBTN[23] = findViewById(R.id.buttonX);
        letterBTN[24] = findViewById(R.id.buttonY);
        letterBTN[25] = findViewById(R.id.buttonZ);
        letterBTN[26] = findViewById(R.id.buttonAE);
        letterBTN[27] = findViewById(R.id.buttonOE);
        letterBTN[28] = findViewById(R.id.buttonAA);

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

        //if (game.erSpilletSlut()) {
        if (hGame.isFinished()) {
            //  if (game.erSpilletVundet()) {
            if (hGame.isWon()) {
                // The game has been won
                Intent i = new Intent(this, WinActivity.class);
                i.putExtra("hasWon", hGame.isWon()); //game.erSpilletVundet()
                i.putExtra("printObj", hGame.getCntWrongGuess()); //game.getAntalForkerteBogstaver()
                this.startActivity(i);
            } else { //if (game.erSpilletTabt()) {
                // The game has been lost
                Intent i = new Intent(this, LostActivity.class);
                i.putExtra("hasWon", hGame.isWon()); // game.erSpilletVundet()
                i.putExtra("printObj", hGame.getWordToGuess()); //game.getOrdet()
                this.startActivity(i);

                this.startActivity(i);
            }

        }

    }
}