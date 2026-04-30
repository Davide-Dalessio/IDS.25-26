package it.progetto.hackhub.dto;

import java.util.List;

public class CallDTO {
    private int callId;
    private String bookingLink;
    private List<String> slotList;

    public CallDTO() {
    }

    public CallDTO(int callId, String bookingLink, List<String> slotList) {
        this.callId = callId;
        this.bookingLink = bookingLink;
        this.slotList = slotList;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public String getBookingLink() {
        return bookingLink;
    }

    public void setBookingLink(String bookingLink) {
        this.bookingLink = bookingLink;
    }

    public List<String> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<String> slotList) {
        this.slotList = slotList;
    }
}
