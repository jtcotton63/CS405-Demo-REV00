package com.josepher.voicebox;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.josepher.voicebox.database.DBHelper;
import com.josepher.voicebox.database.DatabaseManager;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize database
        SQLiteDatabase db = DatabaseManager.getDB(this);
        DatabaseManager.insertDummyData();
        int temjp = -1;

        // Continue
        setContentView(R.layout.activity_login);
    }
}
