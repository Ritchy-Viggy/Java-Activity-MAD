package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
    }

    public void myButtonListenerMethod() {
        final Button button = (Button) findViewById(R.id.rollButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // Pang disable sa button during roll sa die
                button.setEnabled(false);

                // Mao ni ang pampatago sa text sa diceResult during sa pag roll
                TextView diceResult = (TextView) findViewById(R.id.diceResult);
                diceResult.setText("");

                // 3 Second Timer
                new CountDownTimer(3000, 100) {
                    Random rand = new Random();

                    @Override
                    public void onTick(long millisUntilFinished) {
                        // Mao ni ang naga randomize sa image during roll within 3 seconds
                        int tempResult = rand.nextInt(6) + 1;
                        updateDiceImage(tempResult);
                    }

                    @Override
                    public void onFinish() {
                        // Final Result after 3 seconds
                        int finalResult = rand.nextInt(6) + 1;
                        updateDiceUI(finalResult);
                        button.setEnabled(true);
                    }
                }.start();
            }
        });
    }

    // Conditions para ifinalize ang roll sa die
    private void updateDiceImage(int rollResult) {
        ImageView img = (ImageView) findViewById(R.id.diceImage);
        switch (rollResult) {
            case 1:
                img.setImageResource(R.drawable.dice1);
                break;
            case 2:
                img.setImageResource(R.drawable.dice2);
                break;
            case 3:
                img.setImageResource(R.drawable.dice3);
                break;
            case 4:
                img.setImageResource(R.drawable.dice4);
                break;
            case 5:
                img.setImageResource(R.drawable.dice5);
                break;
            case 6:
                img.setImageResource(R.drawable.dice6);
                break;
        }
    }

    // MAo ang maga display sa both diceResult ug rollResult
    private void updateDiceUI(int rollResult) {
        TextView diceResult = (TextView) findViewById(R.id.diceResult);
        diceResult.setText(Integer.toString(rollResult));
        updateDiceImage(rollResult);
    }
}