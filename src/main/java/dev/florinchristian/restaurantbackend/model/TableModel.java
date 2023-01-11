package dev.florinchristian.restaurantbackend.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "restauranttables")
public class TableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "starttime")
    Date startTime;

    @Column(name = "endtime")
    Date endTime;
}
