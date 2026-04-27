package it.progetto.hackhub.service;

import it.progetto.hackhub.model.Utente;

/**
 * Implementazione del pattern SINGLETON per la gestione della sessione.
 */
public class SessionManager {
    private static SessionManager instance;
    private Utente utenteLoggato;

    private SessionManager() {
        // Costruttore privato per impedire istanze multiple
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void creaSessione(Utente utente) {
        this.utenteLoggato = utente;
        System.out.println("   [SESSION MANAGER] Sessione creata per l'utente: " + utente.getNome());
    }

    public void invalidaSessione() {
        this.utenteLoggato = null;
        System.out.println("   [SESSION MANAGER] Sessione corrente invalidata con successo.");
    }

    public Utente getUtenteLoggato() {
        return utenteLoggato;
    }

    public boolean isSessioneAttiva() {
        return utenteLoggato != null;
    }
}
