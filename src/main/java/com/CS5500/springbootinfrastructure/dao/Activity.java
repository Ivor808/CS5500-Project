package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "activity")
public class Activity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer act_id;

    //public for parsing
    private String act_type;
    private Timestamp startTime;
    private Timestamp endTime;

    @ElementCollection
    private List<String> trackPoints;


    @ManyToOne
    @JoinColumn(name = "f_type_id")
    private Type type;

    private String actGroup;
    private Boolean manual;
    private Float duration;
    private Float distance;
    private Integer steps;
    private Integer calories;

    public void setAct_id(Integer act_id) {
        this.act_id = act_id;
    }

    public List<String> getTrackPoints() {
        return trackPoints;
    }

    public void setTrackPoints(List<String> trackPoints) {
        this.trackPoints = trackPoints;
    }


    public Integer getAct_id() { return act_id; }

    public String getActGroup() {
        return actGroup;
    }

    public void setActGroup(String group) {
        this.actGroup = group;
    }

    public Boolean getManual() {
        return manual;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
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

    public String getAct_type() {
        return act_type;
    }

    public void setAct_type(String act_type) {
        this.act_type = act_type;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}


