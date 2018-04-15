package by.tc.epam.model.entity;

import java.util.Objects;

public class BukmakerDate {

    private String date;
    private String time;

    public BukmakerDate() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFullDate(){
        return this.date + this.time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BukmakerDate that = (BukmakerDate) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date, time);
    }

    @Override
    public String toString() {
        return "BukmakerDate{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
