package dev.florinchristian.restaurantbackend.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "restauranttables")
public class TableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Date startTime;
    Date endTime;

    public TableModel() {

    }

    public TableModel(Integer id, Date startTime, Date endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
