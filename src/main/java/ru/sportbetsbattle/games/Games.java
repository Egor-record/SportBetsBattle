package ru.sportbetsbattle.games;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import ru.sportbetsbattle.core.BaseEntity;
import ru.sportbetsbattle.scores.Scores;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = {"CreatedAt", "LastUpdated"},allowGetters = true)
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

    private int scoreTeamFirst;

    private int scoreTeamSecond;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Scores> values;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date CreatedAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date LastUpdated;

    protected Games() {
       super();
       values = new ArrayList<>();
    }



    public Games(String nameOfTheGame,
                 String league,
                 String teamFirst,
                 String teamSecond,
                 Date createdAt,
                 Date lastUpdated,
                 int scoreTeamFirst,
                 int scoreTeamSecond) {
        this();
        this.nameOfTheGame = nameOfTheGame;
        this.league = league;
        this.teamFirst = teamFirst;
        this.teamSecond = teamSecond;
        this.CreatedAt = createdAt;
        this.LastUpdated = lastUpdated;
        this.scoreTeamFirst = scoreTeamFirst;
        this.scoreTeamSecond = scoreTeamSecond;
    }

    public List<Scores> getValues() {
        return values;
    }

    public void addValue(Scores value) {
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

    public void setValues(List<Scores> values) {
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

    public int getScoreTeamFirst() {
        return scoreTeamFirst;
    }

    public void setScoreTeamFirst(int scoreTeamFirst) {
        this.scoreTeamFirst = scoreTeamFirst;
    }

    public int getScoreTeamSecond() {
        return scoreTeamSecond;
    }

    public void setScoreTeamSecond(int scoreTeamSecond) {
        this.scoreTeamSecond = scoreTeamSecond;
    }
}
