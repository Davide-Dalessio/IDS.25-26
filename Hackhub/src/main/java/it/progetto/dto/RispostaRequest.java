package it.progetto.dto;

public class RispostaRequest {
    private int invitoId;
    private boolean accetta;

    public RispostaRequest() {
    }

    public RispostaRequest(int invitoId, boolean accetta) {
        this.invitoId = invitoId;
        this.accetta = accetta;
    }

    public int getInvitoId() {
        return invitoId;
    }

    public void setInvitoId(int invitoId) {
        this.invitoId = invitoId;
    }

    public boolean isAccetta() {
        return accetta;
    }

    public void setAccetta(boolean accetta) {
        this.accetta = accetta;
    }
}
