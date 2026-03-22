package it.progetto.model;

import java.util.List;

public class Call {
    private final int id;
    private final int requestId;
    private final int mentorId;
    private final int hackathonId;
    private final String durata;
    private final String note;
    private final String periodo;
    private final String bookingLink;
    private final List<String> slotList;

    public Call(int id, int requestId, int mentorId, int hackathonId,
                String durata, String note, String periodo,
                String bookingLink, List<String> slotList) {
        this.id = id;
        this.requestId = requestId;
        this.mentorId = mentorId;
        this.hackathonId = hackathonId;
        this.durata = durata;
        this.note = note;
        this.periodo = periodo;
        this.bookingLink = bookingLink;
        this.slotList = slotList;
    }

    public int getId() {
        return id;
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

    public String getBookingLink() {
        return bookingLink;
    }

    public List<String> getSlotList() {
        return slotList;
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", requestId=" + requestId +
                ", mentorId=" + mentorId +
                ", hackathonId=" + hackathonId +
                ", durata='" + durata + '\'' +
                ", note='" + note + '\'' +
                ", periodo='" + periodo + '\'' +
                ", bookingLink='" + bookingLink + '\'' +
                ", slotList=" + slotList +
                '}';
    }
}
