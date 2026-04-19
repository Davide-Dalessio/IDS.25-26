package it.progetto.dto;

/** DTO di risposta restituito al Membro del Team dopo la creazione della richiesta di supporto. */
public class RichiestaSupportoDTO {
    private final int teamId;
    private final int hackathonId;
    private final String stato;

    public RichiestaSupportoDTO(int teamId, int hackathonId, String stato) {
        this.teamId = teamId;
        this.hackathonId = hackathonId;
        this.stato = stato;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public String getStato() {
        return stato;
    }
}
