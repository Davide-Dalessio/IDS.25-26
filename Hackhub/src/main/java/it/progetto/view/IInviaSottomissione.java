package it.progetto.view;

import it.progetto.controller.SottomissioneController;
import it.progetto.dto.SottomissioneDTO;
import java.util.Scanner;

public class IInviaSottomissione {
    private final SottomissioneController controller;
    private final Scanner scanner;

    public IInviaSottomissione() {
        this.controller = new SottomissioneController();
        this.scanner = new Scanner(System.in);
    }

    public void inviaSottomissione(int teamId, int hackathonId) {
        try {
            controller.checkValido(teamId, hackathonId);
        } catch (IllegalStateException e) {
            showError(e.getMessage());
            return;
        }
        mostraModulo(teamId, hackathonId);
    }

    private void mostraModulo(int teamId, int hackathonId) {
        System.out.println("--- MODULO SOTTOMISSIONE ---");
        System.out.print("Inserisci il link della sottomissione: ");
        String link = scanner.nextLine();
        sendDati(teamId, hackathonId, link);
    }

    private void sendDati(int teamId, int hackathonId, String link) {
        try {
            SottomissioneDTO dto = controller.sendDati(teamId, hackathonId, link);
            sendOK(dto);
        } catch (IllegalStateException e) {
            showError(e.getMessage());
        }
    }

    private void sendOK(SottomissioneDTO dto) {
        System.out.println("Sottomissione inviata!");
        System.out.println("Team: " + dto.getTeamId() + " | Hackathon: " + dto.getHackathonId());
        System.out.println("Link: " + dto.getLink());
    }

    private void showError(String message) {
        System.out.println("Errore: " + message);
    }
}
