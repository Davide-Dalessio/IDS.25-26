package it.progetto.dto;

public class ValutazioneRequest {
    private final int giudiceId;
    private final int hackathonId;
    private final int submissionId;
    private final String commento;
    private final int punteggio;

    public ValutazioneRequest(int giudiceId, int hackathonId, int submissionId, String commento, int punteggio) {
        this.giudiceId = giudiceId;
        this.hackathonId = hackathonId;
        this.submissionId = submissionId;
        this.commento = commento;
        this.punteggio = punteggio;
    }

    public int getGiudiceId() {
        return giudiceId;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public String getCommento() {
        return commento;
    }

    public int getPunteggio() {
        return punteggio;
    }
}
