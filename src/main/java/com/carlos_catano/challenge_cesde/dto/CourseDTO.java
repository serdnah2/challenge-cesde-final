package com.carlos_catano.challenge_cesde.dto;

import java.math.BigDecimal;
import java.util.Date;

public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    private int duration;
    private BigDecimal price;
    private Date startDate;
    private Long teacherId;

    public CourseDTO(Long id, String name, String description, int duration, BigDecimal price, Date startDate, Long teacherId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.price = price;
        this.startDate = startDate;
        this.teacherId = teacherId;
    }

    public CourseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}