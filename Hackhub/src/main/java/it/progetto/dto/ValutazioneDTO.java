package it.progetto.dto;

public class ValutazioneDTO {
    private final int valutazioneId;
    private final int submissionId;
    private final int giudiceId;
    private final String commento;
    private final int punteggio;
    private final String messaggio;

    public ValutazioneDTO(int valutazioneId, int submissionId, int giudiceId, String commento, int punteggio, String messaggio) {
        this.valutazioneId = valutazioneId;
        this.submissionId = submissionId;
        this.giudiceId = giudiceId;
        this.commento = commento;
        this.punteggio = punteggio;
        this.messaggio = messaggio;
    }

    public int getValutazioneId() {
        return valutazioneId;
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public int getGiudiceId() {
        return giudiceId;
    }

    public String getCommento() {
        return commento;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public String getMessaggio() {
        return messaggio;
    }

    @Override
    public String toString() {
        return "ValutazioneDTO{" +
                "valutazioneId=" + valutazioneId +
                ", submissionId=" + submissionId +
                ", giudiceId=" + giudiceId +
                ", commento='" + commento + '\'' +
                ", punteggio=" + punteggio +
                ", messaggio='" + messaggio + '\'' +
                '}';
    }
}
