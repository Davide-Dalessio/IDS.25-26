package it.progetto.hackhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SlotBooking {
    
    @Id
    private int slotId;
    private int requestId;
    private int teamId;

    public SlotBooking() {
    }

    public SlotBooking(int slotId, int requestId, int teamId) {
        this.slotId = slotId;
        this.requestId = requestId;
        this.teamId = teamId;
    }

    public int getSlotId() {
        return slotId;
    }

    public int getRequestId() {
        return requestId;
    }

    public int getTeamId() {
        return teamId;
    }
}
