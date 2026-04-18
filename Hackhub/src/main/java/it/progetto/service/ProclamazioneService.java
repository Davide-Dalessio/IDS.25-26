package it.progetto.service;

import it.progetto.dto.ProclamazioneDTO;
import it.progetto.dto.ProclamazioneRequest;
import it.progetto.model.ConcreteProclamazioneBuilder;
import it.progetto.model.Proclamazione;
import it.progetto.model.ProclamazioneBuilder;

import java.util.*;

public class ProclamazioneService {
    private final ProclamazioneBuilder builder = new ConcreteProclamazioneBuilder();

    private final Map<Integer, Set<Integer>> organizzatoreHackathonMap = new HashMap<>();
    private final Map<Integer, String> statoHackathonMap = new HashMap<>();
    private final Map<Integer, Boolean> submissionsValutateMap = new HashMap<>();
    private final Map<Integer, List<String>> teamEvaluationListMap = new HashMap<>();
    private final Set<Integer> paymentFailureHackathons = new HashSet<>();
    private final List<Proclamazione> proclamazioniSalvate = new ArrayList<>();

    public ProclamazioneService() {
        // organizzatore 50 assegnato a hackathon 1,2,4
        organizzatoreHackathonMap.put(50, new HashSet<>(Arrays.asList(1, 2, 4)));

        // stati hackathon
        statoHackathonMap.put(1, "IN_VALUTAZIONE");
        statoHackathonMap.put(2, "IN_VALUTAZIONE");
        statoHackathonMap.put(3, "CREATO");
        statoHackathonMap.put(4, "IN_VALUTAZIONE");

        // tutte le submission valutate?
        submissionsValutateMap.put(1, true);
        submissionsValutateMap.put(2, false);
        submissionsValutateMap.put(3, true);
        submissionsValutateMap.put(4, true);

        // team con valutazioni
        teamEvaluationListMap.put(1, Arrays.asList(
                "Team 1 - media 8.5",
                "Team 2 - media 7.8",
                "Team 3 - media 9.1"
        ));

        teamEvaluationListMap.put(2, Arrays.asList(
                "Team 4 - media 8.0",
                "Team 5 - media 7.2"
        ));

        // hackathon 4 senza submission
        teamEvaluationListMap.put(4, new ArrayList<>());

        // hackathon con errore pagamento
        paymentFailureHackathons.add(1_999); // solo segnaposto logico, non usato
    }

    public List<String> prepareProclamation(int organizzatoreId, int hackathonId) {
        verifyOrganizerAuthorization(hackathonId, organizzatoreId);
        checkHackathonState(hackathonId);
        checkAllSubmissionsEvaluated(hackathonId);

        List<String> teams = findTeamsWithEvaluations(hackathonId);
        if (teams == null || teams.isEmpty()) {
            throw new IllegalArgumentException("Non esistono sottomissioni per l'hackathon.");
        }

        return teams;
    }

    public ProclamazioneDTO proclaimWinner(ProclamazioneRequest request) {
        verifyOrganizerAuthorization(request.getHackathonId(), request.getOrganizzatoreId());
        checkHackathonState(request.getHackathonId());
        checkAllSubmissionsEvaluated(request.getHackathonId());

        List<String> teams = findTeamsWithEvaluations(request.getHackathonId());
        if (teams == null || teams.isEmpty()) {
            throw new IllegalArgumentException("Non esistono sottomissioni per l'hackathon.");
        }

        boolean pagamentoEseguito = requestPrizePayment(request.getTeamId(), request.getHackathonId());

        Proclamazione proclamazione = builder.createProclamazione(request, pagamentoEseguito);
        proclamazioniSalvate.add(proclamazione);

        updateHackathonStatus(request.getHackathonId(), "CONCLUSO");

        return new ProclamazioneDTO(
                request.getHackathonId(),
                request.getTeamId(),
                pagamentoEseguito,
                "Team vincitore proclamato con successo."
        );
    }

    public void verifyOrganizerAuthorization(int hackathonId, int organizzatoreId) {
        Set<Integer> hackathons = organizzatoreHackathonMap.get(organizzatoreId);
        if (hackathons == null || !hackathons.contains(hackathonId)) {
            throw new IllegalArgumentException("L'organizzatore non è autorizzato su questo hackathon.");
        }
    }

    public void checkHackathonState(int hackathonId) {
        String stato = statoHackathonMap.get(hackathonId);
        if (!"IN_VALUTAZIONE".equals(stato)) {
            throw new IllegalArgumentException("L'hackathon non è nello stato corretto per proclamare un vincitore.");
        }
    }

    public void checkAllSubmissionsEvaluated(int hackathonId) {
        Boolean allEvaluated = submissionsValutateMap.get(hackathonId);
        if (allEvaluated == null || !allEvaluated) {
            throw new IllegalArgumentException("Non tutte le sottomissioni sono state valutate dal giudice.");
        }
    }

    public List<String> findTeamsWithEvaluations(int hackathonId) {
        return teamEvaluationListMap.getOrDefault(hackathonId, new ArrayList<>());
    }

    public void updateHackathonStatus(int hackathonId, String nuovoStato) {
        statoHackathonMap.put(hackathonId, nuovoStato);
    }

    public boolean requestPrizePayment(int teamId, int hackathonId) {
        // Simulazione: se il teamId è 999 errore pagamento
        if (teamId == 999) {
            throw new IllegalArgumentException("Esito negativo o nessuna risposta dal Sistema di Pagamento.");
        }
        return true;
    }
}
