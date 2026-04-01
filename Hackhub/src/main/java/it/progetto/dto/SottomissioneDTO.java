package it.progetto.dto;

public class SottomissioneDTO {
    private final int teamId;
    private final int hackathonId;
    private final String link;

    public SottomissioneDTO(int teamId, int hackathonId, String link) {
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
}
