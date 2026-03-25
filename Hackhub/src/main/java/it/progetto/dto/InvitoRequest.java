package it.progetto.dto;

public class InvitoRequest {
    private int utenteID;
    private int mittenteID;

    public InvitoRequest() {
    }

    public InvitoRequest(int utenteID, int mittenteID) {
        this.utenteID = utenteID;
        this.mittenteID = mittenteID;
    }

    public int getUtenteID() {
        return this.utenteID;
    }

    public void setUtenteID(int utenteID) {
        this.utenteID = utenteID;
    }

    public int getMittenteID() {
        return this.mittenteID;
    }

    public void setMittenteID(int mittenteID) {
        this.mittenteID = mittenteID;
    }
}
