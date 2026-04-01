package it.progetto.service;

import it.progetto.dto.SottomissioneDTO;
import it.progetto.dto.SottomissioneRequest;
import it.progetto.model.*;

import java.util.ArrayList;
import java.util.List;

public class SottomissioneService {

    private final List<Sottomissione> sottomissioni = new ArrayList<>();

    public void checkValido(int teamId, int hackathonId) {
        checkIscrizione(teamId, hackathonId);
        checkSottomissione(teamId, hackathonId);
        checkScadenza(hackathonId);
    }

    public SottomissioneDTO sendSottomissione(SottomissioneRequest request) {
        Sottomissione s = new Sottomissione(request.getTeamId(), request.getHackathonId(), request.getLink());
        save(s);
        return new SottomissioneDTO(s.getTeamId(), s.getHackathonId(), s.getLink());
    }

    private void checkIscrizione(int teamId, int hackathonId) {
        if (teamId == 99) {
            throw new IllegalStateException("Team non iscritto");
        }
    }

    private void checkSottomissione(int teamId, int hackathonId) {
        for (Sottomissione s : sottomissioni) {
            if (s.getTeamId() == teamId && s.getHackathonId() == hackathonId) {
                throw new IllegalStateException("Sottomissione già presente");
            }
        }
    }

    private void checkScadenza(int hackathonId) {
        Hackathon h = getHackathonById(hackathonId);
        if (h.getStato() != StatoHackathon.IN_CORSO) {
            throw new IllegalStateException("Scadenza sottomissioni superata");
        }
    }

    private void save(Sottomissione s) {
        sottomissioni.add(s);
        System.out.println("Service: sottomissione salvata -> " + s);
    }

    private Hackathon getHackathonById(int hackathonId) {
        Hackathon h = new Hackathon();
        if (hackathonId == 2) {
            h.setStato(StatoHackathon.IN_VALUTAZIONE);
        } else {
            h.setStato(StatoHackathon.IN_CORSO);
        }
        return h;
    }
}
