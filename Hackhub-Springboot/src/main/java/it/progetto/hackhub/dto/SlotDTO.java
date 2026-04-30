package it.progetto.hackhub.dto;

public class SlotDTO {
    private int slotId;
    private boolean booked;

    public SlotDTO() {
    }

    public SlotDTO(int slotId, boolean booked) {
        this.slotId = slotId;
        this.booked = booked;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
