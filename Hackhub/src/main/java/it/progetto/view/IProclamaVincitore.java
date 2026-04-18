package it.progetto.view;

import it.progetto.controller.ProclamazioneController;
import it.progetto.dto.ProclamazioneDTO;
import it.progetto.dto.ProclamazioneRequest;

import java.util.List;

public class IProclamaVincitore {
    private final ProclamazioneController controller;

    public IProclamaVincitore() {
        this.controller = new ProclamazioneController();
    }

    public void proclamaVincitore(int organizzatoreId, int hackathonId, int teamId) {
        try {
            System.out.println("L'Organizzatore apre la pagina di dettaglio di un hackathon.");
            System.out.println("L'Organizzatore seleziona 'Proclama vincitore'.");

            List<String> teamList = controller.prepareProclamation(organizzatoreId, hackathonId);
            System.out.println("Elenco team con valutazioni:");
            for (String team : teamList) {
                System.out.println(" - " + team);
            }

            System.out.println("L'Organizzatore seleziona il team vincitore: " + teamId);
            System.out.println("L'Organizzatore conferma la proclamazione.");

            ProclamazioneRequest request = controller.createRequest(organizzatoreId, hackathonId, teamId);
            ProclamazioneDTO dto = controller.proclaimWinner(request);

            System.out.println("Conferma: " + dto.getMessaggio());
            System.out.println(dto);

        } catch (IllegalArgumentException e) {
            System.out.println("ERRORE: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRORE GENERICO: " + e.getMessage());
        }
    }
}
