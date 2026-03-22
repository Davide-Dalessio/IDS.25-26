package it.progetto;

import it.progetto.view.ICreazioneTeam;
import it.progetto.view.CallView;
import it.progetto.view.PrenotazioneSlotUI;

public class Main {
    public static void main(String[] args) {
        ICreazioneTeam interfacciaTeam = new ICreazioneTeam();

        // TEST 1: Utente ID 1 (Libero) -> Dovrebbe permettere la creazione
        System.out.println("--- TEST UTENTE LIBERO ---");
        interfacciaTeam.avviaCreazione();

        // TEST 2: Utente ID 10 (Occupato - simulato nel Service) -> Dovrebbe bloccare
        System.out.println("\n--- TEST UTENTE GIÀ IN TEAM ---");
        interfacciaTeam.avviaCreazione();

        // ===============================
        // TEST PRENOTAZIONE CALL
        // ===============================

        CallView callView = new CallView();

        System.out.println("\n--- TEST PRENOTAZIONE CALL VALIDA ---");
        callView.submitCallData(
                1,
                10,
                100,
                "30 minuti",
                "Supporto progetto",
                "2026-03-25"
        );

        System.out.println("\n--- TEST PRENOTAZIONE CALL NON VALIDA ---");
        callView.submitCallData(
                999,
                10,
                100,
                "30 minuti",
                "Errore test",
                "2026-03-25"
        );

        // ===============================
        // TEST PRENOTAZIONE SLOT
        // ===============================

        PrenotazioneSlotUI slotUI = new PrenotazioneSlotUI();

        System.out.println("\n--- TEST PRENOTAZIONE SLOT VALIDO ---");
        slotUI.selectSlot(
                1,
                1,
                5
        );

        System.out.println("\n--- TEST SLOT GIÀ PRENOTATO ---");
        slotUI.selectSlot(
                1,
                1,
                5
        );
    }
}