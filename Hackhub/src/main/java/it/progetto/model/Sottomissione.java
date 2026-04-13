package it.progetto.model;

public class Sottomissione {
    private final int sottomissioneId;
    private final int teamId;
    private final int hackathonId;
    private final String link;

    public Sottomissione(int sottomissioneId, int teamId, int hackathonId, String link) {
        this.sottomissioneId = sottomissioneId;
        this.teamId = teamId;
        this.hackathonId = hackathonId;
        this.link = link;
    }

    public int getId() {
        return sottomissioneId;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "Sottomissione{" +
                "id=" + sottomissioneId +
                ", teamId=" + teamId +
                ", hackathonId=" + hackathonId +
                ", link='" + link + '\'' +
                '}';
    }
}
