package it.progetto.service;

import it.progetto.model.IObserver;

public class SistemaNotificaVincitori implements IObserver {

    private final NotificaService notificaService = new NotificaService();

    @Override
    public void update(String data) {
        int hackathonId = Integer.parseInt(data);

        int teamVincitoreId = getTeamVincitore(hackathonId);

        java.util.List<it.progetto.model.Utente> membriTeam = getMembriTeam(teamVincitoreId);

        String msg = "Hai vinto l'Hackathon #" + hackathonId;
        for (it.progetto.model.Utente utente : membriTeam) {
            notificaService.inviaNotifica(msg, utente.getId());
        }
    }

    private int getTeamVincitore(int hackathonId) {
        return 99;
    }

    private java.util.List<it.progetto.model.Utente> getMembriTeam(int teamId) {
        return java.util.Arrays.asList(
                new it.progetto.model.Utente(1, "Mario", "mario@email.it"),
                new it.progetto.model.Utente(2, "Luigi", "luigi@email.it"));
    }
}
