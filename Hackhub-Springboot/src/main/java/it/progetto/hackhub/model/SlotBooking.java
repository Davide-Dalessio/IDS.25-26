package it.progetto.hackhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SlotBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int slotIndex;
    private int callId;
    private int requestId;
    private int teamId;

    public SlotBooking() {
    }

    public SlotBooking(int slotIndex, int callId, int requestId, int teamId) {
        this.slotIndex = slotIndex;
        this.callId = callId;
        this.requestId = requestId;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public int getSlotIndex() {
        return slotIndex;
    }

    public int getCallId() {
        return callId;
    }

    public int getRequestId() {
        return requestId;
    }

    public int getTeamId() {
        return teamId;
    }
}
