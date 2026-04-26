package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.TeamDTO;
import it.progetto.hackhub.dto.TeamRequest;
import it.progetto.hackhub.model.*;
import it.progetto.hackhub.repository.TeamRepository;
import it.progetto.hackhub.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final UtenteRepository utenteRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, UtenteRepository utenteRepository) {
        this.teamRepository = teamRepository;
        this.utenteRepository = utenteRepository;
    }

    public TeamDTO requestTeam(TeamRequest request) {
        this.selfCheck(request);

        TeamBuilder builder = new ConcreteTeamBuilder();
        builder.reset();
        builder.setNome(request.getNomeTeam());

        Utente creatore = utenteRepository.findById(request.getUtenteID())
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));

        builder.aggiungiMembroIniziale(creatore);

        Team team = builder.getResult();

        teamRepository.save(team);

        return new TeamDTO(team.getTeamId(), team.getNome(), team.getMembri());
    }

    private void selfCheck(TeamRequest request) {
        if (request.getNomeTeam().equalsIgnoreCase("Esistente")) {
            throw new RuntimeException("Nome team già occupato!");
        }
    }
}
