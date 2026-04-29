package it.progetto.hackhub.model;

public class ConcreteValutazioneBuilder implements ValutazioneBuilder {
    private int giudiceId;
    private int hackathonId;
    private int submissionId;
    private String commento;
    private int punteggio;

    @Override
    public void reset() {
        this.giudiceId = 0;
        this.hackathonId = 0;
        this.submissionId = 0;
        this.commento = null;
        this.punteggio = 0;
    }

    @Override
    public void setIds(int giudiceId, int hackathonId, int submissionId) {
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
        Valutazione result = new Valutazione(giudiceId, hackathonId, submissionId, commento, punteggio);
        this.reset();
        return result;
    }
}
