package it.progetto.hackhub.model;

import java.time.LocalDate;

public interface HackathonBuilder {
    void reset();
    void setNome(String nome);
    void setDataInizio(LocalDate inizio);
    void setDataFine(LocalDate fine);
    void setPremio(double premio);
    void setOrganizzatoreID(int id);
    void setStato(StatoHackathon stato);
    void setMaxMembriTeam(int max);
    void aggiungiMentore(Utente u);
    void aggiungiGiudice(Utente u);
    Hackathon getResult();
}
