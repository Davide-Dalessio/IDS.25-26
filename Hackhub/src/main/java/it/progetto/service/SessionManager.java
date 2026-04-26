package it.progetto.service;

import it.progetto.model.Utente;

public class SessionManager {
    private static SessionManager instance;

    private SessionManager() {
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void creaSessione(Utente utente) {
        System.out.println("   [SESSION MANAGER] Sessione creata per l'utente: " + utente.getNome());
    }

    public void invalidaSessione() {
        System.out.println("   [SESSION MANAGER] Sessione corrente invalidata con successo.");
    }
}
