package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.SlotDTO;
import it.progetto.hackhub.dto.SlotRequest;
import it.progetto.hackhub.model.RichiestaSupporto;
import it.progetto.hackhub.model.SlotBooking;
import it.progetto.hackhub.repository.RichiestaSupportoRepository;
import it.progetto.hackhub.repository.SlotBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SlotService {

    @Autowired
    private SlotBookingRepository slotBookingRepository;

    @Autowired
    private RichiestaSupportoRepository richiestaSupportoRepository;

    public SlotDTO bookSlot(SlotRequest request) {

        validateRequest(request);

        checkSlotAvailability(request.getCallId(), request.getSlotIndex());

        SlotBooking booking = createBooking(request);

        slotBookingRepository.save(booking);

        updateSupportRequest(request.getRequestId());

        return new SlotDTO(request.getSlotIndex(), true);
    }

    private void validateRequest(SlotRequest request) {
        if (request.getSlotIndex() <= 0) {
            throw new IllegalArgumentException("Slot non valido.");
        }

        if (request.getCallId() <= 0) {
            throw new IllegalArgumentException("Call non valida.");
        }

        if (request.getRequestId() <= 0) {
            throw new IllegalArgumentException("Request non valida.");
        }

        if (request.getTeamId() <= 0) {
            throw new IllegalArgumentException("Team non valido.");
        }
    }

    private void checkSlotAvailability(int callId, int slotIndex) {
        if (slotBookingRepository.existsByCallIdAndSlotIndex(callId, slotIndex)) {
            throw new IllegalStateException("Slot non più disponibile.");
        }
    }

    private SlotBooking createBooking(SlotRequest request) {
        return new SlotBooking(
                request.getSlotIndex(),
                request.getCallId(),
                request.getRequestId(),
                request.getTeamId()
        );
    }

    private void updateSupportRequest(int requestId) {
        RichiestaSupporto richiesta = richiestaSupportoRepository.findById(requestId).orElse(null);
        if (richiesta != null) {
            richiesta.setStato("Call pianificata");
            richiestaSupportoRepository.save(richiesta);
        }
    }
}
