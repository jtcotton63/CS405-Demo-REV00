package com.josepher.voicebox.database.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.josepher.voicebox.database.dto.DTO_University;

/**
 * Created by Josepher on 3/7/2016.
 */
public class UniversityTable {
    public static final String UNIVERSITY_TABLE_NAME = "university";

    public static final String ID = "_id";
    private static final String NAME = "name";
    private static final String LOCALITY_ID = "locality_id";
    private static final String OFFICIAL_ID = "official_id";

    public static String createTableStatement() {
        StringBuilder sb = new StringBuilder();

        sb.append("create table ");
        sb.append(UNIVERSITY_TABLE_NAME);
        sb.append(" (");
        sb.append(ID);
        sb.append(" integer primary key autoincrement, ");
        sb.append(NAME);
        sb.append(" text not null, ");
        sb.append(LOCALITY_ID);
        sb.append(" integer references ");
        sb.append(LocalityTable.LOCALITY_TABLE_NAME);
        sb.append("(");
        sb.append(LocalityTable.ID);
        sb.append("), ");
        sb.append(OFFICIAL_ID);
        sb.append(" integer not null references ");
        sb.append(UserTable.USER_TABLE_NAME);
        sb.append("(");
        sb.append(UserTable.ID);
        sb.append("))");

        return sb.toString();
    }

    public static boolean delete(SQLiteDatabase db, DTO_University university) {
        int affectedRows = db.delete(UNIVERSITY_TABLE_NAME, ID + "=" + university.id, null);
        return affectedRows == 1;
    }

    public static boolean insert(SQLiteDatabase db, DTO_University university) {
        ContentValues data = composeContentValues(university);
        long insertedRowId = db.insert(UNIVERSITY_TABLE_NAME, null, data);
        return insertedRowId != -1;
    }

    public static boolean update(SQLiteDatabase db, DTO_University university) {
        ContentValues data = composeContentValues(university);
        int affectedRows = db.update(UNIVERSITY_TABLE_NAME, data, ID + "=" + university.id, null);
        return affectedRows == 1;
    }

    private static ContentValues composeContentValues(DTO_University university) {
        ContentValues data = new ContentValues();
        data.put(NAME, university.name);
        data.put(LOCALITY_ID, university.localityId);
        data.put(OFFICIAL_ID, university.officialId);
        return data;
    }
}
