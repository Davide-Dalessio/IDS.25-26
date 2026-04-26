package it.progetto.hackhub.model;

public interface TeamBuilder {
    void reset();
    void setNome(String nome);
    void aggiungiMembroIniziale(Utente utente);
    Team getResult();
}
