package com.TaskTracker.TaskTracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class TaskWithoutDDL {
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

    @Getter
    @Setter
    private Date dateToDo;

    public TaskWithoutDDL(Long id, String name, String description, String category, Date createdDate, Status status) {
    }

    public TaskWithoutDDL() {

    }
}
