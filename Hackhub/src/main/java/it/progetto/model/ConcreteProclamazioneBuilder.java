package it.progetto.model;

import it.progetto.dto.ProclamazioneRequest;

public class ConcreteProclamazioneBuilder  implements ProclamazioneBuilder{
    @Override
    public Proclamazione createProclamazione(ProclamazioneRequest request, boolean pagamentoEseguito) {
        return new Proclamazione(
                request.getOrganizzatoreId(),
                request.getHackathonId(),
                request.getTeamId(),
                pagamentoEseguito
        );
    }
}
