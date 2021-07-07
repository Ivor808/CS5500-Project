package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="kind",
    discriminatorType = DiscriminatorType.STRING)
public class Type {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private long typeID;

  @ManyToOne
  @JoinColumn(name = "f_seg_id")
  private Segment segment;

}
