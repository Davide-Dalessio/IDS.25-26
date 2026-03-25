package it.progetto.model;

public interface InvitoBuilder {
    void reset();

    void setMittente(int mittenteID);

    void setUtenteInvitato(int utenteID);

    void setStatoIniziale();

    Invito getResult();
}
