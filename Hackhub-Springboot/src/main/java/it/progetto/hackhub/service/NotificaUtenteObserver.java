package it.progetto.hackhub.service;

import it.progetto.hackhub.model.IObserver;

public class NotificaUtenteObserver implements IObserver {
    private final int utenteId;
    private final NotificaService notificaService = new NotificaService();

    public NotificaUtenteObserver(int utenteId) {
        this.utenteId = utenteId;
    }

    @Override
    public void update(String messaggio) {
        notificaService.inviaNotifica(messaggio, utenteId);
    }
}
