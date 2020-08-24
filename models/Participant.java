package models;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Participant {
    private String name;
    private int index;
    private List<Integer> rankingList;
    private Participant currentChoice;

    public Participant() {
    }

    public Participant(String name) {
        this.name = name;
    }

    public Participant(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Integer> getRankingList() {
        return rankingList;
    }

    public void setRankingList(List<Integer> rankingList) {
        this.rankingList = rankingList;
    }

    public Participant getCurrentChoice() {
        return currentChoice;
    }

    public void setCurrentChoice(Participant currentChoice) {
        this.currentChoice = currentChoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "{'" + name + "\', " + Arrays.toString(rankingList.toArray()) + '}';
    }
}
