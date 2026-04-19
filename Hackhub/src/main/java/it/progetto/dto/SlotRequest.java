package it.progetto.dto;

public class SlotRequest {
    private final int slotId;
    private final int requestId;
    private final int teamId;

    public SlotRequest(int slotId, int requestId, int teamId) {
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
