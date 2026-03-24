package it.progetto.model;

public class ConcreteTeamBuilder implements TeamBuilder {
    private Team team;

    public ConcreteTeamBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.team = new Team();
    }

    @Override
    public void setNome(String nome) {
        this.team.setNome(nome);
    }

    @Override
    public void aggiungiMembroIniziale(Utente utente) {
        this.team.aggiungiMembro(utente);
    }

    @Override
    public Team getResult() {
        Team product = this.team;
        this.reset();
        return product;
    }
}