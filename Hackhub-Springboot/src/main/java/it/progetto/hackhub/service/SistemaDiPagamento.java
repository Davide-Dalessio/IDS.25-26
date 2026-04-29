package it.progetto.hackhub.service;

import it.progetto.hackhub.model.EventManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SistemaDiPagamento {

    private final SistemaNotificaVincitori sistemaNotificaVincitori;

    @Autowired
    public SistemaDiPagamento(SistemaNotificaVincitori sistemaNotificaVincitori) {
        this.sistemaNotificaVincitori = sistemaNotificaVincitori;
    }

    public void runTask(int hackathonId) {
        EventManager events = new EventManager();
        events.subscribe("HACKATHON_CONCLUSO", sistemaNotificaVincitori);
        
        events.notify("HACKATHON_CONCLUSO", String.valueOf(hackathonId));
    }

    public void elaboraTransazione(String iban, double premio) {
        System.out.println("   [SISTEMA ESTERNO] Transazione completata. Inviati " + premio + "€ all'IBAN " + iban);
    }
}
