package it.progetto.view;

import it.progetto.controller.AutenticazioneController;

public class IPaginaPrivata {
    private AutenticazioneController controller;

    public IPaginaPrivata() {
        this.controller = new AutenticazioneController();
    }

    public void selezionaLogout() {
        System.out.println("UI: L'utente ha selezionato l'opzione 'Logout'...");
        String vistaSuccessiva = controller.eseguiLogout();

        if ("REDIRECT:/home_pubblica".equals(vistaSuccessiva)) {
            IPaginaPubblica paginaPubblica = new IPaginaPubblica();
            paginaPubblica.load();
        }
    }
}
