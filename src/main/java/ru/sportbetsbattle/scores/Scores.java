package ru.sportbetsbattle.scores;


import ru.sportbetsbattle.core.BaseEntity;
import ru.sportbetsbattle.games.Games;

import javax.persistence.*;

@Entity
public class Scores extends BaseEntity {

    private int teamFirst;
    private int teamSecond;
    private String betName;

    @ManyToOne
    private Games game;

    protected Scores() {
        super();
    }

    public Scores(int teamFirst, int teamSecond, String betName) {
        this.teamFirst = teamFirst;
        this.teamSecond = teamSecond;
        this.betName = betName;
    }

    public int getTeamFirst() {
        return teamFirst;
    }

    public void setTeamFirst(int teamFirst) {
        this.teamFirst = teamFirst;
    }

    public int getTeamSecond() {
        return teamSecond;
    }

    public void setTeamSecond(int teamSecond) {
        this.teamSecond = teamSecond;
    }

    public String getBetName() {
        return betName;
    }

    public void setBetName(String betName) {
        this.betName = betName;
    }

    public Games getGame() {
        return game;
    }

    public void setGame(Games game) {
        this.game = game;
    }
}
