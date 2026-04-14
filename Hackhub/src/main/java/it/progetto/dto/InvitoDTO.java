package it.progetto.dto;

public class InvitoDTO {
    private final int mittenteID;
    private final int utenteID;

    public InvitoDTO(int mittenteID, int utenteID) {
        this.mittenteID = mittenteID;
        this.utenteID = utenteID;
    }

    public int getMittenteID() {
        return this.mittenteID;
    }

    public int getUtenteID() {
        return this.utenteID;
    }
}
