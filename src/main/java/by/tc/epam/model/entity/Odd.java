package by.tc.epam.model.entity;

import java.util.Objects;

public class Odd {

    private OddType oddType;
    private Double koef;
    private Double param;

    public Odd() {
    }

    public Odd(OddType oddType, Double koef, Double param) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Odd odd = (Odd) o;
        return oddType == odd.oddType &&
                Objects.equals(koef, odd.koef) &&
                Objects.equals(param, odd.param);
    }

    @Override
    public int hashCode() {

        return Objects.hash(oddType, koef, param);
    }

    @Override
    public String toString() {
        return "Odd{" +
                "oddType=" + oddType +
                ", koef=" + koef +
                ", param=" + param +
                '}';
    }


}
