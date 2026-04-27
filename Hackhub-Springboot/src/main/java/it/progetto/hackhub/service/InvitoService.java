package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.InvitoDTO;
import it.progetto.hackhub.dto.InvitoRequest;
import it.progetto.hackhub.model.*;
import it.progetto.hackhub.repository.InvitoRepository;
import it.progetto.hackhub.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvitoService {

    private final InvitoRepository invitoRepository;
    private final UtenteRepository utenteRepository;
    private final EventManager eventManager = new EventManager();

    @Autowired
    public InvitoService(InvitoRepository invitoRepository, UtenteRepository utenteRepository) {
        this.invitoRepository = invitoRepository;
        this.utenteRepository = utenteRepository;
    }

    public InvitoDTO requestInvito(InvitoRequest request) {
        // 1. Controllo se l'utente esiste (Logica reale invece del vecchio check finto)
        Utente invitato = utenteRepository.findById(request.getUtenteID())
                .orElseThrow(() -> new RuntimeException("Utente invitato non trovato"));
        
        Utente mittente = utenteRepository.findById(request.getMittenteID())
                .orElseThrow(() -> new RuntimeException("Mittente non trovato"));

        // 2. Uso del Builder (Fedele all'originale)
        InvitoBuilder builder = new ConcreteInvitoBuilder();
        builder.reset();
        builder.setMittente(request.getMittenteID());
        builder.setUtenteInvitato(request.getUtenteID());

        Invito invito = builder.getResult();

        // 3. Salvataggio e Notifica
        invitoRepository.save(invito);
        
        // Simulo l'iscrizione dell'utente alle notifiche (per il test)
        eventManager.subscribe("nuovo_invito", new NotificaUtenteObserver(invitato.getId()));
        
        // Scateno l'evento
        sendInvito(invito, mittente.getNome());

        return new InvitoDTO(invito.getMittenteID(), invito.getUtenteID());
    }

    private void sendInvito(Invito invito, String nomeMittente) {
        eventManager.notify("nuovo_invito", "Ehi! " + nomeMittente + " ti ha invitato nel suo team!");
    }
}
