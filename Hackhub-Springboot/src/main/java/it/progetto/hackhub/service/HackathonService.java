package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.HackathonDTO;
import it.progetto.hackhub.dto.HackathonRequest;
import it.progetto.hackhub.model.*;
import it.progetto.hackhub.repository.HackathonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HackathonService {

    private final HackathonRepository hackathonRepository;
    private final it.progetto.hackhub.repository.UtenteRepository utenteRepository;

    @Autowired
    public HackathonService(HackathonRepository hackathonRepository, it.progetto.hackhub.repository.UtenteRepository utenteRepository) {
        this.hackathonRepository = hackathonRepository;
        this.utenteRepository = utenteRepository;
    }

    public HackathonDTO requestHackathon(HackathonRequest request) {
        if (this.checkRequest(request)) {
            return this.createHackathon(request);
        } else {
            throw new IllegalArgumentException("Dati Hackathon non validi.");
        }
    }

    private boolean checkRequest(HackathonRequest request) {
        return request.getNome() != null && !request.getNome().isEmpty() && request.getPremio() >= 0;
    }

    private HackathonDTO createHackathon(HackathonRequest request) {
        HackathonBuilder builder = new ConcreteHackathonBuilder();
        builder.reset();
        builder.setNome(request.getNome());
        builder.setDataInizio(request.getDataInizio());
        builder.setDataFine(request.getDataFine());
        builder.setPremio(request.getPremio());
        builder.setOrganizzatoreID(request.getOrganizzatoreID());
        builder.setStato(StatoHackathon.IN_ISCRIZIONE);

        // Aggiunta Mentori
        if (request.getMentoriIds() != null) {
            for (Integer id : request.getMentoriIds()) {
                Utente u = utenteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Mentore non trovato con ID: " + id));
                builder.aggiungiMentore(u);
            }
        }

        // Aggiunta Giudici
        if (request.getGiudiciIds() != null) {
            for (Integer id : request.getGiudiciIds()) {
                Utente u = utenteRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Giudice non trovato con ID: " + id));
                builder.aggiungiGiudice(u);
            }
        }

        Hackathon h = builder.getResult();
        hackathonRepository.save(h);

        return new HackathonDTO(h.getNome(), h.getDataInizio(), h.getDataFine(), h.getPremio(), h.getOrganizzatoreID());
    }

    public void aggiornaFasi() {
        List<Hackathon> lista = hackathonRepository.findAll();
        LocalDate oggi = LocalDate.now();

        for (Hackathon h : lista) {
            if (h.getStato() == StatoHackathon.IN_ISCRIZIONE &&
                    (oggi.isEqual(h.getDataInizio()) || oggi.isAfter(h.getDataInizio()))) {
                h.setStato(StatoHackathon.IN_CORSO);
                hackathonRepository.save(h);
                // Qui in futuro andrà la notifica tramite Spring Events
            } else if (h.getStato() == StatoHackathon.IN_CORSO &&
                    (oggi.isEqual(h.getDataFine()) || oggi.isAfter(h.getDataFine()))) {
                h.setStato(StatoHackathon.IN_VALUTAZIONE);
                hackathonRepository.save(h);
            }
        }
    }
}
