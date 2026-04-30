package it.progetto.hackhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ricevuta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int hackathonId;
    private String iban;
    private double importoErogato;

    public Ricevuta() {
    }

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

    public void setHackathonId(int hackathonId) {
        this.hackathonId = hackathonId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getImportoErogato() {
        return importoErogato;
    }

    public void setImportoErogato(double importoErogato) {
        this.importoErogato = importoErogato;
    }
}
