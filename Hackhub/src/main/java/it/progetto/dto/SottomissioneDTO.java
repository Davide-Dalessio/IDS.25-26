package it.progetto.dto;

public class SottomissioneDTO {
    private final int sottomissioneId;
    private final int teamId;
    private final int hackathonId;
    private final String link;

    public SottomissioneDTO(int sottomissioneId, int teamId, int hackathonId, String link) {
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
}
