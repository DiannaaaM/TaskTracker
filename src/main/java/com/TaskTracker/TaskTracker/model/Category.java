package com.TaskTracker.TaskTracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Category {
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
    private String colour;

    public Category() {}

    public Category(String name, String description, String colour) {
        this.name = name;
        this.description = description;
        this.colour = colour;
    }
}
