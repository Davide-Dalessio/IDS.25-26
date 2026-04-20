package it.progetto.model;

import it.progetto.dto.ProclamazioneRequest;

public class ConcreteProclamazioneBuilder  implements ProclamazioneBuilder{
    @Override
    public Proclamazione createProclamazione(ProclamazioneRequest request) {
        return new Proclamazione(
                request.getOrganizzatoreId(),
                request.getHackathonId(),
                request.getTeamId()
        );
    }
}
