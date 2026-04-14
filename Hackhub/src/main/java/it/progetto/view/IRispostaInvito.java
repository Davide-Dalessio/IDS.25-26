package it.progetto.view;

import it.progetto.controller.RispostaController;
import it.progetto.dto.RispostaDTO;

import java.util.Scanner;

public class IRispostaInvito {

    private RispostaController controller;
    private Scanner scanner;

    public IRispostaInvito() {
        this.controller = new RispostaController();
        this.scanner = new Scanner(System.in);
    }

    public void showInviti() {
        System.out.println("=== I TUOI INVITI ===");

        System.out.println("1) Invito per entrare nel Team Alpha (ID Invito: 101)");
        System.out.println("2) Invito per entrare nel Team Beta (ID Invito: 102)");

        System.out.print("Inserisci l'ID dell'invito a cui vuoi rispondere: ");
        int invitoId = scanner.nextInt();

        System.out.print("Vuoi accettare l'invito? (S/N): ");
        String rispostaStr = scanner.next();

        boolean accetta = rispostaStr.trim().equalsIgnoreCase("S");

        this.sendRisposta(invitoId, accetta);
    }

    private void sendRisposta(int invitoId, boolean accetta) {
        System.out.println("\n[UI] Elaborazione della risposta in corso...");

        RispostaDTO result = controller.sendRisposta(invitoId, accetta);

        this.showFeedback(result.getMessaggio());
    }

    private void showFeedback(String messaggio) {
        System.out.println("=== ESITO OPERAZIONE ===");
        System.out.println(messaggio);
        System.out.println("========================\n");
    }
}
