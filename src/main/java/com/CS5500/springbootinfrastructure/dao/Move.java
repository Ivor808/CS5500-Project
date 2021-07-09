package com.CS5500.springbootinfrastructure.dao;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
@DiscriminatorValue("move")
@JsonTypeName("move")
public class Move extends Type{


}
