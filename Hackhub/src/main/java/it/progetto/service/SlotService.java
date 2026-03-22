package it.progetto.service;

import it.progetto.dto.SlotDTO;
import it.progetto.dto.SlotRequest;
import it.progetto.model.SlotBooking;

import java.util.ArrayList;
import java.util.List;

public class SlotService {
    private final List<SlotBooking> bookings = new ArrayList<>();

    public SlotDTO bookSlot(SlotRequest request) {

        validateRequest(request);

        checkSlotAvailability(request.getSlotId());

        SlotBooking booking = createBooking(request);

        bookings.add(booking);

        System.out.println("Service: slot prenotato correttamente.");

        updateSupportRequest(request.getRequestId());

        return new SlotDTO(request.getSlotId(), true);
    }

    private void validateRequest(SlotRequest request) {

        if (request.getSlotId() <= 0) {
            throw new IllegalArgumentException("Slot non valido.");
        }

        if (request.getRequestId() <= 0) {
            throw new IllegalArgumentException("Request non valida.");
        }

        if (request.getTeamId() <= 0) {
            throw new IllegalArgumentException("Team non valido.");
        }
    }

    private void checkSlotAvailability(int slotId) {

        for (SlotBooking b : bookings) {
            if (b.getSlotId() == slotId) {
                throw new IllegalStateException("Slot non più disponibile.");
            }
        }

        System.out.println("Service: slot disponibile.");
    }

    private SlotBooking createBooking(SlotRequest request) {

        return new SlotBooking(
                request.getSlotId(),
                request.getRequestId(),
                request.getTeamId()
        );
    }

    private void updateSupportRequest(int requestId) {

        System.out.println("Service: stato richiesta aggiornato a 'Call pianificata' per request "
                + requestId);
    }
}
