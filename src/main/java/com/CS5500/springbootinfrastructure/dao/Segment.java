package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "segment")
public class Segment {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer seg_id;

  @OneToMany(mappedBy = "segment")
  private Set<Type> type;

  public Integer getSeg_id() {
    return seg_id;
  }

  public void setSeg_id(Integer seg_id) {
    this.seg_id = seg_id;
  }

  public Set<Type> getType() {
    return type;
  }

  public void setType(Set<Type> move) {
    this.type = move;
  }

}
