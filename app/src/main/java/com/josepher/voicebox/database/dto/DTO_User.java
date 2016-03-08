package com.josepher.voicebox.database.dto;

import java.sql.Timestamp;

/**
 * Created by Josepher on 3/7/2016.
 */
public class DTO_User {
    public int id;
    public String username;
    public String password;
    public Timestamp joinedDate;
    public String lastName;
    public String firstName;
    public int locality_id = -1;
    public int university_id = -1;

    public DTO_User(String username, String password, Timestamp joinedDate, String lastName, String firstName) {
        this.username = username;
        this.password = password;
        this.joinedDate = joinedDate;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
