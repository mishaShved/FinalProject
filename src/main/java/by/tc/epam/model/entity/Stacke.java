package by.tc.epam.model.entity;

import java.util.Objects;

public class Stacke {

    private String team1;
    private String team2;
    private Sport sportType;
    private OddType stakeType;
    private Double betSum;
    private Double koef;
    private Integer score1;
    private Integer score2;
    private boolean isWon;
    private double param;

    public Stacke() {
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public Sport getSportType() {
        return sportType;
    }

    public void setSportType(Sport sportType) {
        this.sportType = sportType;
    }

    public OddType getStakeType() {
        return stakeType;
    }

    public void setStakeType(OddType stakeType) {
        this.stakeType = stakeType;
    }

    public Double getBetSum() {
        return betSum;
    }

    public void setBetSum(Double betSum) {
        this.betSum = betSum;
    }

    public Double getKoef() {
        return koef;
    }

    public void setKoef(Double koef) {
        this.koef = koef;
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }

    public double getParam() {
        return param;
    }

    public void setParam(double param) {
        this.param = param;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stacke stacke = (Stacke) o;
        return isWon == stacke.isWon &&
                Double.compare(stacke.param, param) == 0 &&
                Objects.equals(team1, stacke.team1) &&
                Objects.equals(team2, stacke.team2) &&
                sportType == stacke.sportType &&
                stakeType == stacke.stakeType &&
                Objects.equals(betSum, stacke.betSum) &&
                Objects.equals(koef, stacke.koef) &&
                Objects.equals(score1, stacke.score1) &&
                Objects.equals(score2, stacke.score2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(team1, team2, sportType, stakeType, betSum, koef, score1, score2, isWon, param);
    }

    @Override
    public String toString() {
        return "Stacke{" +
                "team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", sportType=" + sportType +
                ", stakeType=" + stakeType +
                ", betSum=" + betSum +
                ", koef=" + koef +
                ", score1=" + score1 +
                ", score2=" + score2 +
                ", isWon=" + isWon +
                ", param=" + param +
                '}';
    }
}
