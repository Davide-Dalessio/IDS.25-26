package it.progetto.hackhub.dto;

public class CallRequest {
    private int requestId;
    private int mentorId;
    private int hackathonId;
    private String durata;
    private String note;
    private String periodo;

    public CallRequest() {
    }

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

    public void setRequestId(int requestId) {
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

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
