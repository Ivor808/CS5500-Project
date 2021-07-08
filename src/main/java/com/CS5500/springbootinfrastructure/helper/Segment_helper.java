package com.CS5500.springbootinfrastructure.helper;

import com.CS5500.springbootinfrastructure.dao.Type;

import java.util.List;

public class Segment_helper {

  public Integer getSeg_id() {
    return seg_id;
  }

  public void setSeg_id(Integer seg_id) {
    this.seg_id = seg_id;
  }

  public List<Type> getType() {
    return type;
  }

  public void setType(List<Type> type) {
    this.type = type;
  }

  private Integer seg_id; //will be auto generated
  public List<Type> type;

}
