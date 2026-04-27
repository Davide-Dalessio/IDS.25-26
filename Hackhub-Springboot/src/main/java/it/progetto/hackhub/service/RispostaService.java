package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.*;
import it.progetto.hackhub.model.*;
import it.progetto.hackhub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RispostaService {

    private final InvitoRepository invitoRepository;
    private final TeamRepository teamRepository;
    private final UtenteRepository utenteRepository;

    @Autowired
    public RispostaService(InvitoRepository invitoRepository,
                          TeamRepository teamRepository,
                          UtenteRepository utenteRepository) {
        this.invitoRepository = invitoRepository;
        this.teamRepository = teamRepository;
        this.utenteRepository = utenteRepository;
    }

    public RispostaDTO gestisciRisposta(RispostaRequest request) {

        Invito invito = invitoRepository.findById(request.getInvitoId())
                .orElseThrow(() -> new RuntimeException("Invito non trovato"));


        if (teamRepository.existsByMembri_Id(invito.getUtenteID())) {
            throw new IllegalStateException("L'utente fa già parte di un team!");
        }

        if (request.isAccetta()) {

            Team team = teamRepository.findByMembri_Id(invito.getMittenteID())
                    .orElseThrow(() -> new RuntimeException("Team del mittente non trovato"));

            Utente invitato = utenteRepository.findById(invito.getUtenteID())
                    .orElseThrow(() -> new RuntimeException("Utente invitato non trovato"));

            team.getMembri().add(invitato);
            teamRepository.save(team);
            
            System.out.println("RispostaService: Utente (" + invitato.getNome() + ") aggiunto al Team (" + team.getNome() + ")");
        }

        invitoRepository.delete(invito);
        System.out.println("RispostaService: Record Invito (" + request.getInvitoId() + ") eliminato.");

        return new RispostaDTO("Operazione di gestione invito completata e invito eliminato");
    }
}
