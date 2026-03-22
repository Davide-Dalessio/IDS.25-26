package it.progetto.dto;

import java.util.List;

public class CallDTO {
    private final int callId;
    private final String bookingLink;
    private final List<String> slotList;

    public CallDTO(int callId, String bookingLink, List<String> slotList) {
        this.callId = callId;
        this.bookingLink = bookingLink;
        this.slotList = slotList;
    }

    public int getCallId() {
        return callId;
    }

    public String getBookingLink() {
        return bookingLink;
    }

    public List<String> getSlotList() {
        return slotList;
    }

    @Override
    public String toString() {
        return "CallDTO{" +
                "callId=" + callId +
                ", bookingLink='" + bookingLink + '\'' +
                ", slotList=" + slotList +
                '}';
    }
}
