package it.progetto.dto;

public class RispostaDTO {
    private final String messaggio;
    
    public RispostaDTO(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getMessaggio() {
        return messaggio;
    }
}
