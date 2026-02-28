package it.progetto.view;

import it.progetto.controller.HackathonController;
import java.util.Scanner;

public class ICreazioneHackathon {
    private final HackathonController controller;

    public ICreazioneHackathon() {
        this.controller = new HackathonController();
    }


    public void viewModulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- MODULO CREAZIONE HACKATHON ---");

        System.out.print("Inserisci nome: ");
        String nome = scanner.nextLine();

        System.out.print("Inserisci data inizio (AAAA-MM-GG): ");
        String inizio = scanner.nextLine();

        System.out.print("Inserisci data fine (AAAA-MM-GG): ");
        String fine = scanner.nextLine();

        System.out.print("Inserisci premio: ");
        double premio = scanner.nextDouble();

        System.out.print("Inserisci il tuo ID Organizzatore: ");
        int id = scanner.nextInt();

        // MESSAGGIO: sendDati(dati, utenteID)
        controller.sendDati(nome, inizio, fine, premio, id);
    }
}