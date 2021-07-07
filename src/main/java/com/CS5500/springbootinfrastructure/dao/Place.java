package com.CS5500.springbootinfrastructure.dao;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("place")
public class Place extends Type{

}
