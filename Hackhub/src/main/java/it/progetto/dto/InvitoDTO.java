package it.progetto.dto;

public class InvitoDTO {
    private final int mittenteID;
    private final int utenteID;
    private final String stato;

    public InvitoDTO(int mittenteID, int utenteID, String stato) {
        this.mittenteID = mittenteID;
        this.utenteID = utenteID;
        this.stato = stato;
    }

    public int getMittenteID() {
        return this.mittenteID;
    }

    public int getUtenteID() {
        return this.utenteID;
    }

    public String getStato() {
        return this.stato;
    }
}
