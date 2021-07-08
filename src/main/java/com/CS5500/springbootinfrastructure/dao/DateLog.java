package com.CS5500.springbootinfrastructure.dao;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.CS5500.springbootinfrastructure.helper.DateLog_helper;
import com.CS5500.springbootinfrastructure.parser.DataFormatterImpl;
import com.CS5500.springbootinfrastructure.parser.DateLogFormatterImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({ "summary"})
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "date_log")
public class DateLog {
    /*@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;*/

    @Id
    @Column(name = "date_of")
    private Date date;

    @JsonProperty("date")
    @SuppressWarnings("unchecked")
    private void dateDeserializer(String date) {
        this.date= new Date(new DateLogFormatterImpl().convertTimestamp(date).getTime());
    }

    private Integer caloriesIdle;

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    @OneToMany(mappedBy = "date", cascade = CascadeType.ALL)
    @JsonProperty("segments")
    private List<Type> types;

    @Override
    public String toString() {
        return "DateLog{" +
                "date=" + date +
                ", caloriesIdle=" + caloriesIdle +
                ", lastUpdate=" + lastUpdate.toString() +
                '}';
    }

    public static DateLog convertHelper(DateLog_helper helper) {
        DateLog dl = new DateLog();

        dl.setDate(new Date(new DataFormatterImpl().convertTimestamp(helper.getDate()).getTime()));
        dl.setCaloriesIdle(helper.getCaloriesIdle());
        // dl.setSegments(Segment.convertHelper(helper.getSegments()));
        dl.setLastUpdate(new DataFormatterImpl().convertTimestamp(helper.getLastUpdate()));

        return dl;
    }

    public DateLog() {

    }

    private Timestamp lastUpdate;

    @JsonProperty("lastUpdate")
    @SuppressWarnings("unchecked")
    private void lastUpdateDeserializer(String lastUpdateTime) {
        this.lastUpdate = new DataFormatterImpl().convertTimestamp(lastUpdateTime);
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

    public Date getDate() {
        return date;
    }

    public void setDate(Date dateOf) {
        this.date = dateOf;
    }

    public Integer getCaloriesIdle() {
        return caloriesIdle;
    }

    public void setCaloriesIdle(Integer caloriesIdle) {
        this.caloriesIdle = caloriesIdle;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void timestampLastUpdate() {
        this.lastUpdate = new Timestamp(System.currentTimeMillis());
    }
}
