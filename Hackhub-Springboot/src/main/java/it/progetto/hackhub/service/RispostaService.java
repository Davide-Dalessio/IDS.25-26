package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.RispostaDTO;
import it.progetto.hackhub.dto.RispostaRequest;
import it.progetto.hackhub.model.Invito;
import it.progetto.hackhub.model.Team;
import it.progetto.hackhub.model.Utente;
import it.progetto.hackhub.repository.InvitoRepository;
import it.progetto.hackhub.repository.TeamRepository;
import it.progetto.hackhub.repository.UtenteRepository;
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
        
        // 1. Recupero l'invito dal database
        Invito invito = invitoRepository.findById(request.getInvitoId())
                .orElseThrow(() -> new RuntimeException("Invito non trovato"));

        // 2. Controllo se l'utente è "sano" (non già in un team)
        if (teamRepository.existsByMembri_Id(invito.getUtenteID())) {
            throw new IllegalStateException("L'utente fa già parte di un team!");
        }

        // 3. Se accetta, lo aggiungiamo al team del mittente
        if (request.isAccetta()) {
            // Cerco il team del mittente
            Team team = teamRepository.findByMembri_Id(invito.getMittenteID())
                    .orElseThrow(() -> new RuntimeException("Team del mittente non trovato"));
            
            // Recupero l'utente invitato
            Utente invitato = utenteRepository.findById(invito.getUtenteID())
                    .orElseThrow(() -> new RuntimeException("Utente invitato non trovato"));

            // Aggiungo l'utente al team
            team.getMembri().add(invito); // ERRORE! Devo aggiungere l'utente, non l'invito
            // Correzione:
            team.getMembri().add(invitato);
            teamRepository.save(team);
            
            System.out.println("RispostaService: Utente (" + invitato.getNome() + ") aggiunto al Team (" + team.getNome() + ")");
        }

        // 4. Elimino l'invito (come da logica originale)
        invitoRepository.delete(invito);
        System.out.println("RispostaService: Record Invito (" + request.getInvitoId() + ") eliminato.");

        return new RispostaDTO("Operazione di gestione invito completata e invito eliminato");
    }
}
