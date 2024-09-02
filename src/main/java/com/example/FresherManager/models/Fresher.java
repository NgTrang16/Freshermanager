package com.example.FresherManager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Fresher")
public class Fresher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String emailFresher;
    @Column(name = "programming_language", length = 50)
    private String programingLanguage;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Center center;


    public Fresher(Center center) {
        this.center = center;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public Fresher() {
    }

    public Fresher(String name, String emailFresher, String programingLanguage) {
        this.name = name;
        this.emailFresher = emailFresher;
        this.programingLanguage = programingLanguage;
    }

    @Override
    public String toString() {
        return "Fresher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailFresher='" + emailFresher + '\'' +
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

    public String getEmailFresher() {
        return emailFresher;
    }

    public void setEmailFresher(String emailFresher) {
        this.emailFresher = emailFresher;
    }

    public String getProgramingLanguage() {
        return programingLanguage;
    }

    public void setProgramingLanguage(String programingLanguage) {
        this.programingLanguage = programingLanguage;
    }


}
