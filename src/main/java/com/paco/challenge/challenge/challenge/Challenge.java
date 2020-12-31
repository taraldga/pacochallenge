package com.paco.challenge.challenge.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Data
@Entity
public class Challenge {
    private @Id @GeneratedValue Long id;
    private String title;
    private String description;
    private String type;
    private int goal;
    private String timeInterval;
    private String measureUnit;
    private Date startDate;
    private Date endDate;
    private Date created;
    private Date updated;

    public Challenge() {}

    public Challenge(String title, String description, String type, int goal, String timeInterval, String measureUnit, Date startDate, Date endDate, Date created, Date updated) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.goal = goal;
        this.timeInterval = timeInterval;
        this.measureUnit = measureUnit;
        this.startDate = startDate;
        this.endDate = endDate;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public boolean equals (Object o){
        if(this == o) return true;
        else if(!(o instanceof Challenge)) return false;
        Challenge challenge = (Challenge) o;
        return Objects.equals(challenge.id, this.id);
    }
}
