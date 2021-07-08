package com.CS5500.springbootinfrastructure.helper;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

public class DateLog_helper {

    public String date;

    public Summary_helper[] summary;
    public Segment_helper[] segments;
    public Integer caloriesIdle;
    public String lastUpdate; //change to Timestamp format later

    public void setLastUpdate(String lastUpdate) { //make String to Timestamp
        this.lastUpdate = lastUpdate;
    }

    public String getDateOf() {
        return date;
    }

    public void setDateOf(String dateOf) {
        this.date = dateOf;
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
