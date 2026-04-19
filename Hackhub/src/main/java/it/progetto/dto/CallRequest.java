package it.progetto.dto;

public class CallRequest {
    private final int requestId;
    private final int mentorId;
    private final int hackathonId;
    private final String durata;
    private final String note;
    private final String periodo;

    public CallRequest(int requestId, int mentorId, int hackathonId,
            String durata, String note, String periodo) {
        this.requestId = requestId;
        this.mentorId = mentorId;
        this.hackathonId = hackathonId;
        this.durata = durata;
        this.note = note;
        this.periodo = periodo;
    }

    public int getRequestId() {
        return requestId;
    }

    public int getMentorId() {
        return mentorId;
    }

    public int getHackathonId() {
        return hackathonId;
    }

    public String getDurata() {
        return durata;
    }

    public String getNote() {
        return note;
    }

    public String getPeriodo() {
        return periodo;
    }
}
