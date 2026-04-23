package it.progetto.dto;

import it.progetto.model.Utente;

public class LoginResponse {
    private boolean success;
    private String message;
    private Utente utente;

    public LoginResponse(boolean success, String message, Utente utente) {
        this.success = success;
        this.message = message;
        this.utente = utente;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public Utente getUtente() { return utente; }
}
