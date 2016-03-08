package com.josepher.voicebox.database.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.josepher.voicebox.database.dto.DTO_Comment;

/**
 * Created by Josepher on 3/7/2016.
 */
public class CommentTable {
    public static final String COMMENT_TABLE_NAME = "comment";

    // Columns
    private static final String ID = "_id";
    private static final String PROPOSAL_ID = "proposal_id";
    private static final String TEXT = "text";

    public static String createTableStatement() {
        StringBuilder sb = new StringBuilder();

        sb.append("create table ");
        sb.append(COMMENT_TABLE_NAME);
        sb.append(" (");
        sb.append(ID);
        sb.append(" integer primary key autoincrement, ");
        sb.append(PROPOSAL_ID);
        sb.append(" integer not null, ");
        sb.append(TEXT);
        sb.append(" text not null)");

        return sb.toString();
    }

    public static boolean delete(SQLiteDatabase db, DTO_Comment comment) {
        int affectedRows = db.delete(COMMENT_TABLE_NAME, ID + "=" + comment.id, null);
        return affectedRows == 1;
    }

    public static boolean insert(SQLiteDatabase db, DTO_Comment comment) {
        ContentValues data = composeContentValues(comment);
        long insertedRowId = db.insert(COMMENT_TABLE_NAME, null, data);
        return insertedRowId != -1;
    }

    public static boolean update(SQLiteDatabase db, DTO_Comment comment) {
        ContentValues data = composeContentValues(comment);
        int affectedRows = db.update(COMMENT_TABLE_NAME, data, ID + "=" + comment.id, null);
        return affectedRows == 1;
    }

    private static ContentValues composeContentValues(DTO_Comment comment) {
        ContentValues data = new ContentValues();
        data.put(PROPOSAL_ID, comment.proposal_id);
        data.put(TEXT, comment.text);
        return data;
    }
}
