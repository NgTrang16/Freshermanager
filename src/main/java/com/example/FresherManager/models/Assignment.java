package com.example.FresherManager.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 150,unique=true)
    private String name;
    @Column(name = "score1", length = 150)
    private Float score1;
    @Column(name = "score2", length = 150)
    private Float score2;
    @Column(name = "score3", length = 150)
    private Float score3;

    public Assignment() {
    }

    public Assignment(Long id, String name, Float score1, Float score2, Float score3) {
        this.id = id;
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
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

    public Float getScore1() {
        return score1;
    }

    public void setScore1(Float score1) {
        this.score1 = score1;
    }

    public Float getScore2() {
        return score2;
    }

    public void setScore2(Float score2) {
        this.score2 = score2;
    }

    public Float getScore3() {
        return score3;
    }

    public void setScore3(Float score3) {
        this.score3 = score3;
    }
}
