package it.progetto.service;

import it.progetto.dto.RichiesteSupportoDTO;

import java.util.*;

public class RichiesteSupportoService {
    private final Set<Integer> hackathonEsistenti = new HashSet<>();
    private final Map<Integer, Set<Integer>> mentorHackathonMap = new HashMap<>();
    private final Map<Integer, List<Integer>> supportRequestsByHackathon = new HashMap<>();
    private final Map<Integer, RichiesteSupportoDTO> supportRequestDetails = new HashMap<>();

    public RichiesteSupportoService() {
        // Hackathon esistenti
        hackathonEsistenti.add(1);
        hackathonEsistenti.add(2);
        hackathonEsistenti.add(3);

        // Assegnazioni mentore -> hackathon
        mentorHackathonMap.put(10, new HashSet<>(Arrays.asList(1, 2)));

        // Richieste per hackathon
        supportRequestsByHackathon.put(1, Arrays.asList(101, 102));
        supportRequestsByHackathon.put(2, new ArrayList<>()); // nessuna richiesta
        supportRequestsByHackathon.put(3, Arrays.asList(201));

        // Dettagli richieste
        supportRequestDetails.put(101, new RichiesteSupportoDTO(
                101,
                1,
                "Team Alpha",
                "Backend",
                "2026-03-20",
                "Aperta",
                "Supporto su integrazione API",
                "Mattina / Pomeriggio",
                "Nessun contatto precedente"
        ));

        supportRequestDetails.put(102, new RichiesteSupportoDTO(
                102,
                1,
                "Team Beta",
                "Database",
                "2026-03-21",
                "In lavorazione",
                "Problema con schema relazionale",
                "Solo pomeriggio",
                "Richiesta aggiornata una volta"
        ));

        supportRequestDetails.put(201, new RichiesteSupportoDTO(
                201,
                3,
                "Team Gamma",
                "Frontend",
                "2026-03-22",
                "Aperta",
                "Supporto UI responsive",
                "Libero tutto il giorno",
                "Nessuno storico"
        ));
    }

    public List<Integer> getAssignedHackathons(int mentorId) {
        return new ArrayList<>(mentorHackathonMap.getOrDefault(mentorId, Collections.emptySet()));
    }

    public List<Integer> requestSupportRequests(int mentorId, int hackathonId) {
        checkHackathonExists(hackathonId);
        verifyMentorAssignment(hackathonId, mentorId);

        List<Integer> requests = findSupportRequestsByHackathon(hackathonId);
        if (requests == null || requests.isEmpty()) {
            throw new IllegalArgumentException("Non esistono richieste di supporto per l'hackathon selezionato.");
        }

        return requests;
    }

    public RichiesteSupportoDTO getSupportRequestDetails(int mentorId, int hackathonId, int requestId) {
        checkHackathonExists(hackathonId);
        verifyMentorAssignment(hackathonId, mentorId);

        List<Integer> requests = findSupportRequestsByHackathon(hackathonId);
        if (requests == null || requests.isEmpty()) {
            throw new IllegalArgumentException("Non esistono richieste di supporto per l'hackathon selezionato.");
        }

        if (!requests.contains(requestId)) {
            throw new IllegalArgumentException("La richiesta selezionata non appartiene all'hackathon indicato.");
        }

        RichiesteSupportoDTO dto = supportRequestDetails.get(requestId);
        if (dto == null) {
            throw new IllegalArgumentException("Dettagli richiesta non disponibili.");
        }

        return dto;
    }

    public void checkHackathonExists(int hackathonId) {
        if (!hackathonEsistenti.contains(hackathonId)) {
            throw new IllegalArgumentException("L'hackathon selezionato non esiste o non è accessibile.");
        }
    }

    public void verifyMentorAssignment(int hackathonId, int mentorId) {
        Set<Integer> hackathons = mentorHackathonMap.get(mentorId);
        if (hackathons == null || !hackathons.contains(hackathonId)) {
            throw new IllegalArgumentException("Il Mentore non è assegnato all'hackathon selezionato.");
        }
    }

    public List<Integer> findSupportRequestsByHackathon(int hackathonId) {
        return supportRequestsByHackathon.getOrDefault(hackathonId, new ArrayList<>());
    }
}
