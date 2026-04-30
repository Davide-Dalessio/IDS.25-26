package it.progetto.hackhub.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Call {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int requestId;
    private int mentorId;
    private int hackathonId;
    private String durata;
    private String note;
    private String periodo;
    private String bookingLink;
    
    @ElementCollection
    private List<String> slotList;

    public Call() {
    }

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
}
