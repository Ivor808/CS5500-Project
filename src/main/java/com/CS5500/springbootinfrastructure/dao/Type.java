package com.CS5500.springbootinfrastructure.dao;

import com.CS5500.springbootinfrastructure.parser.DataFormatterImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="kind",
    discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Place.class, name = "place"),
        @JsonSubTypes.Type(value=Move.class, name = "move"),
        @JsonSubTypes.Type(value=Off.class, name = "off")
})
public class Type {

  public long getTypeID() {
    return typeID;
  }

  @Override
  public String toString() {
    return "Type{" +
            "typeID=" + typeID +
            ", activities=" + activities.toString() +
            ", startTime=" + startTime.toString() +
            ", endTime=" + endTime.toString() +
            ", lastUpdate=" + lastUpdate.toString() +
            '}';
  }

  public void setTypeID(long typeID) {
    this.typeID = typeID;
  }

  public List<Activity> getActivities() {
    return activities;
  }

  public void setActivities(List<Activity> activities) {
    this.activities = activities;
  }

  public Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(Timestamp startTime) {
    this.startTime = startTime;
  }

  @JsonProperty("startTime")
  @SuppressWarnings("unchecked")
  private void startTimeDeserializer(String startTime) {
    this.startTime = new DataFormatterImpl().convertTimestamp(startTime);
  }

  @JsonProperty("endTime")
  @SuppressWarnings("unchecked")
  private void endTimeDeserializer(String endTime) {
    this.endTime = new DataFormatterImpl().convertTimestamp(endTime);
  }

  @JsonProperty("lastUpdate")
  @SuppressWarnings("unchecked")
  private void lastUpdateDeserializer(String lastUpdateTime) {
    this.lastUpdate = new DataFormatterImpl().convertTimestamp(lastUpdateTime);
  }

  public Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(Timestamp endTime) {
    this.endTime = endTime;
  }

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  protected long typeID;

  public DateLog getDate() {
    return date;
  }

  public void setDate(DateLog date) {
    this.date = date;
  }

  @ManyToOne
  @JoinColumn(name = "f_date", nullable = false)
  private DateLog date;

  @JsonProperty("activities")
  @SuppressWarnings("unchecked")
  private void fkeyActivitiesSerializer(List<Activity> activities) {
    this.activities = activities;
    for (Activity activity : this.activities) {
      activity.setType(this);
    }
  }

  @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
  private List<Activity> activities;

  private Timestamp startTime;
  private Timestamp endTime;

  public Timestamp getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Timestamp lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  private Timestamp lastUpdate;

}
