package com.TaskTracker.TaskTracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class TaskWithDDL {
    @Getter
    @Setter
    private LocalTime startTime;
    @Getter
    @Setter
    private LocalDate startDate;
    @Getter
    @Setter
    private LocalTime endTime;
    @Getter
    @Setter
    private LocalDate endDate;
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
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "status_id")
    @Getter
    @Setter
    private Status status;

    public TaskWithDDL(String name, String description, String category, Status status, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        createdDate = LocalDate.now();
    }

    public TaskWithDDL() {
    }

    public boolean isLastDayToday() {
        LocalDate today = LocalDate.now();
        return endDate != null && endDate.equals(today);
    }

    public void updateStatusIfNeeded() {
        LocalDateTime now = LocalDateTime.now();
        LocalTime currentTime = now.toLocalTime();

        // Проверка на null и сравнение времени с учетом некоторого допуска (например, ± 1 минута)
        if (status != null && status.getName().equals("В процессе") &&
                currentTime.isAfter(LocalTime.of(23, 58)) && currentTime.isBefore(LocalTime.of(24, 0))) {
            this.status = Status.getByName("Отменено");
            if (this.startDate != null) {
                this.startDate = this.startDate.plusDays(1);
                this.startTime = Time.valueOf( LocalTime.of(0, 0) ).toLocalTime();
            }
        }
    }
}
