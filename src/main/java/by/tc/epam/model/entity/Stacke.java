package by.tc.epam.model.entity;

import java.util.Objects;

public class Stacke {

    private Double betSum;
    private Double koef;

    public Stacke() {
    }

    public Stacke(Double betSum, Double koef) {
        this.betSum = betSum;
        this.koef = koef;
    }

    public Double getBetSum() {
        return betSum;
    }

    public Double getKoef() {
        return koef;
    }

    public void setBetSum(Double betSum) {
        this.betSum = betSum;
    }

    public void setKoef(Double koef) {
        this.koef = koef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stacke stacke = (Stacke) o;
        return Objects.equals(betSum, stacke.betSum) &&
                Objects.equals(koef, stacke.koef);
    }

    @Override
    public int hashCode() {

        return Objects.hash(betSum, koef);
    }

    @Override
    public String toString() {
        return "Stacke{" +
                "betSum=" + betSum +
                ", koef=" + koef +
                '}';
    }
}
