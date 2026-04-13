package it.progetto.service;

import it.progetto.dto.ValutazioneDTO;
import it.progetto.dto.ValutazioneRequest;
import it.progetto.model.ConcreteValutazioneBuilder;
import it.progetto.model.Valutazione;
import it.progetto.model.ValutazioneBuilder;

import java.util.*;

public class ValutazioneService {

    private final Map<Integer, Set<Integer>> giudiceHackathonMap = new HashMap<>();
    private final Map<Integer, String> statoHackathonMap = new HashMap<>();
    private final Map<Integer, List<Integer>> submissionsByHackathon = new HashMap<>();
    private final List<Valutazione> valutazioniSalvate = new ArrayList<>();

    private int nextValutazioneId = 1;

    public ValutazioneService() {
        // giudice 7 assegnato a hackathon 1
        giudiceHackathonMap.put(7, new HashSet<>(Collections.singletonList(1)));

        // hackathon 1 è in valutazione, hackathon 2 no
        statoHackathonMap.put(1, "IN_VALUTAZIONE");
        statoHackathonMap.put(2, "CHIUSO");

        // hackathon 1 ha submissions, hackathon 3 no
        submissionsByHackathon.put(1, Arrays.asList(101, 102));
        submissionsByHackathon.put(3, new ArrayList<>());
    }

    public List<Integer> getAssignedHackathons(int giudiceId) {
        return new ArrayList<>(giudiceHackathonMap.getOrDefault(giudiceId, Collections.emptySet()));
    }

    public List<Integer> getSubmissionsByHackathon(int giudiceId, int hackathonId) {
        verifyJudgeAssignment(hackathonId, giudiceId);
        checkHackathonState(hackathonId);

        List<Integer> submissions = submissionsByHackathon.get(hackathonId);
        if (submissions == null || submissions.isEmpty()) {
            throw new IllegalArgumentException("Nessuna sottomissione da valutare.");
        }

        return submissions;
    }

    public ValutazioneDTO requestEvaluation(ValutazioneRequest request) {
        verifyJudgeAssignment(request.getHackathonId(), request.getGiudiceId());
        checkHackathonState(request.getHackathonId());

        List<Integer> submissions = submissionsByHackathon.get(request.getHackathonId());
        if (submissions == null || !submissions.contains(request.getSubmissionId())) {
            throw new IllegalArgumentException("La sottomissione selezionata non esiste per questo hackathon.");
        }

        validateEvaluation(request.getPunteggio(), request.getCommento());

        ValutazioneBuilder builder = new ConcreteValutazioneBuilder();
        builder.reset();
        builder.setIds(nextValutazioneId++, request.getGiudiceId(), request.getHackathonId(), request.getSubmissionId());
        builder.setGiudizio(request.getPunteggio(), request.getCommento());
        
        Valutazione valutazione = builder.getResult();
        valutazioniSalvate.add(valutazione);

        return new ValutazioneDTO(
                valutazione.getId(),
                valutazione.getSubmissionId(),
                valutazione.getGiudiceId(),
                valutazione.getCommento(),
                valutazione.getPunteggio(),
                "Valutazione salvata con successo."
        );
    }

    public void verifyJudgeAssignment(int hackathonId, int giudiceId) {
        Set<Integer> hackathons = giudiceHackathonMap.get(giudiceId);
        if (hackathons == null || !hackathons.contains(hackathonId)) {
            throw new IllegalArgumentException("Il giudice non è assegnato all'hackathon selezionato.");
        }
    }

    public void checkHackathonState(int hackathonId) {
        String stato = statoHackathonMap.get(hackathonId);
        if (!"IN_VALUTAZIONE".equals(stato)) {
            throw new IllegalArgumentException("L'hackathon non è nello stato 'In valutazione'.");
        }
    }

    public void validateEvaluation(int punteggio, String commento) {
        if (punteggio < 0 || punteggio > 10) {
            throw new IllegalArgumentException("Il punteggio deve essere compreso tra 0 e 10.");
        }
        if (commento == null || commento.trim().isEmpty()) {
            throw new IllegalArgumentException("Il giudizio testuale è obbligatorio.");
        }
    }
}
