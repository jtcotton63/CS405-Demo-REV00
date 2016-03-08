package com.josepher.voicebox.database.dto;

/**
 * Created by Josepher on 3/7/2016.
 */
public class DTO_Locality {
    public int id;
    public String name;
    public String city; // null if county, state, or federal locality
    public String county; // null if state or federal locality
    public String state; // null if federal locality
    public int officialId = -1; // User id of the official

    public DTO_Locality(String name, String city, String county, String state) {
        this.name = name;
        this.city = city;
        this.county = county;
        this.state = state;
    }
}
