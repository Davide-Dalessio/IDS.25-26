package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.ValutazioneDTO;
import it.progetto.hackhub.dto.ValutazioneRequest;
import it.progetto.hackhub.model.*;
import it.progetto.hackhub.repository.HackathonRepository;
import it.progetto.hackhub.repository.SottomissioneRepository;
import it.progetto.hackhub.repository.ValutazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValutazioneService {

    private final ValutazioneRepository valutazioneRepository;
    private final HackathonRepository hackathonRepository;
    private final SottomissioneRepository sottomissioneRepository;

    @Autowired
    public ValutazioneService(ValutazioneRepository valutazioneRepository,
            HackathonRepository hackathonRepository,
            SottomissioneRepository sottomissioneRepository) {
        this.valutazioneRepository = valutazioneRepository;
        this.hackathonRepository = hackathonRepository;
        this.sottomissioneRepository = sottomissioneRepository;
    }

    public ValutazioneDTO requestEvaluation(ValutazioneRequest request) {

        Hackathon hackathon = hackathonRepository.findById(request.getHackathonId())
                .orElseThrow(() -> new IllegalArgumentException("L'hackathon selezionato non esiste."));

        if (hackathon.getGiudici() == null
                || hackathon.getGiudici().stream().noneMatch(u -> u.getId() == request.getGiudiceId())) {
            throw new IllegalArgumentException("Il giudice non è assegnato all'hackathon selezionato.");
        }

        if (hackathon.getStato() != StatoHackathon.IN_VALUTAZIONE) {
            throw new IllegalArgumentException("L'hackathon non è nello stato 'In valutazione'.");
        }

        Sottomissione sottomissione = sottomissioneRepository.findById(request.getSubmissionId())
                .orElseThrow(() -> new IllegalArgumentException("La sottomissione selezionata non esiste."));

        if (sottomissione.getHackathon().getHackathonId() != request.getHackathonId()) {
            throw new IllegalArgumentException("La sottomissione selezionata non esiste per questo hackathon.");
        }

        if (valutazioneRepository.existsBySubmissionIdAndGiudiceId(request.getSubmissionId(), request.getGiudiceId())) {
            throw new IllegalStateException("Hai già valutato questa sottomissione.");
        }
        validateEvaluation(request.getPunteggio(), request.getCommento());
        ValutazioneBuilder builder = new ConcreteValutazioneBuilder();
        builder.reset();
        builder.setIds(request.getGiudiceId(), request.getHackathonId(), request.getSubmissionId());
        builder.setGiudizio(request.getPunteggio(), request.getCommento());

        Valutazione valutazione = builder.getResult();
        Valutazione salvata = valutazioneRepository.save(valutazione);

        return new ValutazioneDTO(
                salvata.getValutazioneId(),
                salvata.getSubmissionId(),
                salvata.getGiudiceId(),
                salvata.getCommento(),
                salvata.getPunteggio(),
                "Valutazione salvata con successo.");
    }

    private void validateEvaluation(int punteggio, String commento) {
        if (punteggio < 0 || punteggio > 10) {
            throw new IllegalArgumentException("Il punteggio deve essere compreso tra 0 e 10.");
        }
        if (commento == null || commento.trim().isEmpty()) {
            throw new IllegalArgumentException("Il giudizio testuale è obbligatorio.");
        }
    }
}
