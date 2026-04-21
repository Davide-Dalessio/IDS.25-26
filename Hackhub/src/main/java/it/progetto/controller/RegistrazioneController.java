package it.progetto.controller;

import it.progetto.dto.RegistrazioneRequest;
import it.progetto.dto.RegistrazioneDTO;
import it.progetto.service.RegistrazioneService;
import it.progetto.view.IRegistrazione;

public class RegistrazioneController {

    private final RegistrazioneService registrazioneService;
    private final IRegistrazione view;

    public RegistrazioneController(IRegistrazione view) {
        this.registrazioneService = new RegistrazioneService();
        this.view = view;
    }

    public RegistrazioneRequest createRequest(String nome, String email, String password) {
        return new RegistrazioneRequest(nome, email, password);
    }

    public void registraUtente(RegistrazioneRequest request) {
        try {
            RegistrazioneDTO registrazioneDTO = registrazioneService.processaRegistrazione(request);
            view.mostraConferma();
        } catch (IllegalArgumentException e) {
            view.mostraErrore(e.getMessage());
        }
    }

    public void sendDati(String nome, String email, String password) {
        RegistrazioneRequest request = createRequest(nome, email, password);
        registraUtente(request);
    }
}
