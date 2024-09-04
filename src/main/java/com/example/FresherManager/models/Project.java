package com.example.FresherManager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Project")
public class Project {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "Manager", nullable = false, length = 100)
    private String manager;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "status", length = 50)
    private String status;
    @Column(name = "programingLanguage", length = 50)
    private String programingLanguage;

    //fresher_project
    @JsonBackReference
    @ManyToMany(mappedBy = "projects")
    private Set<Fresher> freshers = new HashSet<>();


    //Center-Project
    @ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;


    public Project(Set<Fresher> freshers) {
        this.freshers = freshers;
    }

    public Set<Fresher> getFreshers() {
        return freshers;
    }

    public void setFreshers(Set<Fresher> freshers) {
        this.freshers = freshers;
    }

    public Project() {

    }

    public Project(String name, String manager, Date startDate, Date endDate, String status, String programingLanguage) {
        this.name = name;
        this.manager = manager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.programingLanguage = programingLanguage;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager='" + manager + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", programingLanguage='" + programingLanguage + '\'' +
                '}';
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProgramingLanguage() {
        return programingLanguage;
    }

    public void setProgramingLanguage(String programingLanguage) {
        this.programingLanguage = programingLanguage;
    }
}
