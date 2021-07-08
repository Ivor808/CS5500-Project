package com.CS5500.springbootinfrastructure.dao;


import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("place")
public class Place extends Type{

    private String name;
    private String type;

    @Embedded
    private Location location;

    private String foursquareId;

    @ElementCollection
    private List<String> foursquareCategoryIds;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getFoursquareCategoryIds() {
        return foursquareCategoryIds;
    }

    public void setFoursquareCategoryIds(List<String> foursquareCategoryIds) {
        this.foursquareCategoryIds = foursquareCategoryIds;
    }

    public String getFacebookPlaceId() {
        return facebookPlaceId;
    }

    public void setFacebookPlaceId(String facebookPlaceId) {
        this.facebookPlaceId = facebookPlaceId;
    }

    private String facebookPlaceId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String place_type) {
        this.type = place_type;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    public void setFoursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
    }

}
