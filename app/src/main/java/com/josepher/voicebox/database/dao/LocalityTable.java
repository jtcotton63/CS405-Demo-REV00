package com.josepher.voicebox.database.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.josepher.voicebox.database.dto.DTO_Locality;

/**
 * Created by Josepher on 3/7/2016.
 */
public class LocalityTable {
    public static final String LOCALITY_TABLE_NAME = "locality";

    public static final String ID = "_id";
    private static final String NAME = "name";
    private static final String CITY = "city";
    private static final String COUNTY = "county";
    private static final String STATE = "state";
    private static final String OFFICIAL_ID = "official_id";

    public static String createTableStatement() {
        StringBuilder sb = new StringBuilder();

        sb.append("create table ");
        sb.append(LOCALITY_TABLE_NAME);
        sb.append(" (");
        sb.append(ID);
        sb.append(" integer primary key autoincrement, ");
        sb.append(NAME);
        sb.append(" text not null, ");
        sb.append(CITY);
        sb.append(" text, ");
        sb.append(COUNTY);
        sb.append(" text, ");
        sb.append(STATE);
        sb.append(" text, ");
        sb.append(OFFICIAL_ID);
        sb.append(" integer not null references ");
        sb.append(UserTable.USER_TABLE_NAME);
        sb.append("(");
        sb.append(UserTable.ID);
        sb.append("))");

        return sb.toString();
    }

    public static boolean delete(SQLiteDatabase db, DTO_Locality locality) {
        int affectedRows = db.delete(LOCALITY_TABLE_NAME, ID + "=" + locality.id, null);
        return affectedRows == 1;
    }

    public static boolean insert(SQLiteDatabase db, DTO_Locality locality) {
        ContentValues data = composeContentValues(locality);
        long insertedRowId = db.insert(LOCALITY_TABLE_NAME, null, data);
        return insertedRowId != -1;
    }

    public static boolean update(SQLiteDatabase db, DTO_Locality locality) {
        ContentValues data = composeContentValues(locality);
        int affectedRows = db.update(LOCALITY_TABLE_NAME, data, ID + "=" + locality.id, null);
        return affectedRows == 1;
    }

    private static ContentValues composeContentValues(DTO_Locality locality) {
        ContentValues data = new ContentValues();
        data.put(NAME, locality.name);
        data.put(CITY, locality.city);
        data.put(COUNTY, locality.county);
        data.put(STATE, locality.state);
        data.put(OFFICIAL_ID, locality.id);
        return data;
    }
}
