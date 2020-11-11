package com.kocsisdavid.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView diceImage;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImage = findViewById(R.id.dice_image);

        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateDice();
            }
        });
    }

    private void rotateDice() {
        int i = random.nextInt(6)+1;
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        diceImage.startAnimation(animation);
        switch (i){
            case 1:
                diceImage.setImageResource(R.drawable.dice1);
                break;

            case 2:
                diceImage.setImageResource(R.drawable.dice2);
                break;

            case 3:
                diceImage.setImageResource(R.drawable.dice3);
                break;

            case 4:
                diceImage.setImageResource(R.drawable.dice4);
                break;

            case 5:
                diceImage.setImageResource(R.drawable.dice5);
                break;

            case 6:
                diceImage.setImageResource(R.drawable.dice6);
                break;
        }
    }
}