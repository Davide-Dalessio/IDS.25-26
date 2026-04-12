package it.progetto.view;

import it.progetto.controller.AccessoSottomissioniController;
import it.progetto.dto.AccessoSottomissioniDTO;
import it.progetto.dto.AccessoSottomissioniRequest;

import java.util.List;

public class IAccedereSottomissioni {
    private final AccessoSottomissioniController controller;

    public IAccedereSottomissioni() {
        this.controller = new AccessoSottomissioniController();
    }

    public void accediAlleSottomissioni(int staffId, int hackathonId, int teamId) {
        try {
            System.out.println("Il Membro dello Staff accede al sistema e apre l'elenco degli hackathon.");

            List<Integer> hackathons = controller.requestHackathonList(staffId);
            System.out.println("Elenco hackathon: " + hackathons);

            System.out.println("Il Membro dello Staff seleziona l'hackathon: " + hackathonId);

            AccessoSottomissioniRequest accessRequest = controller.createRequest(hackathonId, staffId, teamId);

            List<Integer> teams = controller.requestHackathonAccess(accessRequest);
            System.out.println("Team iscritti all'hackathon " + hackathonId + ": " + teams);

            System.out.println("Il Membro dello Staff seleziona il team: " + teamId);

            AccessoSottomissioniDTO dto = controller.getSubmission(accessRequest);

            System.out.println("Conferma: " + dto.getMessaggio());
            System.out.println("Sottomissione associata al team selezionato: " + dto.getSubmissionLink());
            System.out.println(dto);

        } catch (IllegalArgumentException e) {
            System.out.println("ERRORE: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRORE GENERICO: " + e.getMessage());
        }
    }
}
