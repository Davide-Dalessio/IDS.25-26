package it.progetto.dto;

public class SlotDTO {
    private final int slotId;
    private final boolean booked;

    public SlotDTO(int slotId, boolean booked) {
        this.slotId = slotId;
        this.booked = booked;
    }

    public int getSlotId() {
        return slotId;
    }

    public boolean isBooked() {
        return booked;
    }
}
