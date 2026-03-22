package it.progetto.model;

public class SlotBooking {
    private final int slotId;
    private final int requestId;
    private final int teamId;

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

    @Override
    public String toString() {
        return "SlotBooking{" +
                "slotId=" + slotId +
                ", requestId=" + requestId +
                ", teamId=" + teamId +
                '}';
    }
}
