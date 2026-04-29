package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.SottomissioneDTO;
import it.progetto.hackhub.dto.SottomissioneRequest;
import it.progetto.hackhub.model.*;
import it.progetto.hackhub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SottomissioneService {

    private final SottomissioneRepository sottomissioneRepository;
    private final TeamRepository teamRepository;
    private final HackathonRepository hackathonRepository;
    private final PartecipazioneRepository partecipazioneRepository;

    @Autowired
    public SottomissioneService(SottomissioneRepository sottomissioneRepository,
                               TeamRepository teamRepository,
                               HackathonRepository hackathonRepository,
                               PartecipazioneRepository partecipazioneRepository) {
        this.sottomissioneRepository = sottomissioneRepository;
        this.teamRepository = teamRepository;
        this.hackathonRepository = hackathonRepository;
        this.partecipazioneRepository = partecipazioneRepository;
    }

    public SottomissioneDTO sendSottomissione(SottomissioneRequest request) {
        
        Team team = teamRepository.findById(request.getTeamId())
                .orElseThrow(() -> new RuntimeException("Team non trovato"));
        
        Hackathon hackathon = hackathonRepository.findById(request.getHackathonId())
                .orElseThrow(() -> new RuntimeException("Hackathon non trovato"));

        if (!partecipazioneRepository.existsByTeam_TeamIdAndHackathon_HackathonId(request.getTeamId(), request.getHackathonId())) {
            throw new IllegalStateException("Il team non è iscritto a questo hackathon");
        }

        if (hackathon.getStato() != StatoHackathon.IN_CORSO) {
            throw new IllegalStateException("Impossibile inviare o aggiornare la sottomissione: l'hackathon non è in fase di svolgimento (IN_CORSO)");
        }

        Sottomissione s = sottomissioneRepository.findByTeam_TeamIdAndHackathon_HackathonId(request.getTeamId(), request.getHackathonId())
                .orElse(new Sottomissione(team, hackathon, request.getLink()));
        
        s.setLink(request.getLink());
        
        sottomissioneRepository.save(s);

        return new SottomissioneDTO(s.getSottomissioneId(), s.getTeam().getTeamId(), s.getHackathon().getHackathonId(), s.getLink());
    }
}
