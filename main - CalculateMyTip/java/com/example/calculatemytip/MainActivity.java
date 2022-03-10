package com.example.calculatemytip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fifteenButton();
        eighteenButton();
    }

    private void fifteenButton(){
        Button button15 = findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EditText bill = findViewById(R.id.editTextNumberDecimal);;
                TextView aiResponseText = findViewById(R.id.textView);
                String temp = bill.getText().toString();
                double billInt = Double.parseDouble(temp);
                double tipAmount = billInt*0.15;
                tipAmount = tipAmount * 100;
                int tempVar = (int) tipAmount;
                tipAmount = (double) tempVar/100;
                double total = billInt + tipAmount;
                aiResponseText.setText("Tip: $" + tipAmount + " Total: $" +total);
            }
        });
    }

    private void eighteenButton(){
        Button button18 = findViewById(R.id.button18);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EditText bill = findViewById(R.id.editTextNumberDecimal);;
                TextView aiResponseText = findViewById(R.id.textView);
                String temp = bill.getText().toString();
                double billInt = Double.parseDouble(temp);
                double tipAmount = billInt* 0.18;
                Log.d("Tag", Double.toString(tipAmount));
                tipAmount = tipAmount * 100;
                int tempVar = (int) tipAmount;
                tipAmount = (double) tempVar/100;
                double total = billInt + tipAmount;
                aiResponseText.setText("Tip: $" + tipAmount + " Total: $" +total);
            }
        });
    }
}