package com.CS5500.springbootinfrastructure.dao;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.SimpleDateFormat;

@Entity
@DiscriminatorValue("2")
public class Place extends Type{
    private Integer place_id;
    private SimpleDateFormat start_time;
    private SimpleDateFormat end_time;
    private String name;
    private String place_type;
    private Double lat;
    private Double lon;
    private String foursquareId;


    @Id
    public Integer getPlace_id() {
        return place_id;
    }

    public void setPlace_id(Integer place_id) {
        this.place_id = place_id;
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
        return place_type;
    }

    public void setPlace_type(String place_type) {
        this.place_type = place_type;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    public void setFoursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
    }

}
