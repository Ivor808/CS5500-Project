package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="kind",
    discriminatorType = DiscriminatorType.STRING)
public class Type {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long typeID;

  @ManyToOne
  @JoinColumn(name = "f_seg_id", nullable = false)
  private Segment segment;

  @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
  private List<Activity> activities;

  private Timestamp startTime;
  private Timestamp endTime;

}
