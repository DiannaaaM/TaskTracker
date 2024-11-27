package com.TaskTracker.TaskTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Status {

    @Id
    @GeneratedValue
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    private static final Map<String, Status> statuses = new HashMap<>();

    public Status() {} //Needed for JPA

    public Status(String name) {
        this.name = name;
    }

    // Инициализация статусов
    static {
        statuses.put("Open", new Status("Open"));
        statuses.put("In Progress", new Status("In Progress"));
        statuses.put("Closed", new Status("Closed"));
    }

    public static Status getByName(String name) {
        return statuses.get(name);  // Использование Map для поиска статуса
    }
}
