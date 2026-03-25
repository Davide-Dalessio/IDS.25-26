package it.progetto.model;

public class Invito {
    private int mittenteID;
    private int utenteID;
    private String stato;

    public Invito() {
    }

    public int getMittenteID() {
        return this.mittenteID;
    }

    public void setMittenteID(int mittenteID) {
        this.mittenteID = mittenteID;
    }

    public int getUtenteID() {
        return this.utenteID;
    }

    public void setUtenteID(int utenteID) {
        this.utenteID = utenteID;
    }

    public String getStato() {
        return this.stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
}
