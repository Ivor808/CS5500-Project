package com.CS5500.springbootinfrastructure.controller;


public class ActivityContModel {
    private String activity;
    private Integer id;
    private String group;
    private Boolean manual;
    private Integer start_hh, start_mm, start_ss;
    private Integer end_hh, end_mm, end_ss;
    private Integer calories;
    private Float duration;
    private Float distance;
    private Integer steps;

    public String getActivity() {
        return activity;
    }

    public String getGroup() {
        return group;
    }

    public Integer getStart_hh() {
        return start_hh;
    }

    public Integer getStart_mm() {
        return start_mm;
    }

    public Integer getStart_ss() {
        return start_ss;
    }

    public Integer getEnd_hh() {
        return end_hh;
    }

    public Integer getEnd_mm() {
        return end_mm;
    }

    public Integer getEnd_ss() {
        return end_ss;
    }



    public Boolean getManual() {
        return manual;
    }

    public Integer getCalories() {
        return calories;
    }

    public Float getDuration() {
        return duration;
    }

    public Float getDistance() {
        return distance;
    }

    public Integer getSteps() {
        return steps;
    }

}
