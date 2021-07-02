package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.text.SimpleDateFormat;

@Entity
@DiscriminatorValue("1")
public class Move extends Type{
  private Integer move_id;
  private SimpleDateFormat start_time;
  private SimpleDateFormat end_time;

  public Integer getMove_id() {
    return move_id;
  }

  public void setMove_id(Integer move_id) {
    this.move_id = move_id;
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
}
