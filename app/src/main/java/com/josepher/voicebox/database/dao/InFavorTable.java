package com.josepher.voicebox.database.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.josepher.voicebox.database.dto.DTO_InFavor;

/**
 * Created by Josepher on 3/7/2016.
 */
public class InFavorTable {
    public static final String IN_FAVOR_TABLE_NAME = "in_favor";

    private static final String ID = "_id";
    private static final String USER_ID = "user_id";
    private static final String PROPOSAL_ID = "proposal_id";

    public static String createTableStatement() {
        StringBuilder sb = new StringBuilder();

        sb.append("create table ");
        sb.append(IN_FAVOR_TABLE_NAME);
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

    public static boolean delete(SQLiteDatabase db, DTO_InFavor inFavor) {
        int affectedRows = db.delete(IN_FAVOR_TABLE_NAME, ID + "=" + inFavor.id, null);
        return affectedRows == 1;
    }

    public static boolean insert(SQLiteDatabase db, DTO_InFavor inFavor) {
        ContentValues data = composeContentValues(inFavor);
        long insertedRowId = db.insert(IN_FAVOR_TABLE_NAME, null, data);
        return insertedRowId != -1;
    }

    public static boolean update(SQLiteDatabase db, DTO_InFavor inFavor) {
        ContentValues data = composeContentValues(inFavor);
        int affectedRows = db.update(IN_FAVOR_TABLE_NAME, data, ID + "=" + inFavor.id, null);
        return affectedRows == 1;
    }

    private static ContentValues composeContentValues(DTO_InFavor inFavor) {
        ContentValues data = new ContentValues();
        data.put(USER_ID, inFavor.userId);
        data.put(PROPOSAL_ID, inFavor.proposalId);
        return data;
    }
}
