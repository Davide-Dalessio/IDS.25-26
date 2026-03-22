package it.progetto.model;

import java.util.List;

public class ConcreteCallBuilder implements CallBuilder {
    private int id;
    private int requestId;
    private int mentorId;
    private int hackathonId;
    private String durata;
    private String note;
    private String periodo;
    private String bookingLink;
    private List<String> slotList;

    @Override
    public void buildId(int id) {
        this.id = id;
    }

    @Override
    public void buildRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Override
    public void buildMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    @Override
    public void buildHackathonId(int hackathonId) {
        this.hackathonId = hackathonId;
    }

    @Override
    public void buildDurata(String durata) {
        this.durata = durata;
    }

    @Override
    public void buildNote(String note) {
        this.note = note;
    }

    @Override
    public void buildPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public void buildBookingLink(String bookingLink) {
        this.bookingLink = bookingLink;
    }

    @Override
    public void buildSlotList(List<String> slotList) {
        this.slotList = slotList;
    }

    @Override
    public Call getResult() {
        return new Call(id, requestId, mentorId, hackathonId, durata, note, periodo, bookingLink, slotList);
    }

}
