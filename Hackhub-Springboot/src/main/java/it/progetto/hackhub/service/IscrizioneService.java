package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.IscrizioneDTO;
import it.progetto.hackhub.dto.IscrizioneRequest;
import it.progetto.hackhub.model.*;
import it.progetto.hackhub.repository.HackathonRepository;
import it.progetto.hackhub.repository.PartecipazioneRepository;
import it.progetto.hackhub.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IscrizioneService {

    private final PartecipazioneRepository partecipazioneRepository;
    private final TeamRepository teamRepository;
    private final HackathonRepository hackathonRepository;

    @Autowired
    public IscrizioneService(PartecipazioneRepository partecipazioneRepository,
                             TeamRepository teamRepository,
                             HackathonRepository hackathonRepository) {
        this.partecipazioneRepository = partecipazioneRepository;
        this.teamRepository = teamRepository;
        this.hackathonRepository = hackathonRepository;
    }

    public IscrizioneDTO iscriviTeam(IscrizioneRequest request) {
        
        Team team = teamRepository.findById(request.getTeamId())
                .orElseThrow(() -> new RuntimeException("Team non trovato"));
        
        Hackathon hackathon = hackathonRepository.findById(request.getHackathonId())
                .orElseThrow(() -> new RuntimeException("Hackathon non trovato"));

        if (hackathon.getStato() != StatoHackathon.IN_ISCRIZIONE) {
            throw new IllegalStateException("Iscrizioni chiuse per questo hackathon");
        }

        if (partecipazioneRepository.existsByTeam_TeamIdAndHackathon_HackathonId(request.getTeamId(), request.getHackathonId())) {
            throw new IllegalStateException("Team già iscritto a questo hackathon");
        }

        if (team.getMembri().size() > hackathon.getMaxMembriTeam()) {
            throw new IllegalStateException("Dimensione team superiore al limite consentito (" + hackathon.getMaxMembriTeam() + ")");
        }

        Partecipazione p = new Partecipazione(team, hackathon);
        partecipazioneRepository.save(p);

        team.setHackathon(hackathon);
        teamRepository.save(team);

        return new IscrizioneDTO(p.getTeam().getTeamId(), p.getHackathon().getHackathonId(), p.getStato(), p.getDataIscrizione());
    }
}
