package com.efsc.calvin.playersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPlayer extends AppCompatActivity
{

    public EditText newPlayer;

    public EditText getPlayerAdd() {
        return newPlayer;
    }

    public void onClick(View v)
    {
     startActivity(new Intent(this, MainMenu.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
    }

}
