package it.progetto.dto;

import java.time.LocalDate;

public class IscrizioneDTO {
    private final int teamId;
    private final int hackathonId;
    private final String stato;
    private final LocalDate dataIscrizione;

    public IscrizioneDTO(int teamId, int hackathonId, String stato, LocalDate dataIscrizione) {
        this.teamId = teamId;
        this.hackathonId = hackathonId;
        this.stato = stato;
        this.dataIscrizione = dataIscrizione;
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

    public LocalDate getDataIscrizione() {
        return dataIscrizione;
    }
}
