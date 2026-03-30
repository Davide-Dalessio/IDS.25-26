package it.progetto.dto;

public class IscrizioneRequest {
    private final int teamId;
    private final int hackathonId;

    public IscrizioneRequest(int teamId, int hackathonId) {
        this.teamId = teamId;
        this.hackathonId = hackathonId;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getHackathonId() {
        return hackathonId;
    }
}
