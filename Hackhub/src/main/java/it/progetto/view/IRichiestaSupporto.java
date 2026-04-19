package it.progetto.view;

import it.progetto.controller.RichiestaSupportoController;
import it.progetto.dto.RichiestaSupportoDTO;
import it.progetto.dto.RichiestaSupportoRequest;

import java.util.Scanner;

public class IRichiestaSupporto {

    private final RichiestaSupportoController controller;
    private final Scanner scanner = new Scanner(System.in);

    public IRichiestaSupporto() {
        this.controller = new RichiestaSupportoController();
    }

    public void richiediSupporto(int teamId, int hackathonId) {
        try {
            controller.checkDati(teamId, hackathonId);
        } catch (IllegalStateException e) {
            System.out.println("Errore: " + e.getMessage());
            return;
        }

        showModulo();

        System.out.print("Inserisci il messaggio di supporto: ");
        String msg = scanner.nextLine();

        sendRichiesta(teamId, hackathonId, msg);
    }

    private void showModulo() {
        System.out.println("IRichiestaSupporto: Compilare il modulo di richiesta.");
    }

    private void sendRichiesta(int teamId, int hackathonId, String msg) {
        RichiestaSupportoRequest request = controller.createRichiesta(teamId, hackathonId, msg);
        RichiestaSupportoDTO dto = controller.requestRichiesta(request);
        System.out.println("IRichiestaSupporto: Richiesta inviata. Stato: " + dto.getStato());
    }
}
