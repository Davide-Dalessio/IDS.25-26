package it.progetto.controller;

import it.progetto.dto.RispostaDTO;
import it.progetto.dto.RispostaRequest;
import it.progetto.service.RispostaService;

public class RispostaController {

    private RispostaService rispostaService;

    public RispostaController() {
        this.rispostaService = new RispostaService();
    }

    public RispostaDTO sendRisposta(int invitoId, boolean accetta) {
        try {

            RispostaRequest request = new RispostaRequest(invitoId, accetta);

            RispostaDTO dto = rispostaService.requestRisposta(request);

            sendOK();
            return dto;

        } catch (IllegalStateException e) {

            reportError(e.getMessage());
            return new RispostaDTO("Errore: " + e.getMessage());
        } catch (Exception e) {
            reportError("Errore imprevisto");
            return new RispostaDTO("Errore di sistema");
        }
    }

    private void sendOK() {
        System.out.println("RispostaController: OK - Operazione Invito Processata");
    }

    private void reportError(String msg) {
        System.out.println("RispostaController: Impossibile procedere -> " + msg);
    }
}
