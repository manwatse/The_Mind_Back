package models;

public class Score {
    String name;
    int points;

    public Score(String name, int points) {
        this.name = name;
        this.points = points;

    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

}
