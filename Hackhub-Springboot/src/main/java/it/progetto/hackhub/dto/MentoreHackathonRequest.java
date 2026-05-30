package it.progetto.hackhub.dto;

public class MentoreHackathonRequest {
    private int mentorId;
    private int hackathonId;

    public MentoreHackathonRequest() {
    }

    public MentoreHackathonRequest(int mentorId, int hackathonId) {
        this.mentorId = mentorId;
        this.hackathonId = hackathonId;
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
}
