package it.progetto.model;

public class Invito {
    private int mittenteID;
    private int utenteID;

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
}
