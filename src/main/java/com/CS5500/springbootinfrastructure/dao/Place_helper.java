package com.CS5500.springbootinfrastructure.dao;

import java.text.SimpleDateFormat;

public class Place_helper extends Type{
    public Integer id;
    private SimpleDateFormat start_time;
    private SimpleDateFormat end_time;
    private String name;
    public String type;
    public Location_helper location;

    public String foursquareId;
    public String[] foursquareCategoryIds;
    public String facebookPlaceId;

    public Integer getPlace_id() {
        return id;
    }

    public void setPlace_id(Integer place_id) {
        this.id = place_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace_type() {
        return type;
    }

    public void setPlace_type(String place_type) {
        this.type = place_type;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    public void setFoursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
    }

}
