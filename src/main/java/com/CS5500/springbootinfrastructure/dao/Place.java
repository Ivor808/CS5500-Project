package com.CS5500.springbootinfrastructure.dao;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Place extends Type{

}
