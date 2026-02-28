package it.progetto.model;

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
    public Hackathon getResult() {
        // Restituisce l'oggetto finito
        Hackathon product = this.hackathon;
        // Prepara il builder per una eventuale nuova costruzione (come da esempio GoF)
        this.reset();
        return product;
    }
}