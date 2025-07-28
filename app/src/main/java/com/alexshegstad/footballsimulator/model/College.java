package com.alexshegstad.footballsimulator.model;

public class College {
    
    private int tid;
    private int cid;
    private int did;
    private String region;
    private String name;
    private String abbrev;
    private int pop;
    private String city;
    private String state;
    private double latitude;
    private double longitude;

    public College () {};

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrev() {
        return abbrev;
    }
}
