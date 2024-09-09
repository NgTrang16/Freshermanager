package com.example.FresherManager.dto;

import java.io.Serializable;
import java.util.Date;

public class CreateProjectRequest implements Serializable {
    private Long id;
    private String name;
    private String manager;
    private Date startDate;
    private Date endDate;
    private String status;
    private String programingLanguage;

    public CreateProjectRequest() {
    }

    public CreateProjectRequest(Date endDate, Long id, String manager, String name, String programingLanguage, Date startDate, String status) {
        this.endDate = endDate;
        this.id = id;
        this.manager = manager;
        this.name = name;
        this.programingLanguage = programingLanguage;
        this.startDate = startDate;
        this.status = status;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgramingLanguage() {
        return programingLanguage;
    }

    public void setProgramingLanguage(String programingLanguage) {
        this.programingLanguage = programingLanguage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
