package it.progetto.model;

public interface ValutazioneBuilder {
    void reset();

    void setIds(int valutazioneId, int giudiceId, int hackathonId, int submissionId);

    void setGiudizio(int punteggio, String commento);

    Valutazione getResult();
}
