package it.progetto.service;

import it.progetto.dto.HackathonDTO;
import it.progetto.dto.HackathonRequest;
import it.progetto.model.*;
import java.time.LocalDate;

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
}