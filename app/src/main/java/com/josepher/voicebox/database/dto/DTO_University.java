package com.josepher.voicebox.database.dto;

/**
 * Created by Josepher on 3/7/2016.
 */
public class DTO_University {
    public int id;
    public String name;
    public int localityId = -1;
    public int officialId = -1;

    public DTO_University(String name) {
        this.name = name;
    }
}
