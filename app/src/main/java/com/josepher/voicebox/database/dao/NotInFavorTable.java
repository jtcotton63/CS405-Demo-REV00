package com.josepher.voicebox.database.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.josepher.voicebox.database.dto.DTO_NotInFavor;

/**
 * Created by Josepher on 3/7/2016.
 */
public class NotInFavorTable {
    public static final String NOT_IN_FAVOR_TABLE_NAME = "not_in_favor";

    private static final String ID = "_id";
    private static final String USER_ID = "user_id";
    private static final String PROPOSAL_ID = "proposal_id";

    public static String createTableStatement() {
        StringBuilder sb = new StringBuilder();

        sb.append("create table ");
        sb.append(NOT_IN_FAVOR_TABLE_NAME);
        sb.append(" (");
        sb.append(ID);
        sb.append(" integer primary key autoincrement, ");
        sb.append(USER_ID);
        sb.append(" integer not null references ");
        sb.append(UserTable.USER_TABLE_NAME);
        sb.append("(");
        sb.append(UserTable.ID);
        sb.append("), ");
        sb.append(PROPOSAL_ID);
        sb.append(" integer not null references ");
        sb.append(ProposalTable.PROPOSAL_TABLE_NAME);
        sb.append("(");
        sb.append(ProposalTable.ID);
        sb.append("))");

        return sb.toString();
    }

    public static boolean delete(SQLiteDatabase db, DTO_NotInFavor notInFavor) {
        int affectedRows = db.delete(NOT_IN_FAVOR_TABLE_NAME, ID + "=" + notInFavor.id, null);
        return affectedRows == 1;
    }

    public static boolean insert(SQLiteDatabase db, DTO_NotInFavor notInFavor) {
        ContentValues data = composeContentValues(notInFavor);
        long insertedRowId = db.insert(NOT_IN_FAVOR_TABLE_NAME, null, data);
        return insertedRowId != -1;
    }

    public static boolean update(SQLiteDatabase db, DTO_NotInFavor notInFavor) {
        ContentValues data = composeContentValues(notInFavor);
        int affectedRows = db.update(NOT_IN_FAVOR_TABLE_NAME, data, ID + "=" + notInFavor.id, null);
        return affectedRows == 1;
    }

    private static ContentValues composeContentValues(DTO_NotInFavor notInFavor) {
        ContentValues data = new ContentValues();
        data.put(USER_ID, notInFavor.userId);
        data.put(PROPOSAL_ID, notInFavor.proposalId);
        return data;
    }
}
