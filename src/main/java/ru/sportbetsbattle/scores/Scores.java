package ru.sportbetsbattle.scores;


import ru.sportbetsbattle.core.BaseEntity;
import ru.sportbetsbattle.games.Games;

import javax.persistence.*;

/**
 * Scores of each game;
 * Separate table so that to let make diagrams of score history
 *
 * @since 1.1
 * @version 1.1
 * {@value} teamFirst : Int - Score of the first team
 * {@value} teamSecond : Int - Score of the second team
 * {@value} betName : String - Name of the booker (1xbet)
 * {@value} game : Game - Name of the game this scores belongs
 */

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
