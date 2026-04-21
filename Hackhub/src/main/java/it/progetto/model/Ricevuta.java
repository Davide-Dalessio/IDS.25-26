package it.progetto.model;

public class Ricevuta {
    private int id;
    private int hackathonId;
    private String iban;
    private double importoErogato;

    public Ricevuta(int hackathonId, String iban, double importoErogato) {
        this.hackathonId = hackathonId;
        this.iban = iban;
        this.importoErogato = importoErogato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public String getIban() {
        return iban;
    }

    public double getImportoErogato() {
        return importoErogato;
    }
}
