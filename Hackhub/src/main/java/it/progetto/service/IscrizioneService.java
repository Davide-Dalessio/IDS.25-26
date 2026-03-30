package it.progetto.service;

import it.progetto.dto.IscrizioneDTO;
import it.progetto.dto.IscrizioneRequest;
import it.progetto.model.*;

import java.util.ArrayList;
import java.util.List;

public class IscrizioneService {

    private final List<Partecipazione> partecipazioni = new ArrayList<>();

    public IscrizioneDTO iscriviTeam(IscrizioneRequest request) {

        checkStatoHackathon(request.getHackathonId());
        checkGiaIscritto(request.getTeamId(), request.getHackathonId());
        checkDimensioneTeam(request.getTeamId(), request.getHackathonId());

        Partecipazione p = new Partecipazione(request.getTeamId(), request.getHackathonId());
        save(p);

        return new IscrizioneDTO(p.getTeamId(), p.getHackathonId(), p.getStato(), p.getDataIscrizione());
    }

    private void checkStatoHackathon(int hackathonId) {
        Hackathon hackathon = getHackathonById(hackathonId);
        if (hackathon.getStato() != StatoHackathon.IN_ISCRIZIONE) {
            throw new IllegalStateException("Iscrizioni chiuse");
        }
    }

    private void checkGiaIscritto(int teamId, int hackathonId) {
        for (Partecipazione p : partecipazioni) {
            if (p.getTeamId() == teamId && p.getHackathonId() == hackathonId) {
                throw new IllegalStateException("Team già iscritto");
            }
        }
    }

    private void checkDimensioneTeam(int teamId, int hackathonId) {
        Team team = getTeamById(teamId);
        Hackathon hackathon = getHackathonById(hackathonId);
        if (team.getMembri().size() > hackathon.getMaxMembriTeam()) {
            throw new IllegalStateException("Dimensione team superiore al limite");
        }
    }

    private void save(Partecipazione p) {
        partecipazioni.add(p);
        System.out.println("Service: iscrizione salvata -> " + p);
    }

    private Hackathon getHackathonById(int hackathonId) {
        Hackathon h = new Hackathon();
        if (hackathonId == 2) {
            h.setStato(StatoHackathon.IN_CORSO);
            h.setMaxMembriTeam(5);
        } else {
            h.setStato(StatoHackathon.IN_ISCRIZIONE);
            h.setMaxMembriTeam(3);
        }
        return h;
    }

    private Team getTeamById(int teamId) {
        Team team = new Team();
        team.setId(teamId);
        team.setNome("Team-" + teamId);
        if (teamId == 99) {
            team.aggiungiMembro(new Utente(1, "Alice", "alice@mail.it"));
            team.aggiungiMembro(new Utente(2, "Bob", "bob@mail.it"));
            team.aggiungiMembro(new Utente(3, "Carlo", "carlo@mail.it"));
            team.aggiungiMembro(new Utente(4, "Diana", "diana@mail.it"));
        } else {
            team.aggiungiMembro(new Utente(1, "Alice", "alice@mail.it"));
            team.aggiungiMembro(new Utente(2, "Bob", "bob@mail.it"));
        }
        return team;
    }
}
