package it.progetto.hackhub.dto;

public class RichiestaSupportoRequest {
    private int teamId;
    private int hackathonId;
    private String msg;

    public RichiestaSupportoRequest() {}

    public RichiestaSupportoRequest(int teamId, int hackathonId, String msg) {
        this.teamId = teamId;
        this.hackathonId = hackathonId;
        this.msg = msg;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public void setHackathonId(int hackathonId) {
        this.hackathonId = hackathonId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
