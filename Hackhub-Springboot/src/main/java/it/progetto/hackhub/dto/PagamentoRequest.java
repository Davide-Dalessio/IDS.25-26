package it.progetto.hackhub.dto;

public class PagamentoRequest {
    private String iban;
    private String intestatario;
    private int hackathonId;

    public PagamentoRequest() {
    }

    public PagamentoRequest(String iban, String intestatario, int hackathonId) {
        this.iban = iban;
        this.intestatario = intestatario;
        this.hackathonId = hackathonId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getIntestatario() {
        return intestatario;
    }

    public void setIntestatario(String intestatario) {
        this.intestatario = intestatario;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public void setHackathonId(int hackathonId) {
        this.hackathonId = hackathonId;
    }
}
