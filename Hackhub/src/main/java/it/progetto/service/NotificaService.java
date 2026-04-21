package it.progetto.service;

public class NotificaService {

    public void inviaNotifica(String messaggio, int utenteId) {
        System.out.println("   [DB - NOTIFICA SERVICE] Salvata notifica per Utente ID " + utenteId + ": " + messaggio);
    }
}
