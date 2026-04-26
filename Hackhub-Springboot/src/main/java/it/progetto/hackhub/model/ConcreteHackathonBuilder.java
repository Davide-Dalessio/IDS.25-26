package it.progetto.hackhub.model;

import java.time.LocalDate;

public class ConcreteHackathonBuilder implements HackathonBuilder {
    private Hackathon hackathon;

    public ConcreteHackathonBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.hackathon = new Hackathon();
    }

    @Override
    public void setNome(String nome) {
        this.hackathon.setNome(nome);
    }

    @Override
    public void setDataInizio(LocalDate inizio) {
        this.hackathon.setDataInizio(inizio);
    }

    @Override
    public void setDataFine(LocalDate fine) {
        this.hackathon.setDataFine(fine);
    }

    @Override
    public void setPremio(double premio) {
        this.hackathon.setPremio(premio);
    }

    @Override
    public void setOrganizzatoreID(int id) {
        this.hackathon.setOrganizzatoreID(id);
    }

    @Override
    public void setStato(StatoHackathon stato) {
        this.hackathon.setStato(stato);
    }

    @Override
    public void setMaxMembriTeam(int max) {
        this.hackathon.setMaxMembriTeam(max);
    }

    @Override
    public void aggiungiMentore(Utente u) {
        this.hackathon.getMentori().add(u);
    }

    @Override
    public void aggiungiGiudice(Utente u) {
        this.hackathon.getGiudici().add(u);
    }

    @Override
    public Hackathon getResult() {
        Hackathon product = this.hackathon;
        this.reset();
        return product;
    }
}
