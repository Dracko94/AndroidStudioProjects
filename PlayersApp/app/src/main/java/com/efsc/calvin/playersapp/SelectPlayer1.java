package com.efsc.calvin.playersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SelectPlayer1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player1);
    }
}

//database stuff
//    SQLiteDatabase db = this.getReadableDatabase();
//    Cursor c = db.rawQuery("SELECT column1,column2,column3 FROM table ", null);
//        if(c.moveToFirst()){
//                do{
//                //assing values
//                String column1 = c.getString(0);
//                String column2 = c.getString(1);
//                String column3 = c.getString(2);
//                //Do something Here with values
//
//               }while(c.moveToNext());
//                }
//               c.close();
//                db.close();

//also add to SELECTPLAYER 2