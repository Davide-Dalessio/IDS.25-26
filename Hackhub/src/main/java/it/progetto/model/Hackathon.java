package it.progetto.model;

import java.time.LocalDate;

public class Hackathon {
    private String nome;
    private LocalDate dataInizio, dataFine;
    private double premio;
    private int organizzatoreID;
    private StatoHackathon stato;
    private int maxMembriTeam;

    public Hackathon() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public void setOrganizzatoreID(int organizzatoreID) {
        this.organizzatoreID = organizzatoreID;
    }

    public void setStato(StatoHackathon stato) {
        this.stato = stato;
    }
    
    public void setMaxMembriTeam(int maxMembriTeam) {
        this.maxMembriTeam = maxMembriTeam;
    }

    public String getNome() {
        return this.nome;
    }

    public LocalDate getDataInizio() {
        return this.dataInizio;
    }

    public LocalDate getDataFine() {
        return this.dataFine;
    }

    public double getPremio() {
        return this.premio;
    }

    public int getOrganizzatoreID() {
        return this.organizzatoreID;
    }

    public StatoHackathon getStato() {
        return this.stato;
    }


    public int getMaxMembriTeam() {
        return this.maxMembriTeam;
    }

}
