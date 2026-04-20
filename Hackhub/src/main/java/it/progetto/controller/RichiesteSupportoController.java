package it.progetto.controller;

import it.progetto.dto.RichiesteSupportoDTO;
import it.progetto.dto.RichiesteSupportoRequest;
import it.progetto.service.RichiesteSupportoService;

import java.util.List;

public class RichiesteSupportoController {
    private final RichiesteSupportoService service;

    public RichiesteSupportoController() {
        this.service = new RichiesteSupportoService();
    }

    public List<Integer> requestAssignedHackathons(int mentorId) {
        return service.getAssignedHackathons(mentorId);
    }

    public RichiesteSupportoRequest createRequest(int mentorId, int hackathonId, int requestId) {
        return new RichiesteSupportoRequest(mentorId, hackathonId, requestId);
    }

    public List<Integer> requestSupportRequests(RichiesteSupportoRequest request) {
        return service.requestSupportRequests(request);
    }

    public RichiesteSupportoDTO getSupportRequestDetails(RichiesteSupportoRequest request) {
        return service.getSupportRequestDetails(request);
    }
}
