package it.progetto.service;

import it.progetto.model.Hackathon;

public class SistemaDiPagamento {

    public void runTask(int hackathonId) {
        Hackathon hackathon = getHackathon(hackathonId);
        SistemaNotificaVincitori moduloSdP = new SistemaNotificaVincitori();
        hackathon.getEvents().subscribe("HACKATHON_CONCLUSO", moduloSdP);
        hackathon.setStato(it.progetto.model.StatoHackathon.CONCLUSO);
    }

    private Hackathon getHackathon(int hackathonId) {
        Hackathon h = new Hackathon();
        h.setHackathonId(hackathonId);
        h.setNome("Hackathon #" + hackathonId);
        return h;
    }

    public void elaboraTransazione(String iban, double premio) {
        System.out.println("   [SISTEMA ESTERNO] Transazione completata. Inviati " + premio + "€ all'IBAN " + iban);
    }
}
