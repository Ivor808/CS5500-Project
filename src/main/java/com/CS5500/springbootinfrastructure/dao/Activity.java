package com.CS5500.springbootinfrastructure.dao;

import com.CS5500.springbootinfrastructure.helper.Activity_helper;
import com.CS5500.springbootinfrastructure.parser.DataFormatterImpl;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("activity")
    private String act_type;

    private Timestamp startTime;
    private Timestamp endTime;

    @ElementCollection
    private List<String> trackPoints;


    @JsonProperty("startTime")
    @SuppressWarnings("unchecked")
    private void startTimeDeserializer(String startTime) {
        this.startTime = new DataFormatterImpl().convertTimestamp(startTime);
    }

    @JsonProperty("endTime")
    @SuppressWarnings("unchecked")
    private void endTimeDeserializer(String endTime) {
        this.endTime = new DataFormatterImpl().convertTimestamp(endTime);
    }



    @ManyToOne
    @JoinColumn(name = "f_type_id")
    private Type type;

    private String group;
    private Boolean manual;
    private Float duration;
    private Float distance;
    private Integer steps;
    private Integer calories;

    public Activity(Activity_helper helper) {
        Activity act = new Activity();
        act.setAct_id(helper.getAct_id());
        // act.setType(new Type(helper.getType()));
        act.setGroup(helper.getGroup());
        act.setManual(helper.getManual());
        act.setDuration(helper.getDuration());
        act.setSteps(helper.getSteps());
        act.setCalories(helper.getCalories());
    }

    public Activity() {

    }

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


