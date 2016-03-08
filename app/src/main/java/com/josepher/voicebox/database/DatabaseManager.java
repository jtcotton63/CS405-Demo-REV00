package com.josepher.voicebox.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.josepher.voicebox.database.dao.LocalityTable;
import com.josepher.voicebox.database.dao.UniversityTable;
import com.josepher.voicebox.database.dao.UserTable;
import com.josepher.voicebox.database.dto.DTO_Locality;
import com.josepher.voicebox.database.dto.DTO_University;
import com.josepher.voicebox.database.dto.DTO_User;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Josepher on 3/7/2016.
 */
public class DatabaseManager {

    private static DBHelper dbHelper;
    private static SQLiteDatabase db;

    private static void initialize(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        dbHelper.onCreate(db);
    }

    public static SQLiteDatabase getDB(Context context) {
        // Create the db
        if(db == null) {
            initialize(context);
        }

        return db;
    }

    public static void insertDummyData() {
        // THINGS TO FIX:
        // Localities officialId
        // University localityId
        // Users university / locality id
        // Jurisdiction of local leaders isn't stored as name "Provo City Councilman"
        // Proposals - localityId / universtiyId


        // Localities
        LocalityTable.insert(db, new DTO_Locality("City of Provo", "Provo", "Utah", "Utah"));
        LocalityTable.insert(db, new DTO_Locality("City of Orem", "Orem", "Utah", "Utah"));
        LocalityTable.insert(db, new DTO_Locality("City of American Fork", "American Fork", "Utah", "Utah"));
        LocalityTable.insert(db, new DTO_Locality("Utah County", null, "Utah", "Utah"));
        LocalityTable.insert(db, new DTO_Locality("State of Utah", null, null, "Utah"));
        LocalityTable.insert(db, new DTO_Locality("Converse County", null, "Converse", "Wyoming"));
        LocalityTable.insert(db, new DTO_Locality("State of Wyoming", null, null, "Wyoming"));
        LocalityTable.insert(db, new DTO_Locality("United States", null, null, null));

        int numRows = db.rawQuery("select * from " + LocalityTable.LOCALITY_TABLE_NAME, null).getCount();
        if(numRows != 8)
            throw new RuntimeException("Localities not inserted correctly");

        // Brigham Young University
        UniversityTable.insert(db, new DTO_University("Brigham Young University"));

        // People
        UserTable.insert(db, new DTO_User("paige", "paige", new Timestamp((new Date()).getTime()), "Egaipe", "Paige"));
        UserTable.insert(db, new DTO_User("pat", "pat", new Timestamp((new Date()).getTime()), "Tap", "Pat"));
        UserTable.insert(db, new DTO_User("oscar", "oscar", new Timestamp((new Date()).getTime()), "Racso", "Oscar"));
        UserTable.insert(db, new DTO_User("aaron", "aaron", new Timestamp((new Date()).getTime()), "Noraa", "Aaron"));
        UserTable.insert(db, new DTO_User("weston", "weston", new Timestamp((new Date()).getTime()), "Nostew", "Weston"));
        UserTable.insert(db, new DTO_User("braden", "braden", new Timestamp((new Date()).getTime()), "Nedarb", "Braden"));

        // Elected officials
        UserTable.insert(db, new DTO_User("peter", "peter", new Timestamp((new Date()).getTime()), "Retep", "Peter"));
        UserTable.insert(db, new DTO_User("oakley", "oakley", new Timestamp((new Date()).getTime()), "Egaipe", "Paige"));
        UserTable.insert(db, new DTO_User("ulysses", "ulysses", new Timestamp((new Date()).getTime()), "Sessylu", "Ulysses"));
        UserTable.insert(db, new DTO_User("winston", "winston", new Timestamp((new Date()).getTime()), "Notsniw", "Winston"));
        UserTable.insert(db, new DTO_User("fred", "fred", new Timestamp((new Date()).getTime()), "Derf", "Fred"));
        UserTable.insert(db, new DTO_User("brigham", "brigham", new Timestamp((new Date()).getTime()), "Mahgirb", "Brigham"));

        // Set the officialId for the localities
        Cursor peterId = db.rawQuery("select " + UserTable.ID + " from " + UserTable.USER_TABLE_NAME + " where " + UserTable.FIRST_NAME + "='peter'", null);

        // Propositions

    }
}
