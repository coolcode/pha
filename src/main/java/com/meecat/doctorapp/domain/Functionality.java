package com.meecat.doctorapp.domain;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table
public class Functionality extends BaseEntity {


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID")
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private LocalDateTime updateTime;

    @Column
    private Boolean accessToEndUser = false;

    @Column
    private Boolean accessToDoctor = false;

    @Column
    private Boolean accessToTechnicalTeam = false;

    public Functionality () {
        updateTime = LocalDateTime.now();
    }

    public int getId () {
        return id;
    }

    public void setId (int funcId) {
        this.id = funcId;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String funcDescription) {
        this.description = funcDescription;
    }

    public LocalDateTime getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (LocalDateTime funcUpdateDate) {
        this.updateTime = funcUpdateDate;
    }

    public boolean getAccessToEndUser () {
        return accessToEndUser;
    }

    public void setAccessToEndUser (Boolean accessToEndUser) {
        this.accessToEndUser = accessToEndUser;
    }

    public boolean getAccessToDoctor () {
        return accessToDoctor;
    }

    public void setAccessToDoctor (Boolean accessToDoctor) {
        this.accessToDoctor = accessToDoctor;
    }

    public boolean getAccessToTechnicalTeam () {
        return accessToTechnicalTeam;
    }

    public void setAccessToTechnicalTeam (Boolean accessToTechnicalTeam) {
        this.accessToTechnicalTeam = accessToTechnicalTeam;
    }
}