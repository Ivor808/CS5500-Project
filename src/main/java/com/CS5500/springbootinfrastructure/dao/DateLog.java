package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "date_log")
public class DateLog {
    /*@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;*/

    @Id
    @Column(name = "date_of")
    public String date;

    public Summary[] summary;
    public Segment[] segments;
    public Integer caloriesIdle;



    public String lastUpdate; //change to Timestamp format later

    public void setLastUpdate(String lastUpdate) { //make String to Timestamp
        this.lastUpdate = lastUpdate;
    }

    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

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
