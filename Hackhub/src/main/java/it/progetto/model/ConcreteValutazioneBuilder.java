package it.progetto.model;

public class ConcreteValutazioneBuilder implements ValutazioneBuilder {
    private int valutazioneId;
    private int giudiceId;
    private int hackathonId;
    private int submissionId;
    private String commento;
    private int punteggio;

    @Override
    public void reset() {
        this.valutazioneId = 0;
        this.giudiceId = 0;
        this.hackathonId = 0;
        this.submissionId = 0;
        this.commento = null;
        this.punteggio = 0;
    }

    @Override
    public void setIds(int valutazioneId, int giudiceId, int hackathonId, int submissionId) {
        this.valutazioneId = valutazioneId;
        this.giudiceId = giudiceId;
        this.hackathonId = hackathonId;
        this.submissionId = submissionId;
    }

    @Override
    public void setGiudizio(int punteggio, String commento) {
        this.punteggio = punteggio;
        this.commento = commento;
    }

    @Override
    public Valutazione getResult() {
        return new Valutazione(valutazioneId, giudiceId, hackathonId, submissionId, commento, punteggio);
    }
}
