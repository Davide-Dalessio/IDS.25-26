package it.progetto.controller;

import it.progetto.dto.SottomissioneDTO;
import it.progetto.dto.SottomissioneRequest;
import it.progetto.service.SottomissioneService;

public class SottomissioneController {
    private final SottomissioneService sottomissioneService;

    public SottomissioneController() {
        this.sottomissioneService = new SottomissioneService();
    }

    public void checkValido(int teamId, int hackathonId) {
        sottomissioneService.checkValido(teamId, hackathonId);
    }

    public SottomissioneDTO sendDati(int teamId, int hackathonId, String link) {
        SottomissioneRequest request = createRequest(teamId, hackathonId, link);
        return sottomissioneService.sendSottomissione(request);
    }

    private SottomissioneRequest createRequest(int teamId, int hackathonId, String link) {
        return new SottomissioneRequest(teamId, hackathonId, link);
    }
}
