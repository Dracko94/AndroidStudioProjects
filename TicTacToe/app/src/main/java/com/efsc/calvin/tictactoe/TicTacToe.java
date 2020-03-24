package com.efsc.calvin.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class TicTacToe extends AppCompatActivity implements OnClickListener {

    private Button slot_7;
    private Button slot_8;
    private Button slot_9;
    private Button slot_4;
    private Button slot_5;
    private Button slot_6;
    private Button slot_1;
    private Button slot_2;
    private Button slot_3;
    private TextView text_Game_Announce;
    private Button clear_Button;
    private SharedPreferences savedValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        clickEvent();

        slot_1 = (Button) findViewById(R.id.slot_1);
        slot_2 = (Button) findViewById(R.id.slot_2);
        slot_3 = (Button) findViewById(R.id.slot_3);
        slot_4 = (Button) findViewById(R.id.slot_4);
        slot_5 = (Button) findViewById(R.id.slot_5);
        slot_6 = (Button) findViewById(R.id.slot_6);
        slot_7 = (Button) findViewById(R.id.slot_7);
        slot_8 = (Button) findViewById(R.id.slot_8);
        slot_9 = (Button) findViewById(R.id.slot_9);
        text_Game_Announce = (TextView) findViewById(R.id.text_Game_Announce);
        clear_Button = (Button) findViewById(R.id.clear_button);

        slot_1.setOnClickListener(this);
        slot_2.setOnClickListener(this);
        slot_3.setOnClickListener(this);
        slot_4.setOnClickListener(this);
        slot_5.setOnClickListener(this);
        slot_6.setOnClickListener(this);
        slot_7.setOnClickListener(this);
        slot_8.setOnClickListener(this);
        slot_9.setOnClickListener(this);
        clear_Button.setOnClickListener(this);
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);

    }

    @Override
    public void onPause()
    {
        Editor editor = savedValues.edit();
        editor.putString()`````````````````````````````````````````````````````
        super.onPause();


    }

    public void clickEvent()
    {
        slot_1 = (Button)findViewById(R.id.slot_1);
        slot_2 = (Button)findViewById(R.id.slot_2);
        slot_3 = (Button)findViewById(R.id.slot_3);
        slot_4 = (Button)findViewById(R.id.slot_4);
        slot_5 = (Button)findViewById(R.id.slot_5);
        slot_6 = (Button)findViewById(R.id.slot_6);
        slot_7 = (Button)findViewById(R.id.slot_7);
        slot_8 = (Button)findViewById(R.id.slot_8);
        slot_9 = (Button)findViewById(R.id.slot_9);
        slot_1.setOnClickListener(new Click());
        slot_2.setOnClickListener(new Click());
        slot_3.setOnClickListener(new Click());
        slot_4.setOnClickListener(new Click());
        slot_5.setOnClickListener(new Click());
        slot_6.setOnClickListener(new Click());
        slot_7.setOnClickListener(new Click());
        slot_8.setOnClickListener(new Click());
        slot_9.setOnClickListener(new Click());
        clear_Button.setOnClickListener(new Click());
    }

    public void newGameButton()

    {
        slot_1.setText("");
        slot_2.setText("");
        slot_3.setText("");
        slot_4.setText("");
        slot_5.setText("");
        slot_6.setText("");
        slot_7.setText("");
        slot_8.setText("");
        slot_9.setText("");
        text_Game_Announce.setText("Player X");
        clear_Button=(Button)findViewById(R.id.clear_button);
    }

    public boolean winningConditions()

    {
        if(slot_1.getText().toString().equals("X") &&
           slot_2.getText().toString().equals("X") &&
           slot_3.getText().toString().equals("X"))

        {
            text_Game_Announce.setText("Player X Wins!");

            return true;
        }

        if(slot_4.getText().toString().equals("X") &&
                slot_5.getText().toString().equals("X") &&
                slot_6.getText().toString().equals("X"))

        {
            text_Game_Announce.setText("Player X Wins!");

            return true;
        }

        if(slot_7.getText().toString().equals("X") &&
                slot_8.getText().toString().equals("X") &&
                slot_9.getText().toString().equals("X"))

        {
            text_Game_Announce.setText("Player X Wins!");

            return true;
        }

        if(slot_1.getText().toString().equals("X") &&
                slot_4.getText().toString().equals("X") &&
                slot_7.getText().toString().equals("X"))

        {
            text_Game_Announce.setText("Player X Wins!");

            return true;
        }

        if(slot_2.getText().toString().equals("X") &&
                slot_5.getText().toString().equals("X") &&
                slot_8.getText().toString().equals("X"))

        {
            text_Game_Announce.setText("Player X Wins!");

            return true;
        }
        if(slot_3.getText().toString().equals("X") &&
                slot_6.getText().toString().equals("X") &&
                slot_9.getText().toString().equals("X"))

        {
            text_Game_Announce.setText("Player X Wins!");

            return true;
        }
        if(slot_1.getText().toString().equals("X") &&
                slot_5.getText().toString().equals("X") &&
                slot_9.getText().toString().equals("X"))

        {
            text_Game_Announce.setText("Player X Wins!");

            return true;
        }

        if(slot_7.getText().toString().equals("X") &&
                slot_5.getText().toString().equals("X") &&
                slot_3.getText().toString().equals("X"))

        {
            text_Game_Announce.setText("Player X Wins!");

            return true;
        }
        if(slot_1.getText().toString().equals("O") &&
                slot_2.getText().toString().equals("O") &&
                slot_3.getText().toString().equals("O"))

        {
            text_Game_Announce.setText("Player O Wins!");

            return true;
        }

        if(slot_4.getText().toString().equals("O") &&
                slot_5.getText().toString().equals("O") &&
                slot_6.getText().toString().equals("O"))

        {
            text_Game_Announce.setText("Player O Wins!");

            return true;
        }

        if(slot_7.getText().toString().equals("O") &&
                slot_8.getText().toString().equals("O") &&
                slot_9.getText().toString().equals("O"))

        {
            text_Game_Announce.setText("Player O Wins!");

            return true;
        }

        if(slot_1.getText().toString().equals("O") &&
                slot_4.getText().toString().equals("O") &&
                slot_7.getText().toString().equals("O"))

        {
            text_Game_Announce.setText("Player O Wins!");

            return true;
        }

        if(slot_2.getText().toString().equals("O") &&
                slot_5.getText().toString().equals("O") &&
                slot_8.getText().toString().equals("O"))

        {
            text_Game_Announce.setText("Player O Wins!");

            return true;
        }
        if(slot_3.getText().toString().equals("O") &&
                slot_6.getText().toString().equals("O") &&
                slot_9.getText().toString().equals("O"))

        {
            text_Game_Announce.setText("Player O Wins!");

            return true;
        }
        if(slot_1.getText().toString().equals("O") &&
                slot_5.getText().toString().equals("O") &&
                slot_9.getText().toString().equals("O"))

        {
            text_Game_Announce.setText("Player O Wins!");

            return true;
        }

        if(slot_7.getText().toString().equals("O") &&
                slot_5.getText().toString().equals("O") &&
                slot_3.getText().toString().equals("O"))

        {
            text_Game_Announce.setText("Player O Wins!");

            return true;
        }

        return false;
    }

    public void backupCheckConditions()

    {
        boolean flag;

        if(!slot_1.getText().toString().equals("") &&
                !slot_2.getText().toString().equals("") &&
                !slot_3.getText().toString().equals("") &&
                !slot_4.getText().toString().equals("") &&
                !slot_5.getText().toString().equals("") &&
                !slot_6.getText().toString().equals("") &&
                !slot_7.getText().toString().equals("") &&
                !slot_8.getText().toString().equals("") &&
                !slot_9.getText().toString().equals(""))

        {
            flag=winningConditions();

            if(!flag)

            {
                text_Game_Announce.setText("This is a tie!");
            }
        }
    }

    class Click implements OnClickListener

    {
        boolean flag;
        public void onClick(View c)

        {
            text_Game_Announce=(TextView)findViewById(R.id.text_Game_Announce);
            String game_Announce=text_Game_Announce.getText().toString();
            Button show=(Button)c;
            if (show.getText().toString().equals(""))

            {
                if (game_Announce.equals("Player X"))

                {
                    show.setText("X");
                    text_Game_Announce.setText("Player O");
                } else


                {
                    show.setText("O");
                    text_Game_Announce.setText("Player X");
                }

            }

            else

            {
                flag=winningConditions();
                if(!flag)
                {
                    backupCheckConditions();
                }
            }

        }
    }
}
