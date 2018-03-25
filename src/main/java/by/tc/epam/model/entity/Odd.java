package by.tc.epam.model.entity;

import java.util.Objects;

public class Odd {

    private String team1;
    private String team2;
    private OddType oddType;
    private Double koef;
    private Double param;

    public Odd() {
    }

    public Odd(String team1, String team2, OddType oddType, Double koef, Double param) {
        this.team1 = team1;
        this.team2 = team2;
        this.oddType = oddType;
        this.koef = koef;
        this.param = param;
    }

    public OddType getOddType() {
        return oddType;
    }

    public Double getKoef() {
        return koef;
    }

    public Double getParam() {
        return param;
    }

    public void setOddType(OddType oddType) {
        this.oddType = oddType;
    }

    public void setKoef(Double koef) {
        this.koef = koef;
    }

    public void setParam(Double param) {
        this.param = param;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Odd odd = (Odd) o;
        return Objects.equals(team1, odd.team1) &&
                Objects.equals(team2, odd.team2) &&
                oddType == odd.oddType &&
                Objects.equals(koef, odd.koef) &&
                Objects.equals(param, odd.param);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team1, team2, oddType, koef, param);
    }

    @Override
    public String toString() {
        return "Odd{" +
                "team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", oddType=" + oddType +
                ", koef=" + koef +
                ", param=" + param +
                '}';
    }
}
