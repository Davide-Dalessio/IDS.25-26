package it.progetto.model;

import it.progetto.dto.ValutazioneRequest;

public interface ValutazioneBuilder {
    Valutazione createValutazione(int id, ValutazioneRequest request);
}
