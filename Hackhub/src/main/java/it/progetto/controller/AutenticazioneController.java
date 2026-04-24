package it.progetto.controller;

import it.progetto.dto.LoginRequest;
import it.progetto.dto.LoginResponse;
import it.progetto.service.AutenticazioneService;

public class AutenticazioneController {
    private AutenticazioneService autenticazioneService;

    public AutenticazioneController() {
        this.autenticazioneService = new AutenticazioneService();
    }

    public String login(LoginRequest request) {
        LoginResponse response = autenticazioneService.eseguiLogin(request.getEmail(), request.getPassword());

        if (response.isSuccess()) {
            System.out.println("SYSTEM: Sessione creata per: " + response.getUtente().toString());
            return "REDIRECT:/dashboard";
        } else {
            System.out.println("SYSTEM: Mostra a schermo - " + response.getMessage());
            return "VIEW: login_form";
        }
    }
    public String eseguiLogout() {
        autenticazioneService.eseguiLogout();
        System.out.println("SYSTEM: Reindirizzamento alla pagina pubblica...");
        return "REDIRECT:/home_pubblica";
    }
}
