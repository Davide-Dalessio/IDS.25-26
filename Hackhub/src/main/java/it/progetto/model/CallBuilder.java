package it.progetto.model;

import java.util.List;

public interface CallBuilder {
    void buildId(int id);
    void buildRequestId(int requestId);
    void buildMentorId(int mentorId);
    void buildHackathonId(int hackathonId);
    void buildDurata(String durata);
    void buildNote(String note);
    void buildPeriodo(String periodo);
    void buildBookingLink(String bookingLink);
    void buildSlotList(List<String> slotList);
    Call getResult();

}
