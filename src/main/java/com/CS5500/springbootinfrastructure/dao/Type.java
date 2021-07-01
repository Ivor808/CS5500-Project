package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="kind",
    discriminatorType = DiscriminatorType.INTEGER)
public class Type {
  @Id
  private long typeID;


}
