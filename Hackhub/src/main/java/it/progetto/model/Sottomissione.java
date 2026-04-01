package it.progetto.model;

public class Sottomissione {
    private final int teamId;
    private final int hackathonId;
    private final String link;

    public Sottomissione(int teamId, int hackathonId, String link) {
        this.teamId = teamId;
        this.hackathonId = hackathonId;
        this.link = link;
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
                "teamId=" + teamId +
                ", hackathonId=" + hackathonId +
                ", link='" + link + '\'' +
                '}';
    }
}
