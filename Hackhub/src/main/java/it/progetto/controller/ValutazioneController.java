package it.progetto.controller;

import it.progetto.dto.ValutazioneDTO;
import it.progetto.dto.ValutazioneRequest;
import it.progetto.service.ValutazioneService;

import java.util.List;

public class ValutazioneController {
    private final ValutazioneService valutazioneService;

    public ValutazioneController() {
        this.valutazioneService = new ValutazioneService();
    }

    public List<Integer> requestAssignedHackathons(int giudiceId) {
        return valutazioneService.getAssignedHackathons(giudiceId);
    }

    public List<Integer> getSubmissionsByHackathon(int giudiceId, int hackathonId) {
        return valutazioneService.getSubmissionsByHackathon(giudiceId, hackathonId);
    }

    public ValutazioneRequest createRequest(int giudiceId, int hackathonId, int submissionId, String commento, int punteggio) {
        return new ValutazioneRequest(giudiceId, hackathonId, submissionId, commento, punteggio);
    }

    public ValutazioneDTO requestEvaluation(ValutazioneRequest request) {
        return valutazioneService.requestEvaluation(request);
    }
}
