package it.progetto.controller;

import it.progetto.dto.IscrizioneDTO;
import it.progetto.dto.IscrizioneRequest;
import it.progetto.service.IscrizioneService;

public class IscrizioneController {
    private final IscrizioneService iscrizioneService;

    public IscrizioneController() {
        this.iscrizioneService = new IscrizioneService();
    }

    public IscrizioneDTO iscriviTeam(int teamId, int hackathonId) {
        IscrizioneRequest request = creaRequest(teamId, hackathonId);
        return iscrizioneService.iscriviTeam(request);
    }

    private IscrizioneRequest creaRequest(int teamId, int hackathonId) {
        return new IscrizioneRequest(teamId, hackathonId);
    }
}
