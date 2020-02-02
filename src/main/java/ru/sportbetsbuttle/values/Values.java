package ru.sportbetsbuttle.values;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Values {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private double winnerFirst;
    private double draw;
    private double winnerSecond;
    private double winnerFirstOrDraw;
    private double winnerFirstOrWinnerSecond;
    private double drawOrWinnerSecond;
    private double totalMore;
    private double total;
    private double totalLess;

    protected Values() {
        id = null;
    }

    public Values(double winnerFirst, double draw,
                  double winnerSecond, double winnerFirstOrDraw,
                  double winnerFirstOrWinnerSecond, double drawOrWinnerSecond,
                  double totalMore, double total, double totalLess) {
        this.winnerFirst = winnerFirst;
        this.draw = draw;
        this.winnerSecond = winnerSecond;
        this.winnerFirstOrWinnerSecond = winnerFirstOrWinnerSecond;
        this.winnerFirstOrDraw = winnerFirstOrDraw;
        this.drawOrWinnerSecond = drawOrWinnerSecond;
        this.totalMore = totalMore;
        this.total = total;
        this.totalLess = totalLess;
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
}
