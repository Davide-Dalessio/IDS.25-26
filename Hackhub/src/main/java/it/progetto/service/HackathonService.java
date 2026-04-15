package it.progetto.service;

import it.progetto.dto.HackathonDTO;
import it.progetto.dto.HackathonRequest;
import it.progetto.model.*;
import java.time.LocalDate;
import java.util.List;
public class HackathonService {

    public HackathonDTO requestHackathon(HackathonRequest request) {

        // Self Message: checkRequest
        System.out.println("Service: Eseguo checkRequest...");
        if (this.checkRequest(request)) {

            // Messaggio: createHackathon(request)
            System.out.println("Service: Check superato. Avvio createHackathon tramite Builder...");
            return this.createHackathon(request);
        } else {
            System.out.println("Service: Check fallito! Dati non validi.");
            return null;
        }
    }

    private boolean checkRequest(HackathonRequest request) {
        return request.getNome() != null && !request.getNome().isEmpty() && request.getPremio() >= 0;
    }

    private HackathonDTO createHackathon(HackathonRequest request) {
        HackathonBuilder builder = new ConcreteHackathonBuilder();

        builder.reset();
        builder.setNome(request.getNome());
        builder.setDataInizio(LocalDate.parse(request.getDataInizio()));
        builder.setDataFine(LocalDate.parse(request.getDataFine()));
        builder.setPremio(request.getPremio());
        builder.setOrganizzatoreID(request.getOrganizzatoreID());

        Hackathon h = builder.getResult();

        // OUTPUT DI CONTROLLO (Simula il return hackathonDTO)
        System.out.println("\n--- OUTPUT DI VERIFICA (Simulazione DTO) ---");
        System.out.println("Nome Hackathon: " + h.getNome());
        System.out.println("Data Inizio:    " + h.getDataInizio());
        System.out.println("Premio:         " + h.getPremio() + "€");
        System.out.println("ID Organizzatore: " + h.getOrganizzatoreID());
        System.out.println("-------------------------------------------\n");

        return new HackathonDTO(h.getNome(), h.getDataInizio(), h.getDataFine(), h.getPremio(), h.getOrganizzatoreID());
    }

    public void aggiornaFasi() {
        System.out.println("HackathonService: Recupero hackathon attivi simulati in memoria...");
        List<Hackathon> lista = this.getHackathonsAttivi();
        LocalDate oggi = LocalDate.now();

        for (Hackathon h : lista) {
            if (h.getStato() == StatoHackathon.IN_ISCRIZIONE && 
               (oggi.isEqual(h.getDataInizio()) || oggi.isAfter(h.getDataInizio()))) {
                
                System.out.println("HackathonService: Trovato " + h.getNome() + " pronto per iniziare!");
                h.setStato(StatoHackathon.IN_CORSO);
                this.mockSave(h);
            }
            else if (h.getStato() == StatoHackathon.IN_CORSO && 
                    (oggi.isEqual(h.getDataFine()) || oggi.isAfter(h.getDataFine()))) {
                
                System.out.println("HackathonService: Trovato " + h.getNome() + " scaduto. Passo in valutazione!");
                h.setStato(StatoHackathon.IN_VALUTAZIONE);
                this.mockSave(h);
            }
        }
    }

    private List<Hackathon> getHackathonsAttivi() {
        java.util.List<Hackathon> listaMock = new java.util.ArrayList<>();
        
        Hackathon h1 = new Hackathon();
        h1.setNome("Hackathon Alfa");
        h1.setStato(StatoHackathon.IN_ISCRIZIONE);
        h1.setDataInizio(LocalDate.now().minusDays(1));
        h1.setDataFine(LocalDate.now().plusDays(5));
        
        h1.getEvents().subscribe("cambio_fase", new Utente(1, "Davide", "davide@email.com"));
        h1.getEvents().subscribe("cambio_fase", new Utente(2, "Professore", "prof@university.edu"));
        
        listaMock.add(h1);

        Hackathon h2 = new Hackathon();
        h2.setNome("Hackathon Beta");
        h2.setStato(StatoHackathon.IN_CORSO);
        h2.setDataInizio(LocalDate.now().minusDays(10));
        h2.setDataFine(LocalDate.now().minusDays(1));
        
        h2.getEvents().subscribe("cambio_fase", new Utente(3, "Alice", "alice@email.com"));
        
        listaMock.add(h2);

        return listaMock;
    }

    private void mockSave(Hackathon h) {
        System.out.println("   [MOCK-DB] Salvataggio eseguito: " + h.getNome() + " -> " + h.getStato());
    }
}