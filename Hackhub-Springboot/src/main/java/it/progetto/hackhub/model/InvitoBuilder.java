package it.progetto.hackhub.model;

public interface InvitoBuilder {
    void reset();
    void setMittente(int mittenteID);
    void setUtenteInvitato(int utenteID);
    Invito getResult();
}
