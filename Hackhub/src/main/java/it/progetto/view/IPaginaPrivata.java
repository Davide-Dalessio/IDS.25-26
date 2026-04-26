package it.progetto.view;

import it.progetto.controller.AutenticazioneController;

public class IPaginaPrivata {
    private AutenticazioneController controller;

    public IPaginaPrivata() {
        this.controller = new AutenticazioneController();
    }

    public void logout() {
        System.out.println("UI: L'utente ha selezionato l'opzione 'Logout'...");
        String vistaSuccessiva = controller.logout();

        if ("REDIRECT:/home_pubblica".equals(vistaSuccessiva)) {
            IPaginaPubblica paginaPubblica = new IPaginaPubblica();
            paginaPubblica.load();
        }
    }
}
