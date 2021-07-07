package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "segment")
public class Segment {

  @Id
  private Integer seg_id;
  public String startTime;
  public String endTime;
  public Place place;
  public String type;
  public String field;
  public String lastUpdate;
  public Activity[] activities;

  public Integer getSeg_id() {
    return seg_id;
  }

  public void setSeg_id(Integer seg_id) {
    this.seg_id = seg_id;
  }

  public String getType() {
    return type;
  }

  public void setType(String move) {
    this.type = move;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }
}
