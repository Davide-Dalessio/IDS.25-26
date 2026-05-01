package it.progetto.hackhub.dto;

public class SlotRequest {
    private int slotIndex;
    private int callId;
    private int requestId;
    private int teamId;

    public SlotRequest() {
    }

    public SlotRequest(int slotIndex, int callId, int requestId, int teamId) {
        this.slotIndex = slotIndex;
        this.callId = callId;
        this.requestId = requestId;
        this.teamId = teamId;
    }

    public int getSlotIndex() {
        return slotIndex;
    }

    public void setSlotIndex(int slotIndex) {
        this.slotIndex = slotIndex;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
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
