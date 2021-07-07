package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@DiscriminatorValue("3")
public class Activity {
    private Integer act_id;
    //public for parsing
    public String activity;
    public String startTime;
    public String endTime;
    public String[] trackPoints;
    private String group;
    private Boolean manual;
    private SimpleDateFormat start_time;
    private SimpleDateFormat end_time;
    private Float duration;
    private Float distance;
    private Integer steps;
    private Integer calories;
    private Date last_update;

    public void setAct_id(Integer act_id) {
        this.act_id = act_id;
    }

    @Id
    public Integer getAct_id() { return act_id; }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Boolean getManual() {
        return manual;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
    }

    public SimpleDateFormat getStart_time() {
        return start_time;
    }

    public void setStart_time(SimpleDateFormat start_time) {
        this.start_time = start_time;
    }

    public SimpleDateFormat getEnd_time() {
        return end_time;
    }

    public void setEnd_time(SimpleDateFormat end_time) {
        this.end_time = end_time;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}


