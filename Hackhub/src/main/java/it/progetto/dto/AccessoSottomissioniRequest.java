package it.progetto.dto;

public class AccessoSottomissioniRequest {
    private final int staffId;
    private final int hackathonId;
    private final int teamId;

    public AccessoSottomissioniRequest(int staffId, int hackathonId, int teamId) {
        this.staffId = staffId;
        this.hackathonId = hackathonId;
        this.teamId = teamId;
    }

    public int getStaffId() {
        return staffId;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public int getTeamId() {
        return teamId;
    }
}
