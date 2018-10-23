package com.example.sparks.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView tips,joke,game,news,thoughts,horoscope;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tips=(CardView)findViewById(R.id.card1);
        joke=(CardView)findViewById(R.id.card2);
        game=(CardView)findViewById(R.id.card3);
        news=(CardView)findViewById(R.id.card4);
        thoughts=(CardView)findViewById(R.id.card5);
        horoscope=(CardView)findViewById(R.id.card6);

        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(MainActivity.this,Tips.class);

                startActivity(intent);
            }
        });

        joke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1=new Intent(MainActivity.this,Joke.class);

                startActivity(intent1);
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2=new Intent(MainActivity.this,Game.class);

                startActivity(intent2);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3=new Intent(MainActivity.this,News.class);

                startActivity(intent3);
            }
        });
        thoughts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent4=new Intent(MainActivity.this,Thoughts.class);

                startActivity(intent4);
            }
        });
        horoscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "horoscope", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
