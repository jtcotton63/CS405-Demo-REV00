package com.josepher.voicebox.database.dto;

import java.sql.Timestamp;

/**
 * Created by Josepher on 3/7/2016.
 */
public class DTO_Proposal {
    public int id;
    public String summary;
    public String description;
    public String responsibleAgency;
    public double fundingAmount;
    public int creatorId;
    public Timestamp creationTime;
    public int localityId = -1;
    public int universityId = -1;

    public DTO_Proposal(String summary, String description, String responsibleAgency, double fundingAmount) {
        this.summary = summary;
        this.description = description;
        this.responsibleAgency = responsibleAgency;
        this.fundingAmount = fundingAmount;
    }
}
