package it.progetto.service;

import it.progetto.dto.AccessoSottomissioniDTO;
import it.progetto.dto.AccessoSottomissioniRequest;

import java.util.*;

public class AccessoSottomissioniService {
    private final Set<Integer> hackathonEsistenti = new HashSet<>();
    private final Map<Integer, Set<Integer>> staffHackathonMap = new HashMap<>();
    private final Map<Integer, List<Integer>> teamsByHackathon = new HashMap<>();
    private final Map<String, String> submissionsByHackathonAndTeam = new HashMap<>();

    public AccessoSottomissioniService() {
        // hackathon esistenti
        hackathonEsistenti.add(1);
        hackathonEsistenti.add(2);

        // staff assegnazioni
        // staff 20 assegnato a hackathon 1
        staffHackathonMap.put(20, new HashSet<>(Collections.singletonList(1)));

        // team iscritti
        teamsByHackathon.put(1, Arrays.asList(1, 2));
        teamsByHackathon.put(2, Arrays.asList(3));

        // sottomissioni
        submissionsByHackathonAndTeam.put(key(1, 1), "https://github.com/team1/progetto");
        submissionsByHackathonAndTeam.put(key(1, 2), "https://github.com/team2/progetto");
        // hackathon 2 team 3 senza submission volutamente
    }

    public List<Integer> getHackathonList() {
        return new ArrayList<>(hackathonEsistenti);
    }

    public List<Integer> requestHackathonAccess(int staffId, int hackathonId) {
        checkHackathonExists(hackathonId);
        verifyStaffAssignment(hackathonId, staffId);

        List<Integer> teams = teamsByHackathon.getOrDefault(hackathonId, new ArrayList<>());
        if (teams.isEmpty()) {
            throw new IllegalArgumentException("Nessun team trovato per l'hackathon selezionato.");
        }

        return teams;
    }

    public AccessoSottomissioniDTO getSubmission(AccessoSottomissioniRequest request) {
        checkHackathonExists(request.getHackathonId());
        verifyStaffAssignment(request.getHackathonId(), request.getStaffId());

        String submission = findSubmissionByTeam(request.getTeamId(), request.getHackathonId());

        return new AccessoSottomissioniDTO(
                request.getHackathonId(),
                request.getTeamId(),
                submission,
                "Sottomissione recuperata con successo."
        );
    }

    public void checkHackathonExists(int hackathonId) {
        if (!hackathonEsistenti.contains(hackathonId)) {
            throw new IllegalArgumentException("L'hackathon selezionato non esiste o non è accessibile.");
        }
    }

    public void verifyStaffAssignment(int hackathonId, int staffId) {
        Set<Integer> hackathons = staffHackathonMap.get(staffId);
        if (hackathons == null || !hackathons.contains(hackathonId)) {
            throw new IllegalArgumentException("Il membro dello staff non è assegnato all'hackathon selezionato.");
        }
    }

    public String findSubmissionByTeam(int teamId, int hackathonId) {
        String submission = submissionsByHackathonAndTeam.get(key(hackathonId, teamId));
        if (submission == null || submission.isBlank()) {
            throw new IllegalArgumentException("Nessuna sottomissione presente per il team selezionato.");
        }
        return submission;
    }

    private String key(int hackathonId, int teamId) {
        return hackathonId + "_" + teamId;
    }
}
