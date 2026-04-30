package it.progetto.hackhub.dto;

public class SlotRequest {
    private int slotId;
    private int requestId;
    private int teamId;

    public SlotRequest() {
    }

    public SlotRequest(int slotId, int requestId, int teamId) {
        this.slotId = slotId;
        this.requestId = requestId;
        this.teamId = teamId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
