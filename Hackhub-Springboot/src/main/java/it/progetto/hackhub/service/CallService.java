package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.CallDTO;
import it.progetto.hackhub.dto.CallRequest;
import it.progetto.hackhub.model.Call;
import it.progetto.hackhub.model.ConcreteCallBuilder;
import it.progetto.hackhub.model.Hackathon;
import it.progetto.hackhub.model.RichiestaSupporto;
import it.progetto.hackhub.model.Utente;
import it.progetto.hackhub.repository.CallRepository;
import it.progetto.hackhub.repository.HackathonRepository;
import it.progetto.hackhub.repository.RichiestaSupportoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CallService {

    @Autowired
    private CallRepository callRepository;

    @Autowired
    private RichiestaSupportoRepository richiestaSupportoRepository;

    @Autowired
    private HackathonRepository hackathonRepository;

    public CallDTO requestCall(CallRequest request) {
        checkCallData(request);
        checkRequest(request);

        String bookingLink = createBookingLink(request.getRequestId());
        List<String> slotList = createBookingOptions(request.getDurata(), request.getPeriodo());

        Call call = createCall(request, bookingLink, slotList);
        call = callRepository.save(call);

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
        RichiestaSupporto richiesta = richiestaSupportoRepository.findById(request.getRequestId())
                .orElseThrow(() -> new IllegalStateException("Errore: richiesta non trovata."));

        if (!"Aperta".equals(richiesta.getStato())) {
            throw new IllegalStateException("Errore: richiesta non più aperta.");
        }

        if (callRepository.existsByRequestId(request.getRequestId())) {
            throw new IllegalStateException("Errore: call già proposta per questa richiesta.");
        }

        Hackathon hackathon = hackathonRepository.findById(request.getHackathonId())
                .orElseThrow(() -> new IllegalStateException("Errore: hackathon inesistente."));

        if (richiesta.getHackathonId() != hackathon.getHackathonId()) {
            throw new IllegalStateException("Errore: hackathon non associato alla richiesta.");
        }

        boolean isMentor = false;
        for (Utente mentore : hackathon.getMentori()) {
            if (mentore.getId() == request.getMentorId()) {
                isMentor = true;
                break;
            }
        }

        if (!isMentor) {
            throw new IllegalStateException("Errore: mentor non autorizzato per questa richiesta.");
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

        // Id è ignorato in Spring Boot, generato dal database
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
}
