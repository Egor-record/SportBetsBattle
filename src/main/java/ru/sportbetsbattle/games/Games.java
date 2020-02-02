package ru.sportbetsbattle.games;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import ru.sportbetsbattle.core.BaseEntity;
import ru.sportbetsbattle.values.Values;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Games extends BaseEntity {

    @NotNull
    @Size(min = 2, max = 15)
    private String nameOfTheGame;
    @NotNull
    private String league;
    @NotNull
    private String teamFirst;
    @NotNull
    private String teamSecond;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Values> values;

    @CreatedDate
    private Date CreatedAt;

    @LastModifiedDate
    private Date LastUpdated;

    protected Games() {
       super();
       values = new ArrayList<>();
    }

    public Games(String nameOfTheGame, String league, String teamFirst, String teamSecond) {
        this();
        this.nameOfTheGame = nameOfTheGame;
        this.league = league;
        this.teamFirst = teamFirst;
        this.teamSecond = teamSecond;
    }

    public List<Values> getValues() {
        return values;
    }

    private void addValue(Values value) {
        value.setGame(this);
        values.add(value);
    }

    public String getNameOfTheGame() {
        return nameOfTheGame;
    }

    public void setNameOfTheGame(String nameOfTheGame) {
        this.nameOfTheGame = nameOfTheGame;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getTeamFirst() {
        return teamFirst;
    }

    public void setTeamFirst(String teamFirst) {
        this.teamFirst = teamFirst;
    }

    public String getTeamSecond() {
        return teamSecond;
    }

    public void setTeamSecond(String teamSecond) {
        this.teamSecond = teamSecond;
    }

    public void setValues(List<Values> values) {
        this.values = values;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public Date getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        LastUpdated = lastUpdated;
    }
}
