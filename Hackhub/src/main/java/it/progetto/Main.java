package it.progetto;

import it.progetto.view.ICreazioneTeam;
import it.progetto.view.CallView;
import it.progetto.view.PrenotazioneSlotUI;
import it.progetto.view.IIscrizioneTeam;
import it.progetto.view.IInviaSottomissione;
import it.progetto.view.IValutazioneSottomissione;
import it.progetto.view.IAccedereSottomissioni;
import it.progetto.view.IProclamaVincitore;

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

        // ===============================
        // TEST ISCRIZIONE TEAM AD HACKATHON
        // ===============================

        IIscrizioneTeam iscrizioneUI = new IIscrizioneTeam();

        System.out.println("\n--- TEST ISCRIZIONE VALIDA ---");
        iscrizioneUI.iscriviTeam(1, 1);

        System.out.println("\n--- TEST TEAM GIÀ ISCRITTO ---");
        iscrizioneUI.iscriviTeam(1, 1);

        System.out.println("\n--- TEST ISCRIZIONI CHIUSE ---");
        iscrizioneUI.iscriviTeam(1, 2);

        System.out.println("\n--- TEST DIMENSIONE TEAM SUPERIORE AL LIMITE ---");
        iscrizioneUI.iscriviTeam(99, 1);

        // ===============================
        // TEST INVIO SOTTOMISSIONE
        // ===============================

        IInviaSottomissione sottomissioneUI = new IInviaSottomissione();

        System.out.println("\n--- TEST TEAM NON ISCRITTO ---");
        sottomissioneUI.inviaSottomissione(99, 1);

        System.out.println("\n--- TEST SCADENZA SUPERATA ---");
        sottomissioneUI.inviaSottomissione(1, 2);

        System.out.println("\n--- TEST INVIO VALIDO (inserire un link) ---");
        sottomissioneUI.inviaSottomissione(1, 1);

        System.out.println("\n--- TEST SOTTOMISSIONE GIÀ PRESENTE ---");
        sottomissioneUI.inviaSottomissione(1, 1);

        // ================================
        // TEST VALUTARE SOTTOMISSIONE
        // ================================

        IValutazioneSottomissione valutazioneUI = new IValutazioneSottomissione();

        System.out.println("\n--- TEST VALUTAZIONE VALIDA ---");
        valutazioneUI.valutaSottomissione(
                7,                  // giudiceId
                1,                  // hackathonId
                101,                // submissionId
                "Buon progetto, ben strutturato.",
                8                   // punteggio
        );

        System.out.println("\n--- TEST GIUDICE NON ASSEGNATO ---");
        valutazioneUI.valutaSottomissione(
                99,                 // giudiceId non assegnato
                1,
                101,
                "Tentativo non valido.",
                7
        );

        System.out.println("\n--- TEST HACKATHON NON IN VALUTAZIONE ---");
        valutazioneUI.valutaSottomissione(
                7,
                2,                  // hackathonId con stato non valido
                101,
                "Test hackathon chiuso.",
                6
        );

        System.out.println("\n--- TEST NESSUNA SOTTOMISSIONE ---");
        valutazioneUI.valutaSottomissione(
                7,
                3,                  // hackathonId senza submissions
                999,
                "Nessuna submission.",
                5
        );

        System.out.println("\n--- TEST PUNTEGGIO NON VALIDO ---");
        valutazioneUI.valutaSottomissione(
                7,
                1,
                101,
                "Punteggio fuori range.",
                15                  // non valido
        );

        System.out.println("\n--- TEST COMMENTO MANCANTE ---");
        valutazioneUI.valutaSottomissione(
                7,
                1,
                101,
                "",
                7
        );

        // ================================
        // TEST ACCESSO ALLE SOTTOMISSIONI
        // ================================

        IAccedereSottomissioni accessoSottomissioniUI = new IAccedereSottomissioni();

        System.out.println("\n--- TEST ACCESSO SOTTOMISSIONE VALIDO ---");
        accessoSottomissioniUI.accediAlleSottomissioni(
                20,   // staffId assegnato
                1,    // hackathon valido
                1     // team con submission
        );

        System.out.println("\n--- TEST HACKATHON NON ESISTENTE ---");
        accessoSottomissioniUI.accediAlleSottomissioni(
                20,
                999,  // hackathon non esistente
                1
        );

        System.out.println("\n--- TEST STAFF NON ASSEGNATO ---");
        accessoSottomissioniUI.accediAlleSottomissioni(
                99,   // staff non assegnato
                1,
                1
        );

        System.out.println("\n--- TEST SOTTOMISSIONE NON PRESENTE ---");
        accessoSottomissioniUI.accediAlleSottomissioni(
                20,
                2,    // hackathon valido ma il team 3 non ha submission
                3
        );

        // ================================
        // TEST PROCLAMARE TEAM VINCITORE
        // ================================

        IProclamaVincitore proclamazioneUI = new IProclamaVincitore();

        System.out.println("\n--- TEST PROCLAMAZIONE VALIDA ---");
        proclamazioneUI.proclamaVincitore(
                50,   // organizzatore assegnato
                1,    // hackathon valido
                3     // team vincitore
        );

        System.out.println("\n--- TEST ORGANIZZATORE NON AUTORIZZATO ---");
        proclamazioneUI.proclamaVincitore(
                99,   // organizzatore non assegnato
                1,
                3
        );

        System.out.println("\n--- TEST HACKATHON NON IN STATO CORRETTO ---");
        proclamazioneUI.proclamaVincitore(
                50,
                3,    // hackathon non in stato IN_VALUTAZIONE
                3
        );

        System.out.println("\n--- TEST NON TUTTE LE SOTTOMISSIONI VALUTATE ---");
        proclamazioneUI.proclamaVincitore(
                50,
                2,    // hackathon con submissions non tutte valutate
                4
        );

        System.out.println("\n--- TEST NESSUNA SOTTOMISSIONE ---");
        proclamazioneUI.proclamaVincitore(
                50,
                4,    // hackathon senza submissions
                1
        );

        System.out.println("\n--- TEST ERRORE PAGAMENTO ---");
        proclamazioneUI.proclamaVincitore(
                50,
                1,
                999   // team che simula errore pagamento
        );
    }
}