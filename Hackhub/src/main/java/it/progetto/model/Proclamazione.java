package it.progetto.model;

public class Proclamazione {
    private final int organizzatoreId;
    private final int hackathonId;
    private final int teamId;
    private final boolean pagamentoEseguito;

    public Proclamazione(int organizzatoreId, int hackathonId, int teamId, boolean pagamentoEseguito) {
        this.organizzatoreId = organizzatoreId;
        this.hackathonId = hackathonId;
        this.teamId = teamId;
        this.pagamentoEseguito = pagamentoEseguito;
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

    public boolean isPagamentoEseguito() {
        return pagamentoEseguito;
    }
}
