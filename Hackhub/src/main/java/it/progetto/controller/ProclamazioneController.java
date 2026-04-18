package it.progetto.controller;

import it.progetto.dto.ProclamazioneDTO;
import it.progetto.dto.ProclamazioneRequest;
import it.progetto.service.ProclamazioneService;

import java.util.List;

public class ProclamazioneController {
    private final ProclamazioneService service;

    public ProclamazioneController() {
        this.service = new ProclamazioneService();
    }

    public ProclamazioneRequest createRequest(int organizzatoreId, int hackathonId, int teamId) {
        return new ProclamazioneRequest(organizzatoreId, hackathonId, teamId);
    }

    public List<String> prepareProclamation(int organizzatoreId, int hackathonId) {
        return service.prepareProclamation(organizzatoreId, hackathonId);
    }

    public ProclamazioneDTO proclaimWinner(ProclamazioneRequest request) {
        return service.proclaimWinner(request);
    }
}
