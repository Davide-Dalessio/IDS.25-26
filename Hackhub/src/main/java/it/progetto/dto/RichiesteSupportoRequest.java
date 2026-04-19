package it.progetto.dto;

public class RichiesteSupportoRequest {
    private final int mentorId;
    private final int hackathonId;
    private final int requestId;

    public RichiesteSupportoRequest(int mentorId, int hackathonId, int requestId) {
        this.mentorId = mentorId;
        this.hackathonId = hackathonId;
        this.requestId = requestId;
    }

    public int getMentorId() {
        return mentorId;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public int getRequestId() {
        return requestId;
    }
}
