package com.CS5500.springbootinfrastructure.helper;

public class DateLog_helper {

    public String date;

    public Summary_helper[] summary;
    // public Segment_helper[] segments;
    public Integer caloriesIdle;
    public String lastUpdate; //change to Timestamp format later

    public Segment_helper getSegments() {
        return segments;
    }

    public void setSegments(Segment_helper segments) {
        this.segments = segments;
    }

    public Summary_helper[] getSummary() {
        return summary;
    }

    public void setSummary(Summary_helper[] summary) {
        this.summary = summary;
    }

    public Segment_helper segments;

    public void setLastUpdate(String lastUpdate) { //make String to Timestamp
        this.lastUpdate = lastUpdate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCaloriesIdle() {
        return caloriesIdle;
    }

    public void setCaloriesIdle(Integer caloriesIdle) {
        this.caloriesIdle = caloriesIdle;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void timestampLastUpdate() {
        this.lastUpdate = lastUpdate;//new Timestamp(System.currentTimeMillis());
    }
}
