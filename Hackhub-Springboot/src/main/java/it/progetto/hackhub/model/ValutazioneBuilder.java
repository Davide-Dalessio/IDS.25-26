package it.progetto.hackhub.model;

public interface ValutazioneBuilder {
    void reset();
    void setIds(int giudiceId, int hackathonId, int submissionId);
    void setGiudizio(int punteggio, String commento);
    Valutazione getResult();
}
