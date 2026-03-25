package it.progetto.controller;

import it.progetto.dto.InvitoRequest;
import it.progetto.dto.InvitoDTO;
import it.progetto.service.InvitoService;
import it.progetto.model.Utente;

import java.util.List;

public class InvitoController {

    private InvitoService invitoService;

    public InvitoController() {
        this.invitoService = new InvitoService();
    }

    public List<Utente> cercaUtente(String nome) {
        return invitoService.eseguiRicerca(nome);
    }

    public InvitoDTO sendDatiInvito(int utenteID, int mittenteID) {
        try {
            InvitoRequest request = createInvito(utenteID, mittenteID);

            InvitoDTO result = invitoService.requestInvito(request);

            this.sendOK();

            return result;

        } catch (Exception e) {
            this.reportError(e.getMessage());
            return null;
        }
    }

    private InvitoRequest createInvito(int utenteID, int mittenteID) {
        return new InvitoRequest(utenteID, mittenteID);
    }

    private void reportError(String errorMessage) {
        System.out.println("InvitoController: Errore rilevato -> " + errorMessage);
    }

    private void sendOK() {
        System.out.println("InvitoController: Operazione completata con successo (OK)");
    }
}
