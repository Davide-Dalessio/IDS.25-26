package it.progetto.service;

import it.progetto.dto.CallDTO;
import it.progetto.dto.CallRequest;
import it.progetto.model.Call;
import it.progetto.model.ConcreteCallBuilder;

import java.util.ArrayList;
import java.util.List;

public class CallService {
    private final List<Call> savedCalls = new ArrayList<>();
    private int nextId = 1;

    public CallDTO requestCall(CallRequest request) {
        checkCallData(request);
        checkRequest(request);

        String bookingLink = createBookingLink(request.getRequestId());
        List<String> slotList = createBookingOptions(request.getDurata(), request.getPeriodo());

        Call call = createCall(request, bookingLink, slotList);
        saveCall(call);

        System.out.println("Service: call creata correttamente.");

        return new CallDTO(call.getId(), call.getBookingLink(), call.getSlotList());
    }

    private void checkCallData(CallRequest request) {
        if (request.getDurata() == null || request.getDurata().isBlank()) {
            throw new IllegalArgumentException("Errore: durata non valida.");
        }

        if (request.getPeriodo() == null || request.getPeriodo().isBlank()) {
            throw new IllegalArgumentException("Errore: periodo non valido.");
        }

        if (request.getRequestId() <= 0) {
            throw new IllegalArgumentException("Errore: requestId non valido.");
        }

        if (request.getMentorId() <= 0) {
            throw new IllegalArgumentException("Errore: mentorId non valido.");
        }

        if (request.getHackathonId() <= 0) {
            throw new IllegalArgumentException("Errore: hackathonId non valido.");
        }
    }

    private void checkRequest(CallRequest request) {
        if (request.getRequestId() == 999) {
            throw new IllegalStateException("Errore: richiesta non più aperta.");
        }

        for (Call c : savedCalls) {
            if (c.getRequestId() == request.getRequestId()) {
                throw new IllegalStateException("Errore: call già proposta per questa richiesta.");
            }
        }

        if (request.getMentorId() != 10) {
            throw new IllegalStateException("Errore: mentor non autorizzato per questa richiesta.");
        }

        if (request.getHackathonId() != 100) {
            throw new IllegalStateException("Errore: hackathon non associato alla richiesta.");
        }
    }

    private String createBookingLink(int requestId) {
        return "https://calendar.com/booking/request-" + requestId;
    }

    private List<String> createBookingOptions(String durata, String periodo) {
        List<String> slotList = new ArrayList<>();
        slotList.add(periodo + " 10:00");
        slotList.add(periodo + " 11:00");
        slotList.add(periodo + " 15:00");
        return slotList;
    }

    private Call createCall(CallRequest request, String bookingLink, List<String> slotList) {
        ConcreteCallBuilder builder = new ConcreteCallBuilder();

        builder.buildId(nextId++);
        builder.buildRequestId(request.getRequestId());
        builder.buildMentorId(request.getMentorId());
        builder.buildHackathonId(request.getHackathonId());
        builder.buildDurata(request.getDurata());
        builder.buildNote(request.getNote());
        builder.buildPeriodo(request.getPeriodo());
        builder.buildBookingLink(bookingLink);
        builder.buildSlotList(slotList);

        return builder.getResult();
    }

    private void saveCall(Call call) {
        savedCalls.add(call);
        System.out.println("Service: call salvata con id " + call.getId());
    }
}
