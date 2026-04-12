package it.progetto.view;

import it.progetto.controller.ValutazioneController;
import it.progetto.dto.ValutazioneDTO;
import it.progetto.dto.ValutazioneRequest;

import java.util.List;

public class IValutazioneSottomissione {
    private final ValutazioneController controller;

    public IValutazioneSottomissione() {
        this.controller = new ValutazioneController();
    }

    public void valutaSottomissione(int giudiceId, int hackathonId, int submissionId, String commento, int punteggio) {
        try {
            System.out.println("Il Giudice accede al sistema e apre l'elenco degli hackathon.");

            List<Integer> hackathons = controller.requestAssignedHackathons(giudiceId);
            System.out.println("Hackathon assegnati al giudice: " + hackathons);

            System.out.println("Il Giudice seleziona l'hackathon: " + hackathonId);

            List<Integer> submissions = controller.getSubmissionsByHackathon(giudiceId, hackathonId);
            System.out.println("Sottomissioni disponibili per l'hackathon " + hackathonId + ": " + submissions);

            System.out.println("Il Giudice seleziona la sottomissione: " + submissionId);
            System.out.println("Il Giudice inserisce la valutazione e conferma.");

            ValutazioneRequest request = controller.createRequest(
                    giudiceId,
                    hackathonId,
                    submissionId,
                    commento,
                    punteggio
            );

            ValutazioneDTO dto = controller.requestEvaluation(request);

            System.out.println("Conferma: " + dto.getMessaggio());
            System.out.println(dto);

        } catch (IllegalArgumentException e) {
            System.out.println("ERRORE: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRORE GENERICO: " + e.getMessage());
        }
    }
}
