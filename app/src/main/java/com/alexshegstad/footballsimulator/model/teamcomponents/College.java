package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class College {
    
    @JsonProperty("tid")
    private int tid;
    
    @JsonProperty("cid")
    private int cid;
    
    @JsonProperty("did")
    private int did;
    
    @JsonProperty("region")
    private String region;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("abbrev")
    private String abbrev;
    
    @JsonProperty("pop")
    private int pop;
    
    @JsonProperty("city")
    private String city;
    
    @JsonProperty("state")
    private String state;
    
    @JsonProperty("latitude")
    private double latitude;
    
    @JsonProperty("longitude")
    private double longitude;

    public College() {
        // Default constructor for Jackson
    }

    // Constructor for creating test colleges
    public College(String region, String name, String abbrev, String city, String state) {
        this.region = region;
        this.name = name;
        this.abbrev = abbrev;
        this.city = city;
        this.state = state;
    }

    // All your existing getters and setters (unchanged)
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

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Get the full college name (region + name)
     */
    public String getFullName() {
        if (region != null && name != null) {
            return region + " " + name;
        } else if (region != null) {
            return region;
        } else if (name != null) {
            return name;
        } else {
            return "Unknown College";
        }
    }

    /**
     * Get location as "City, State"
     */
    public String getLocation() {
        if (city != null && state != null) {
            return city + ", " + state;
        } else if (city != null) {
            return city;
        } else if (state != null) {
            return state;
        } else {
            return "Unknown Location";
        }
    }

    @Override
    public String toString() {
        return "College{" +
                "region='" + region + '\'' +
                ", name='" + name + '\'' +
                ", abbrev='" + abbrev + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", coordinates={" + longitude + ", " + latitude + "}" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        College college = (College) o;
        return tid == college.tid &&
                Objects.equals(region, college.region) &&
                Objects.equals(name, college.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, region, name);
    }
}
