package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.ProclamazioneDTO;
import it.progetto.hackhub.dto.ProclamazioneRequest;
import it.progetto.hackhub.model.*;
import it.progetto.hackhub.repository.HackathonRepository;
import it.progetto.hackhub.repository.ProclamazioneRepository;
import it.progetto.hackhub.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProclamazioneService {

    private final ProclamazioneBuilder builder = new ConcreteProclamazioneBuilder();
    private final ProclamazioneRepository proclamazioneRepository;
    private final HackathonRepository hackathonRepository;
    private final TeamRepository teamRepository;
    private final SistemaDiPagamento sistemaDiPagamento;

    @Autowired
    public ProclamazioneService(ProclamazioneRepository proclamazioneRepository,
                               HackathonRepository hackathonRepository,
                               TeamRepository teamRepository,
                               SistemaDiPagamento sistemaDiPagamento) {
        this.proclamazioneRepository = proclamazioneRepository;
        this.hackathonRepository = hackathonRepository;
        this.teamRepository = teamRepository;
        this.sistemaDiPagamento = sistemaDiPagamento;
    }

    public ProclamazioneDTO proclaimWinner(ProclamazioneRequest request) {
        Hackathon hackathon = hackathonRepository.findById(request.getHackathonId())
                .orElseThrow(() -> new IllegalArgumentException("Hackathon non trovato."));
        
        if (hackathon.getOrganizzatoreID() != request.getOrganizzatoreId()) {
            throw new IllegalArgumentException("L'organizzatore non è autorizzato su questo hackathon.");
        }

        if (hackathon.getStato() != StatoHackathon.IN_VALUTAZIONE) {
            throw new IllegalArgumentException("L'hackathon non è nello stato corretto per proclamare un vincitore.");
        }

        builder.reset();
        builder.setOrganizzatoreId(request.getOrganizzatoreId());
        builder.setHackathonId(request.getHackathonId());
        builder.setTeamId(request.getTeamId());
        Proclamazione proclamazione = builder.getResult();
        
        proclamazioneRepository.save(proclamazione);

        hackathon.setStato(StatoHackathon.CONCLUSO);
        hackathonRepository.save(hackathon);

        sistemaDiPagamento.runTask(request.getHackathonId());

        return new ProclamazioneDTO(
                request.getHackathonId(),
                request.getTeamId(),
                false,
                "Team vincitore proclamato con successo. Attesa dati bancari.");
    }
}
