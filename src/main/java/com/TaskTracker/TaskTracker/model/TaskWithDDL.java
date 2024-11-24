package com.TaskTracker.TaskTracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Entity
public class TaskWithDDL {
    @Getter
    @Setter
    private Time startTime;
    @Getter
    @Setter
    private Date startDate;
    @Getter
    @Setter
    private Time endTime;
    @Getter
    @Setter
    private Date endDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String category;
    @Getter
    @Setter
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "status_id")
    @Getter
    @Setter
    private Status status;

    public TaskWithDDL(String name, String description, String category, Status status, Date startDate, Date endDate, Time startTime, Time endTime) {
    }

    public TaskWithDDL() {
    }
}
