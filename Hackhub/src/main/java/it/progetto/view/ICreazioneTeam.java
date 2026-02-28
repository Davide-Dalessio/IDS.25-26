package it.progetto.view;

import it.progetto.controller.TeamController;
import java.util.Scanner;

public class ICreazioneTeam {
    private final TeamController controller;
    private final Scanner scanner;

    public ICreazioneTeam() {
        this.controller = new TeamController();
        this.scanner = new Scanner(System.in);
    }

    // Punto 1 del FOE: L'utente avvia la procedura
    public void avviaCreazione() {
        System.out.println("=== SISTEMA CREAZIONE TEAM ===");
        System.out.print("Inserisci il tuo ID Utente per verificare l'eleggibilità: ");
        int utenteID = scanner.nextInt();
        scanner.nextLine(); // Pulisce il buffer

        // FASE 1 & 2 del Sequence: checkValidUtente -> allowCreation
        if (controller.checkValidUtente(utenteID)) {
            System.out.println("Verifica superata: Puoi creare un team.");
            this.allowCreation(utenteID);
        } else {
            // Se il controller ha restituito false (o catturato eccezione)
            System.out.println("Accesso negato: Non puoi procedere con la creazione.");
        }
    }

    // Messaggio: allowCreation (dal Controller o chiamata interna condizionata)
    public void allowCreation(int utenteID) {
        this.viewModulo(utenteID);
    }

    // Messaggio: viewModulo() -> Mostra i campi all'utente
    private void viewModulo(int utenteID) {
        System.out.println("\n--- MODULO TEAM ---");
        System.out.print("Inserisci il nome del nuovo Team: ");
        String nomeTeam = scanner.nextLine();

        // Messaggio: sendDati(dati, utenteID)
        System.out.println("Invio dati in corso...");
        controller.sendDati(nomeTeam, utenteID);
    }
}