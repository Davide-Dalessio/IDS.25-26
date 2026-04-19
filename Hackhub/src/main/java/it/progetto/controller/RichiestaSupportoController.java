package it.progetto.controller;

import it.progetto.dto.RichiestaSupportoDTO;
import it.progetto.dto.RichiestaSupportoRequest;
import it.progetto.service.RichiestaSupportoService;

public class RichiestaSupportoController {

    private final RichiestaSupportoService service;

    public RichiestaSupportoController() {
        this.service = new RichiestaSupportoService();
    }

    public void checkDati(int teamId, int hackathonId) {
        service.checkDati(teamId, hackathonId);
    }

    public RichiestaSupportoRequest createRichiesta(int teamId, int hackathonId, String msg) {
        return new RichiestaSupportoRequest(teamId, hackathonId, msg);
    }

    public RichiestaSupportoDTO requestRichiesta(RichiestaSupportoRequest request) {
        return service.requestRichiesta(request);
    }
}
