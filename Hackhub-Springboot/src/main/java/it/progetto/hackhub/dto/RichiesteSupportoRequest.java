package it.progetto.hackhub.dto;

public class RichiesteSupportoRequest {
    private int mentorId;
    private int hackathonId;
    private int requestId;

    public RichiesteSupportoRequest() {
    }

    public RichiesteSupportoRequest(int mentorId, int hackathonId, int requestId) {
        this.mentorId = mentorId;
        this.hackathonId = hackathonId;
        this.requestId = requestId;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public void setHackathonId(int hackathonId) {
        this.hackathonId = hackathonId;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
}
