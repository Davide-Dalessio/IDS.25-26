package it.progetto.model;

import java.time.LocalDate;

public class Partecipazione {
    private final int teamId;
    private final int hackathonId;
    private final String stato;
    private final LocalDate dataIscrizione;

    public Partecipazione(int teamId, int hackathonId) {
        this.teamId = teamId;
        this.hackathonId = hackathonId;
        this.stato = "iscritto";
        this.dataIscrizione = LocalDate.now();
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

    @Override
    public String toString() {
        return "Partecipazione{" +
                "teamId=" + teamId +
                ", hackathonId=" + hackathonId +
                ", stato='" + stato + '\'' +
                ", dataIscrizione=" + dataIscrizione +
                '}';
    }
}
