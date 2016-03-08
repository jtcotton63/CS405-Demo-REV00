package com.josepher.voicebox.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.josepher.voicebox.database.dao.CommentTable;
import com.josepher.voicebox.database.dao.InFavorTable;
import com.josepher.voicebox.database.dao.LocalityTable;
import com.josepher.voicebox.database.dao.NotInFavorTable;
import com.josepher.voicebox.database.dao.ProposalTable;
import com.josepher.voicebox.database.dao.UniversityTable;
import com.josepher.voicebox.database.dao.UserTable;

/**
 * Created by Josepher on 3/7/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    // Database properties
    private static final String DB_NAME = "database.sqlite";
    private static final int VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("ONCREATE WAS CALLED");

        // Drop all tables
        db.execSQL("drop table if exists " + CommentTable.COMMENT_TABLE_NAME);
        db.execSQL("drop table if exists " + InFavorTable.IN_FAVOR_TABLE_NAME);
        db.execSQL("drop table if exists " + LocalityTable.LOCALITY_TABLE_NAME);
        db.execSQL("drop table if exists " + NotInFavorTable.NOT_IN_FAVOR_TABLE_NAME);
        db.execSQL("drop table if exists " + ProposalTable.PROPOSAL_TABLE_NAME);
        db.execSQL("drop table if exists " + UniversityTable.UNIVERSITY_TABLE_NAME);
        db.execSQL("drop table if exists " + UserTable.USER_TABLE_NAME);

        // Create tables
        db.execSQL(CommentTable.createTableStatement());
        db.execSQL(InFavorTable.createTableStatement());
        db.execSQL(LocalityTable.createTableStatement());
        db.execSQL(NotInFavorTable.createTableStatement());
        db.execSQL(ProposalTable.createTableStatement());
        db.execSQL(UniversityTable.createTableStatement());
        db.execSQL(UserTable.createTableStatement());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Intentionally left blank
    }
}
