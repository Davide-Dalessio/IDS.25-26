package it.progetto.service;

import it.progetto.dto.RispostaDTO;
import it.progetto.dto.RispostaRequest;

public class RispostaService {

    public RispostaDTO requestRisposta(RispostaRequest request) {

        boolean utenteSano = checkUser(request.getInvitoId());

        if (!utenteSano) {

            throw new IllegalStateException("Utente gia' in team");
        }

        if (checkAccepted(request)) {

            int fakeMittenteId = 1;
            int fakeTeamId = getTeamByUtente(fakeMittenteId);

            addUtente(request.getInvitoId(), fakeTeamId);
        }

        deleteInvito(request.getInvitoId());

        return new RispostaDTO("Operazione di gestione invito completata e invito eliminato");
    }

    private boolean checkUser(int invitoId) {

        return invitoId != 999;
    }

    private boolean checkAccepted(RispostaRequest request) {
        return request.isAccetta();
    }

    private int getTeamByUtente(int utenteId) {

        return 42;
    }

    private void addUtente(int utenteId, int teamId) {

        System.out.println("RispostaService: Utente (" + utenteId + ") aggiunto fisicamente al Team (" + teamId
                + ") su Repository!");
    }

    private void deleteInvito(int invitoId) {

        System.out
                .println("RispostaService: Record Invito (" + invitoId + ") eliminato permanentemente dal Repository.");
    }
}
