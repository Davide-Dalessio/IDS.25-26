package it.progetto.controller;

import it.progetto.dto.AccessoSottomissioniDTO;
import it.progetto.dto.AccessoSottomissioniRequest;
import it.progetto.service.AccessoSottomissioniService;

import java.util.List;

public class AccessoSottomissioniController {
    private final AccessoSottomissioniService service;

    public AccessoSottomissioniController() {
        this.service = new AccessoSottomissioniService();
    }

    public List<Integer> requestHackathonList(int staffId) {
        return service.getHackathonList();
    }

    public AccessoSottomissioniRequest createRequest(int hackathonId, int staffId, int teamId) {
        return new AccessoSottomissioniRequest(staffId, hackathonId, teamId);
    }

    public List<Integer> requestHackathonAccess(AccessoSottomissioniRequest request) {
        return service.requestHackathonAccess(request.getStaffId(), request.getHackathonId());
    }

    public AccessoSottomissioniDTO getSubmission(AccessoSottomissioniRequest request) {
        return service.getSubmission(request);
    }
}
