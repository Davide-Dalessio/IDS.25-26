package it.progetto.view;

import it.progetto.controller.SlotController;
import it.progetto.dto.SlotDTO;

public class PrenotazioneSlotUI {
    private final SlotController controller;

    public PrenotazioneSlotUI() {
        this.controller = new SlotController();
    }

    public void selectSlot(int slotId, int requestId, int teamId) {

        try {

            SlotDTO dto = controller.sendSlotSelection(slotId, requestId, teamId);

            showConfirmation(dto);

        } catch (IllegalArgumentException | IllegalStateException e) {

            showError(e.getMessage());
        }
    }

    private void showConfirmation(SlotDTO dto) {

        System.out.println("UI: prenotazione slot confermata.");
        System.out.println("Slot prenotato: " + dto.getSlotId());
    }

    private void showError(String message) {

        System.out.println("UI ERROR: " + message);
    }
}
