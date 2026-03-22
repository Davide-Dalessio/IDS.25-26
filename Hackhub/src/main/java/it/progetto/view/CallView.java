package it.progetto.view;

import it.progetto.controller.CallController;
import it.progetto.dto.CallDTO;

public class CallView {
    private final CallController controller;

    public CallView() {
        this.controller = new CallController();
    }

    public void clickProponiCall() {
        System.out.println("UI: apertura form proposta call...");
    }

    public void submitCallData(int requestId, int mentorId, int hackathonId,
                               String durata, String note, String periodo) {
        try {
            CallDTO callDTO = controller.sendDatiCall(
                    requestId, mentorId, hackathonId, durata, note, periodo
            );

            showConfirmation();
            showBookingLink(callDTO.getBookingLink());
            showSlotList(callDTO);
        } catch (IllegalArgumentException | IllegalStateException e) {
            showValidationError(e.getMessage());
        }
    }

    public void showConfirmation() {
        System.out.println("UI: proposta call confermata.");
    }

    public void showBookingLink(String link) {
        System.out.println("UI: link prenotazione = " + link);
    }

    public void showSlotList(CallDTO dto) {
        System.out.println("UI: slot disponibili = " + dto.getSlotList());
    }

    public void showValidationError(String message) {
        System.out.println("UI ERROR: " + message);
    }
}
