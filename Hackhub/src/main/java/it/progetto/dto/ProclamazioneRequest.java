package it.progetto.dto;

public class ProclamazioneRequest {
    private final int organizzatoreId;
    private final int hackathonId;
    private final int teamId;

    public ProclamazioneRequest(int organizzatoreId, int hackathonId, int teamId) {
        this.organizzatoreId = organizzatoreId;
        this.hackathonId = hackathonId;
        this.teamId = teamId;
    }

    public int getOrganizzatoreId() {
        return organizzatoreId;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public int getTeamId() {
        return teamId;
    }
}
