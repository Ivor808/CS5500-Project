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
    private Date date;

    private Integer caloriesIdle;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_seg_id")
    private Segment segment;

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }



    private Timestamp lastUpdate;

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public Date getDate() {
        return date;
    }

    public void setDate(Date dateOf) {
        this.date = dateOf;
    }

    public Integer getCaloriesIdle() {
        return caloriesIdle;
    }

    public void setCaloriesIdle(Integer caloriesIdle) {
        this.caloriesIdle = caloriesIdle;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void timestampLastUpdate() {
        this.lastUpdate = new Timestamp(System.currentTimeMillis());
    }
}
