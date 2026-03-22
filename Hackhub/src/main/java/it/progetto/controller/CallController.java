package it.progetto.controller;

import it.progetto.dto.CallDTO;
import it.progetto.dto.CallRequest;
import it.progetto.service.CallService;

public class CallController {
    private final CallService callService;

    public CallController() {
        this.callService = new CallService();
    }

    public CallDTO sendDatiCall(int requestId, int mentorId, int hackathonId,
                                String durata, String note, String periodo) {

        CallRequest request = this.createRequest(requestId, mentorId, hackathonId, durata, note, periodo);

        System.out.println("Controller: Request call creata. Invio al Service...");

        return callService.requestCall(request);
    }

    private CallRequest createRequest(int requestId, int mentorId, int hackathonId,
                                      String durata, String note, String periodo) {
        return new CallRequest(requestId, mentorId, hackathonId, durata, note, periodo);
    }
}
