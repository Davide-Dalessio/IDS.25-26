package it.progetto.view;

import it.progetto.controller.RichiesteSupportoController;
import it.progetto.dto.RichiesteSupportoDTO;
import it.progetto.dto.RichiesteSupportoRequest;

import java.util.List;

public class IVisualizzaRichiesteSupporto {
    private final RichiesteSupportoController controller;

    public IVisualizzaRichiesteSupporto() {
        this.controller = new RichiesteSupportoController();
    }

    public void visualizzaRichiesteSupporto(int mentorId, int hackathonId, int requestId) {
        try {
            System.out.println("Il Mentore accede al sistema e apre la sezione 'Richieste di supporto'.");

            List<Integer> hackathons = controller.requestAssignedHackathons(mentorId);
            System.out.println("Hackathon assegnati al mentore: " + hackathons);

            System.out.println("Il Mentore seleziona l'hackathon: " + hackathonId);

            RichiesteSupportoRequest request = controller.createRequest(mentorId, hackathonId, requestId);

            List<Integer> requests = controller.requestSupportRequests(request);
            System.out.println("Elenco richieste di supporto per hackathon " + hackathonId + ": " + requests);

            System.out.println("Il Mentore seleziona la richiesta: " + requestId);

            RichiesteSupportoDTO details = controller.getSupportRequestDetails(request);

            System.out.println("Dettagli richiesta:");
            System.out.println(details);

        } catch (IllegalArgumentException e) {
            System.out.println("ERRORE: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRORE GENERICO: " + e.getMessage());
        }
    }
}
