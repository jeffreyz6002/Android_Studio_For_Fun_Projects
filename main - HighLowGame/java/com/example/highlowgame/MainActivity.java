package com.example.highlowgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int randomNum, tries = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNum = (int) Math.floor(Math.random()*101);
        TextView aiResponseText = findViewById(R.id.aiResponse);
        aiResponseText.setText("The random number is always between 0 and 100 (inclusive).");
        guessButton();
        newNumberButton();
    }

    private void newNumberButton(){
        Button newNumberButton = findViewById(R.id.button1);
        newNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                randomNum = (int) Math.floor(Math.random()*101);
                tries = 0;
            }
        });
    }

    private void guessButton(){
        Button guessButton = findViewById(R.id.button2);
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EditText guessNumber = findViewById(R.id.userGuess);
                String temp = guessNumber.getText().toString();
                int guessedNum = Integer.parseInt(temp);
                TextView aiResponseText = findViewById(R.id.aiResponse);
                if(guessedNum == randomNum){
                    aiResponseText.setText("You guessed correctly. Tries:"+ tries);
                }
                if(guessedNum < randomNum){
                    aiResponseText.setText("Your guess is too low. Tries:"+ ++tries);
                }
                if(guessedNum > randomNum){
                    aiResponseText.setText("Your guess is too high. Tries:"+ ++tries);
                }
            }
        });
    }
}