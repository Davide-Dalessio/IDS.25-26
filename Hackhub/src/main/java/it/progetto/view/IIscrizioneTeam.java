package it.progetto.view;

import it.progetto.controller.IscrizioneController;
import it.progetto.dto.IscrizioneDTO;

public class IIscrizioneTeam {
    private final IscrizioneController controller;

    public IIscrizioneTeam() {
        this.controller = new IscrizioneController();
    }

    public void iscriviTeam(int teamId, int hackathonId) {
        try {
            IscrizioneDTO dto = controller.iscriviTeam(teamId, hackathonId);
            showOK(dto);
        } catch (IllegalStateException e) {
            showError(e.getMessage());
        }
    }

    private void showOK(IscrizioneDTO dto) {
        System.out.println("Iscrizione effettuata!");
        System.out.println("Team " + dto.getTeamId() + " iscritto all'hackathon " + dto.getHackathonId());
        System.out.println("Stato: " + dto.getStato());
        System.out.println("Data iscrizione: " + dto.getDataIscrizione());
    }

    private void showError(String message) {
        System.out.println("Errore: " + message);
    }
}
