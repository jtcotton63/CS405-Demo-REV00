package com.josepher.voicebox.database.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.josepher.voicebox.database.dto.DTO_User;

import java.util.List;

/**
 * Created by Josepher on 3/7/2016.
 */
public class UserTable {
    public static final String USER_TABLE_NAME = "user";

    // Columns
    public static final String ID = "_id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String JOINED_DATE = "joined_date";
    private static final String LAST_NAME = "last_name";
    public static final String FIRST_NAME = "first_name";
    private static final String LOCALITY_ID = "locality_id";
    private static final String UNIVERSITY_ID = "university_id";

    public static String createTableStatement() {
        StringBuilder sb = new StringBuilder();

        sb.append("create table ");
        sb.append(USER_TABLE_NAME);
        sb.append(" (");
        sb.append(ID);
        sb.append(" integer primary key autoincrement, ");
        sb.append(USERNAME);
        sb.append(" text not null unique, ");
        sb.append(PASSWORD);
        sb.append(" text not null, ");
        sb.append(JOINED_DATE);
        sb.append(" text not null, ");
        sb.append(LAST_NAME);
        sb.append(" text not null, ");
        sb.append(FIRST_NAME);
        sb.append(" text not null, ");
        sb.append(LOCALITY_ID);
        sb.append(" integer references ");
        sb.append(LocalityTable.LOCALITY_TABLE_NAME);
        sb.append("(");
        sb.append(LocalityTable.ID);
        sb.append("), ");
        sb.append(UNIVERSITY_ID);
        sb.append(" integer references ");
        sb.append(UniversityTable.UNIVERSITY_TABLE_NAME);
        sb.append("(");
        sb.append(UniversityTable.ID);
        sb.append("))");

        return sb.toString();
    }

    public static boolean delete(SQLiteDatabase db, DTO_User user) {
        int affectedRows = db.delete(USER_TABLE_NAME, ID + "=" + user.id, null);
        return affectedRows == 1;
    }

    public static boolean insert(SQLiteDatabase db, DTO_User user) {
        ContentValues data = composeContentValues(user);
        long insertedRowId = db.insert(USER_TABLE_NAME, null, data);
        return insertedRowId != -1;
    }

    public static boolean update(SQLiteDatabase db, DTO_User user) {
        ContentValues data = composeContentValues(user);
        int affectedRows = db.update(USER_TABLE_NAME, data, ID + "=" + user.id, null);
        return affectedRows == 1;
    }

    private static ContentValues composeContentValues(DTO_User user) {
        ContentValues data = new ContentValues();
        data.put(USERNAME, user.username);
        data.put(PASSWORD, user.password);
        // joinedDate is stored as a string
        data.put(JOINED_DATE, Long.toString(user.joinedDate.getTime()));
        data.put(LAST_NAME, user.lastName);
        data.put(FIRST_NAME, user.firstName);
        data.put(LOCALITY_ID, user.locality_id);
        data.put(UNIVERSITY_ID, user.university_id);
        return data;
    }
}
