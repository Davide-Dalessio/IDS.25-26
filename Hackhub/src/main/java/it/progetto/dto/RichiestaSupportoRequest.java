package it.progetto.dto;

/** Usato dal Membro del Team per creare una nuova richiesta di supporto. */
public class RichiestaSupportoRequest {
    private final int teamId;
    private final int hackathonId;
    private final String msg;

    public RichiestaSupportoRequest(int teamId, int hackathonId, String msg) {
        this.teamId = teamId;
        this.hackathonId = hackathonId;
        this.msg = msg;
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
}
