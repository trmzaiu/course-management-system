package com.example.course_management_system.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "skill_level")
    private String skillLevel;

    @Column(name = "status")
    private String status = "draft";

    @Column(name = "duration")
    private int duration;

    @Column(name = "image")
    private String image;

    public Courses() {}

    public Courses(String name, String description, String category, String skillLevel, String status, int duration, String image) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.skillLevel = skillLevel;
        this.status = status;
        this.duration = duration;
        this.image = image;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters

    public int getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (!category.equals("Programming") && 
            !category.equals("Data Science") &&
            !category.equals("UI/UX Design") &&
            !category.equals("Web Development") &&
            !category.equals("Artificial Intelligence")) {
            throw new IllegalArgumentException("Invalid category: " + category);
        }
        this.category = category;
    }

    public String getFormattedCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return createdAt.format(formatter);
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        if (!skillLevel.equals("beginner") &&
            !skillLevel.equals("intermediate") &&
            !skillLevel.equals("advanced")) {
            throw new IllegalArgumentException("Invalid skill level: " + skillLevel);
        }
        this.skillLevel = skillLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (!status.equals("draft") && !status.equals("published")) {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
        this.status = status;
    }

    public int getDuration() {
        return duration;
    }

    public String getFormattedDuration() {
        int hours = duration / 60;
        int minutes = duration % 60;
        return String.format("%dh %dm", hours, minutes);
    }

    public void setDuration(int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0");
        }
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

