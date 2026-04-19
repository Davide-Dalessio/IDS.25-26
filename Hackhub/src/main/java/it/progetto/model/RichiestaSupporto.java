package it.progetto.model;

public class RichiestaSupporto {
    private final int teamId;
    private final int hackathonId;
    private final String msg;
    private final String stato;

    public RichiestaSupporto(int teamId, int hackathonId, String msg) {
        this.teamId = teamId;
        this.hackathonId = hackathonId;
        this.msg = msg;
        this.stato = "Aperta";
    }

    public int getTeamId() {
        return teamId;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public String getMsg() {
        return msg;
    }

    public String getStato() {
        return stato;
    }
}
