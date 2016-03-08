package com.josepher.voicebox.database.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.josepher.voicebox.database.dto.DTO_Proposal;

/**
 * Created by Josepher on 3/7/2016.
 */
public class ProposalTable {
    public static final String PROPOSAL_TABLE_NAME = "proposal";

    public static final String ID = "_id";
    private static final String SUMMARY = "summary";
    private static final String DESCRIPTION = "description";
    private static final String RESPONSIBLE_AGENCY = "responsible_agency";
    private static final String FUNDING_AMOUNT = "funding_amount";
    private static final String CREATOR_ID = "creator_id";
    private static final String CREATION_TIME = "creation_time";
    private static final String LOCALITY_ID = "locality_id";
    private static final String UNIVERSITY_ID = "university_id";

    public static String createTableStatement() {
        StringBuilder sb = new StringBuilder();

        sb.append("create table ");
        sb.append(PROPOSAL_TABLE_NAME);
        sb.append(" (");
        sb.append(ID);
        sb.append(" integer primary key autoincrement, ");
        sb.append(SUMMARY);
        sb.append(" text not null, ");
        sb.append(DESCRIPTION);
        sb.append(" text, ");
        sb.append(RESPONSIBLE_AGENCY);
        sb.append(" text, ");
        sb.append(FUNDING_AMOUNT);
        sb.append(" real default 0.00, ");
        sb.append(CREATOR_ID);
        sb.append(" integer not null references ");
        sb.append(UserTable.USER_TABLE_NAME);
        sb.append("(");
        sb.append(UserTable.ID);
        sb.append("), ");
        sb.append(CREATION_TIME);
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

    public static boolean delete(SQLiteDatabase db, DTO_Proposal proposal) {
        int affectedRows = db.delete(PROPOSAL_TABLE_NAME, ID + "=" + proposal.id, null);
        return affectedRows == 1;
    }

    public static boolean insert(SQLiteDatabase db, DTO_Proposal proposal) {
        ContentValues data = composeContentValues(proposal);
        long insertedRowId = db.insert(PROPOSAL_TABLE_NAME, null, data);
        return insertedRowId != -1;
    }

    public static boolean update(SQLiteDatabase db, DTO_Proposal proposal) {
        ContentValues data = composeContentValues(proposal);
        int affectedRows = db.update(PROPOSAL_TABLE_NAME, data, ID + "=" + proposal.id, null);
        return affectedRows == 1;
    }

    private static ContentValues composeContentValues(DTO_Proposal proposal) {
        ContentValues data = new ContentValues();
        data.put(SUMMARY, proposal.summary);
        data.put(DESCRIPTION, proposal.description);
        data.put(RESPONSIBLE_AGENCY, proposal.responsibleAgency);
        data.put(FUNDING_AMOUNT, proposal.fundingAmount);
        data.put(CREATOR_ID, proposal.creatorId);
        // The creationTime must be stored as a string
        data.put(CREATION_TIME, Long.toString(proposal.creationTime.getTime()));
        data.put(LOCALITY_ID, proposal.localityId);
        data.put(UNIVERSITY_ID, proposal.universityId);
        return data;
    }
}
