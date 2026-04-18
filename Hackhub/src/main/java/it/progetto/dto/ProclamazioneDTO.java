package it.progetto.dto;

public class ProclamazioneDTO {
    private final int hackathonId;
    private final int teamId;
    private final boolean pagamentoEseguito;
    private final String messaggio;

    public ProclamazioneDTO(int hackathonId, int teamId, boolean pagamentoEseguito, String messaggio) {
        this.hackathonId = hackathonId;
        this.teamId = teamId;
        this.pagamentoEseguito = pagamentoEseguito;
        this.messaggio = messaggio;
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

    public String getMessaggio() {
        return messaggio;
    }

    @Override
    public String toString() {
        return "ProclamazioneDTO{" +
                "hackathonId=" + hackathonId +
                ", teamId=" + teamId +
                ", pagamentoEseguito=" + pagamentoEseguito +
                ", messaggio='" + messaggio + '\'' +
                '}';
    }
}
