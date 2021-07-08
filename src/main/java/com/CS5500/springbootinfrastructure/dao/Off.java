package com.CS5500.springbootinfrastructure.dao;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("off")
@JsonTypeName("off")
public class Off extends Type {
}
