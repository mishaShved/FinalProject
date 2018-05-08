package by.tc.epam.model.entity;


import java.util.Objects;

public class Event {

    private int id;
    private String startTime;
    private String sportType;
    private String team1;
    private String team2;
    private Integer score1;
    private Integer score2;

    public Event() {
    }

    public Event(int id, String startTime, String sportType, String team1,
                 String team2, Integer score1, Integer score2) {
        this.id = id;
        this.startTime = startTime;
        this.sportType = sportType;
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = score1;
        this.score2 = score2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getSportType() {
        return sportType;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public Integer getScore1() {
        return score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                Objects.equals(startTime, event.startTime) &&
                Objects.equals(sportType, event.sportType) &&
                Objects.equals(team1, event.team1) &&
                Objects.equals(team2, event.team2) &&
                Objects.equals(score1, event.score1) &&
                Objects.equals(score2, event.score2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, startTime, sportType, team1, team2, score1, score2);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", sportType=" + sportType +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", score1=" + score1 +
                ", score2=" + score2 +
                '}';
    }
}
