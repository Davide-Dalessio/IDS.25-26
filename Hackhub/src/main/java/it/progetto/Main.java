package it.progetto;

import it.progetto.view.ICreazioneTeam;

public class Main {
    public static void main(String[] args) {
        ICreazioneTeam interfacciaTeam = new ICreazioneTeam();

        // TEST 1: Utente ID 1 (Libero) -> Dovrebbe permettere la creazione
        System.out.println("--- TEST UTENTE LIBERO ---");
        interfacciaTeam.avviaCreazione();

        // TEST 2: Utente ID 10 (Occupato - simulato nel Service) -> Dovrebbe bloccare
        System.out.println("\n--- TEST UTENTE GIÀ IN TEAM ---");
        interfacciaTeam.avviaCreazione();
    }
}