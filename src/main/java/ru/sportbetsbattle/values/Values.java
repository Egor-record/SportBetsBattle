package ru.sportbetsbattle.values;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import ru.sportbetsbattle.core.BaseEntity;
import ru.sportbetsbattle.games.Games;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Values  extends BaseEntity {

    private double winnerFirst;
    private double draw;
    private double winnerSecond;
    private double winnerFirstOrDraw;
    private double winnerFirstOrWinnerSecond;
    private double drawOrWinnerSecond;
    private double totalMore;
    private double total;
    private double totalLess;
    private String betsName;

    @ManyToOne
    private Games game;

    protected Values() {
        super();
    }

    public Values(double winnerFirst, double draw,
                  double winnerSecond, double winnerFirstOrDraw,
                  double winnerFirstOrWinnerSecond, double drawOrWinnerSecond,
                  double totalMore, double total, double totalLess, String betsName) {
        this();
        this.winnerFirst = winnerFirst;
        this.draw = draw;
        this.winnerSecond = winnerSecond;
        this.winnerFirstOrWinnerSecond = winnerFirstOrWinnerSecond;
        this.winnerFirstOrDraw = winnerFirstOrDraw;
        this.drawOrWinnerSecond = drawOrWinnerSecond;
        this.totalMore = totalMore;
        this.total = total;
        this.totalLess = totalLess;
        this.betsName = betsName;
    }

    @CreatedDate
    private Date CreatedAt;

    @LastModifiedDate
    private Date LastUpdated;

    public double getWinnerFirst() {
        return winnerFirst;
    }

    public void setWinnerFirst(double winnerFirst) {
        this.winnerFirst = winnerFirst;
    }

    public double getDraw() {
        return draw;
    }

    public void setDraw(double draw) {
        this.draw = draw;
    }

    public double getWinnerSecond() {
        return winnerSecond;
    }

    public void setWinnerSecond(double winnerSecond) {
        this.winnerSecond = winnerSecond;
    }

    public double getWinnerFirstOrDraw() {
        return winnerFirstOrDraw;
    }

    public void setWinnerFirstOrDraw(double winnerFirstOrDraw) {
        this.winnerFirstOrDraw = winnerFirstOrDraw;
    }

    public double getWinnerFirstOrWinnerSecond() {
        return winnerFirstOrWinnerSecond;
    }

    public void setWinnerFirstOrWinnerSecond(double winnerFirstOrWinnerSecond) {
        this.winnerFirstOrWinnerSecond = winnerFirstOrWinnerSecond;
    }

    public String getBetsName() {
        return betsName;
    }

    public void setBetsName(String betsName) {
        this.betsName = betsName;
    }

    public double getDrawOrWinnerSecond() {
        return drawOrWinnerSecond;
    }

    public void setDrawOrWinnerSecond(double drawOrWinnerSecond) {
        this.drawOrWinnerSecond = drawOrWinnerSecond;
    }

    public double getTotalMore() {
        return totalMore;
    }

    public void setTotalMore(double totalMore) {
        this.totalMore = totalMore;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalLess() {
        return totalLess;
    }

    public void setTotalLess(double totalLess) {
        this.totalLess = totalLess;
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

    public Games getGame() {
        return game;
    }

    public void setGame(Games games) {
        this.game = games;
    }


}
