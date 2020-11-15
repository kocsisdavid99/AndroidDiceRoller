package com.kocsisdavid.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.seismic.ShakeDetector;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener {

    ImageView diceImage;
    TextView rolledNumber;
    Random random = new Random();
    Context context = this;
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager)
                getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);

        diceImage = findViewById(R.id.dice_image);
        rolledNumber = findViewById(R.id.rolled_number);

        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playRollSound(mp);
                rotateDice();
            }
        });
    }

    @Override public void hearShake() {
        playRollSound(mp);
        rotateDice();
    }

    private void rotateDice() {
        int i = random.nextInt(6)+1;
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        diceImage.startAnimation(animation);
        switch (i){
            case 1:
                diceImage.setImageResource(R.drawable.dice1);
                setRolledNumber(i);
                break;

            case 2:
                diceImage.setImageResource(R.drawable.dice2);
                setRolledNumber(i);
                break;

            case 3:
                diceImage.setImageResource(R.drawable.dice3);
                setRolledNumber(i);
                break;

            case 4:
                diceImage.setImageResource(R.drawable.dice4);
                setRolledNumber(i);
                break;

            case 5:
                diceImage.setImageResource(R.drawable.dice5);
                setRolledNumber(i);
                break;

            case 6:
                diceImage.setImageResource(R.drawable.dice6);
                setRolledNumber(i);
                break;
        }
    }

    private void setRolledNumber (int i){
        rolledNumber.setText(Integer.toString(i));
    }

    private void playRollSound (MediaPlayer mp){
        mp = MediaPlayer.create(context, R.raw.roll);
        mp.start();
    }
}