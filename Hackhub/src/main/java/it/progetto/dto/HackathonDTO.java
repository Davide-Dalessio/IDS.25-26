package it.progetto.dto;

import java.time.LocalDate;

public class HackathonDTO {
    private final String nome;
    private final LocalDate dataInizio;
    private final LocalDate dataFine;
    private final double premio;
    private final int organizzatoreID;

    public HackathonDTO(String nome, LocalDate dataInizio, LocalDate dataFine, double premio, int organizzatoreID) {
        this.nome = nome;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.premio = premio;
        this.organizzatoreID = organizzatoreID;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public double getPremio() {
        return premio;
    }

    public int getOrganizzatoreID() {
        return organizzatoreID;
    }
}
