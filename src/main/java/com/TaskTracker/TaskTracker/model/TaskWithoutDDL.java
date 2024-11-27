package com.TaskTracker.TaskTracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    private LocalDate createdDate; // Изменено на LocalDate

    @ManyToOne
    @JoinColumn(name = "status_id")
    @Getter
    @Setter
    private Status status;

    @Getter
    @Setter
    private LocalDate dateToDo;

    @Getter
    @Setter
    private LocalTime timeToDo; // Добавлено поле для времени задачи


    public TaskWithoutDDL(Long id, String name, String description, String category, Status status, LocalDate dateToDo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        createdDate = LocalDate.now();
        this.status = status;
        this.dateToDo = dateToDo;
    }

    public TaskWithoutDDL() {}

    public void updateStatusIfNeeded() {
        LocalDateTime now = LocalDateTime.now();
        LocalTime currentTime = now.toLocalTime();

        // Проверка на null и сравнение времени с учетом некоторого допуска (например, ± 1 минута)
        if (status != null && status.getName().equals("В процессе") &&
                currentTime.isAfter(LocalTime.of(23, 58)) && currentTime.isBefore(LocalTime.of(24, 0))) {
            this.status = Status.getByName("Отменено");
            if (this.dateToDo != null) {
                this.dateToDo = this.dateToDo.plusDays(1);
                this.timeToDo = LocalTime.of(0, 0);
            }
        }
    }
}
