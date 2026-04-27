package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.InvitoDTO;
import it.progetto.hackhub.dto.InvitoRequest;
import it.progetto.hackhub.model.*;
import it.progetto.hackhub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvitoService {

    private final InvitoRepository invitoRepository;
    private final UtenteRepository utenteRepository;
    private final TeamRepository teamRepository;
    private final EventManager eventManager = new EventManager();

    @Autowired
    public InvitoService(InvitoRepository invitoRepository, 
                         UtenteRepository utenteRepository,
                         TeamRepository teamRepository) {
        this.invitoRepository = invitoRepository;
        this.utenteRepository = utenteRepository;
        this.teamRepository = teamRepository;
    }

    public InvitoDTO requestInvito(InvitoRequest request) {

        Utente invitato = utenteRepository.findById(request.getUtenteID())
                .orElseThrow(() -> new RuntimeException("Errore: L'utente invitato non esiste!"));

        if (teamRepository.existsByMembri_Id(request.getUtenteID())) {
            throw new IllegalStateException("Errore: L'utente fa già parte di un team!");
        }

        Utente mittente = utenteRepository.findById(request.getMittenteID())
                .orElseThrow(() -> new RuntimeException("Mittente non trovato"));

        InvitoBuilder builder = new ConcreteInvitoBuilder();
        builder.reset();
        builder.setMittente(request.getMittenteID());
        builder.setUtenteInvitato(request.getUtenteID());

        Invito invito = builder.getResult();

        invitoRepository.save(invito);

        eventManager.subscribe("nuovo_invito", new NotificaUtenteObserver(invitato.getId()));

        sendInvito(invito, mittente.getNome());

        return new InvitoDTO(invito.getMittenteID(), invito.getUtenteID());
    }

    private void sendInvito(Invito invito, String nomeMittente) {
        eventManager.notify("nuovo_invito", "Ehi! " + nomeMittente + " ti ha invitato nel suo team!");
    }
}
