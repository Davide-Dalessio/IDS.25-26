package it.progetto.model;

import it.progetto.dto.ProclamazioneRequest;

public interface ProclamazioneBuilder {
    Proclamazione createProclamazione(ProclamazioneRequest request);
}
