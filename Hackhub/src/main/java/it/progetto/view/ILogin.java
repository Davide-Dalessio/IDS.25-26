package it.progetto.view;

import it.progetto.controller.AutenticazioneController;
import it.progetto.dto.LoginRequest;

public class ILogin {
    private AutenticazioneController controller;

    public ILogin() {
        this.controller = new AutenticazioneController();
    }

    public void inserisciCredenziali(String email, String password) {
        System.out.println("UI: Invio credenziali per l'email '" + email + "'...");

        LoginRequest request = new LoginRequest(email, password);
        String vistaSuccessiva = controller.login(request);

        if ("REDIRECT:/dashboard".equals(vistaSuccessiva)) {
            System.out.println("UI: Login completato con successo. Reindirizzamento alla Dashboard.");
        } else {
            System.out.println("UI: Ricaricamento del modulo di accesso (errore mostrato all'utente).");
        }
    }
}
