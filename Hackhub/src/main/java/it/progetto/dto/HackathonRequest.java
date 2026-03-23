package it.progetto.dto;

public class HackathonRequest {
    private String nome;
    private String dataInizio;
    private String dataFine;
    private double premio;
    private int organizzatoreID;

    public HackathonRequest(String nome, String dataInizio, String dataFine, double premio, int organizzatoreID) {
        this.nome = nome;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.premio = premio;
        this.organizzatoreID = organizzatoreID;
    }

    public HackathonRequest() {
    }

    public String getNome() {
        return nome;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public double getPremio() {
        return premio;
    }

    public int getOrganizzatoreID() {
        return organizzatoreID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public void setOrganizzatoreID(int organizzatoreID) {
        this.organizzatoreID = organizzatoreID;
    }
}