package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;

@Entity
@DiscriminatorValue("move")
public class Move extends Type{


}
