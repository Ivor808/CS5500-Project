package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "summary")
public class Summary {
    /*@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;*/

    @Id
    public String activity;

    public String sumGroup;

    public Float duration;

    public Float distance;

    public Double steps;

    public Integer calories;

    public Timestamp lastUpdate;

}

