package com.efsc.calvin.playersapp;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class playerDB {
    public static final String DB_NAME = "players.db";
    public static final int DB_VERSION = 1;

    public static final String PLAYER_TABLE = "player";

    public static final String PLAYER_ID = "_id";
    public static final int PLAYER_ID_COL = 0;
    public static final String PLAYER_NAME = "name";
    public static final int PLAYER_NAME_COL = 1;
    public static final String PLAYER_WINS = "wins";
    public static final int PLAYER_WINS_COL = 2;
    public static final String PLAYER_LOSSES = "losses";
    public static final int PLAYER_LOSSES_COL = 3;
    public static final String PLAYER_TIES = "ties";
    public static final int PLAYER_TIES_COL = 4;

    public static final String CREATE_PLAYER_TABLE =
            "CREATE TABLE " + PLAYER_TABLE + " (" +
                    PLAYER_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PLAYER_NAME + "TEXT NOT NULL," +
                    PLAYER_WINS + "INTEGER, " +
                    PLAYER_LOSSES + "INTEGER, " +
                    PLAYER_TIES + "INTEGER);";

    public static final String DROP_PLAYER_TABLE =
            "DROP TABLE IF EXISTS " + PLAYER_TABLE;

    private static class DBHelper extends SQLiteOpenHelper
    {

        public DBHelper (Context context, String name, CursorFactory factory, int version)
        {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(CREATE_PLAYER_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.d("Player list", "Upgrading db from version " + oldVersion + "to " + newVersion);

            db.execSQL(playerDB.DROP_PLAYER_TABLE);
            onCreate(db);
        }
    }

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public playerDB(Context context)
    {
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
    }

    private void openReadableDB()
    {
        db = dbHelper.getReadableDatabase();
    }

    private void openWritableDB()
    {
        db = dbHelper.getWritableDatabase();
    }

    private void closeDB()
    {
        if (db != null)
            db.close();
    }
    public ArrayList<Players> getPlayers(String playerName)
    {
        String where =
                PLAYER_ID + "= ? AND " +
                PLAYER_NAME + "= ? AND " +
                PLAYER_WINS + " = ? AND " +
                PLAYER_LOSSES + " = ? AND " +
                PLAYER_TIES + " = ? AND ";

        int playerID = getPlayers(playerName).getId();
        String[] whereArgs = { Integer.toString(playerID) };

        this.openReadableDB();
        Cursor cursor = db.query(PLAYER_TABLE, null,
                where, whereArgs, null, null, null);
        ArrayList<Players> players = new ArrayList<Players>();
        while (cursor.moveToNext()) {
            players.add(getPlayersFromCursor(cursor));
        }
        if(cursor != null)
            cursor.close();
        this.closeDB();

        return players;
    }

    public Players getPlayers(int id) {
        String where = PLAYER_ID + "= ?";
        String[] whereArgs = { Integer.toString(id) };

        this.openReadableDB();
        Cursor cursor = db.query(PLAYER_TABLE,
                null, where, whereArgs, null, null, null);
        cursor.moveToFirst();
        Players players = getPlayersFromCursor(cursor);
        if(cursor != null)
            cursor.close();
        this.closeDB();

        return players;
    }

    private static Players getPlayersFromCursor(Cursor cursor) {
        if(cursor == null || cursor.getCount() == 0) {
            return null;
        }
        else {
            try {
                Players players = new Players(
                        cursor.getInt(PLAYER_ID_COL),
                        cursor.getString(PLAYER_NAME_COL),
                        cursor.getInt(PLAYER_WINS_COL),
                        cursor.getInt(PLAYER_LOSSES_COL),
                        cursor.getInt(PLAYER_TIES_COL));
                return players;
            }
            catch(Exception e) {
                return null;
            }

        }
    }

    public long insertPlayer(Players players) {
        ContentValues cv = new ContentValues();
        cv.put(PLAYER_ID, players.getID())
    }
}
