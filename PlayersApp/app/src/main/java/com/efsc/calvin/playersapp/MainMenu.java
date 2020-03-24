package com.efsc.calvin.playersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addplayer:
                Intent addIntent = new Intent(this, AddPlayer.class);
                startActivity(addIntent);
                break;

            case R.id.start:
                Intent gameIntent = new Intent(this, GameEmulator.class);
                startActivity(gameIntent);
                break;

            case R.id.score:
                Intent scoreIntent = new Intent(this, Scoreboard.class);
                startActivity(scoreIntent);
                break;

            case R.id.player1:
                Intent firstIntent = new Intent(this, SelectPlayer1.class);
                startActivity(firstIntent);
                break;

            case R.id.player2:
                Intent secondIntent = new Intent(this, SelectPlayer2.class);
                startActivity(secondIntent);
                break;
        }
    }
}

