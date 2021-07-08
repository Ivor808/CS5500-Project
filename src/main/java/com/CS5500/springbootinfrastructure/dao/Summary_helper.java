package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

public class Summary_helper {
    /*@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;*/

    public String activity;

    public String group;

    public Float duration;

    public Float distance;

    public Double steps;

    public Integer calories;

    public Timestamp lastUpdate;

}

