package it.progetto.controller;

import it.progetto.dto.SlotDTO;
import it.progetto.dto.SlotRequest;
import it.progetto.service.SlotService;

public class SlotController {
    private final SlotService slotService;

    public SlotController() {
        this.slotService = new SlotService();
    }

    public SlotDTO sendSlotSelection(int slotId, int requestId, int teamId) {

        SlotRequest request = createRequest(slotId, requestId, teamId);

        System.out.println("Controller: richiesta prenotazione slot inviata al service.");

        return slotService.bookSlot(request);
    }

    private SlotRequest createRequest(int slotId, int requestId, int teamId) {

        return new SlotRequest(slotId, requestId, teamId);
    }
}
