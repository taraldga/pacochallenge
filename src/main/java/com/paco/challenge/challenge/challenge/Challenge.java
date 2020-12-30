package com.paco.challenge.challenge.challenge;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Challenge {
    private @Id @GeneratedValue Long id;
    private String title;
    private String description;
    private String type;
    private Double goal;
    private String measureUnit;
    private Date startDate;
    private Date endDate;
    private Date created;
    private Date updated;
    private String interval;

    public Challenge(String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public Challenge() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.description);
    }

    @Override
    public String toString() {
        return String.format("Challenge{id=%d,name=%s}", this.id, this.description);
    }

    @Override
    public boolean equals (Object o){
        if(this == o) return true;
        else if(!(o instanceof Challenge)) return false;
        Challenge challenge = (Challenge) o;
        return Objects.equals(challenge.id, this.id);
    }
}
