package it.progetto.dto;

public class RichiesteSupportoDTO {
    private final int requestId;
    private final int hackathonId;
    private final String teamName;
    private final String categoria;
    private final String data;
    private final String stato;
    private final String descrizione;
    private final String disponibilita;
    private final String storico;

    public RichiesteSupportoDTO(
            int requestId,
            int hackathonId,
            String teamName,
            String categoria,
            String data,
            String stato,
            String descrizione,
            String disponibilita,
            String storico
    ) {
        this.requestId = requestId;
        this.hackathonId = hackathonId;
        this.teamName = teamName;
        this.categoria = categoria;
        this.data = data;
        this.stato = stato;
        this.descrizione = descrizione;
        this.disponibilita = disponibilita;
        this.storico = storico;
    }

    public int getRequestId() {
        return requestId;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getData() {
        return data;
    }

    public String getStato() {
        return stato;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getDisponibilita() {
        return disponibilita;
    }

    public String getStorico() {
        return storico;
    }

    @Override
    public String toString() {
        return "RichiesteSupportoDTO{" +
                "requestId=" + requestId +
                ", hackathonId=" + hackathonId +
                ", teamName='" + teamName + '\'' +
                ", categoria='" + categoria + '\'' +
                ", data='" + data + '\'' +
                ", stato='" + stato + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", disponibilita='" + disponibilita + '\'' +
                ", storico='" + storico + '\'' +
                '}';
    }
}
