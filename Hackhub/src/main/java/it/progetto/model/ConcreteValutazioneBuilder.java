package it.progetto.model;

import it.progetto.dto.ValutazioneRequest;

public class ConcreteValutazioneBuilder implements ValutazioneBuilder {

    public Valutazione createValutazione(int id, ValutazioneRequest request) {

        return new Valutazione(
                id,
                request.getGiudiceId(),
                request.getHackathonId(),
                request.getSubmissionId(),
                request.getCommento(),
                request.getPunteggio()
        );
    }
}
