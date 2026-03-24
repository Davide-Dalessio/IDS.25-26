package it.progetto.service;

import it.progetto.dto.TeamDTO;
import it.progetto.dto.TeamRequest;
import it.progetto.model.*;

public class TeamService {

    public boolean checkTeam(int utenteID) {
        if (utenteID == 10) {
            throw new RuntimeException("L'utente fa già parte di un team!");
        }
        return true;
    }

    public TeamDTO requestTeam(TeamRequest request) {
        this.selfCheck(request);

        TeamBuilder builder = new ConcreteTeamBuilder();
        builder.reset();
        builder.setNome(request.getNomeTeam());
        Utente creatore = getUtenteById(request.getUtenteID());
        builder.aggiungiMembroIniziale(creatore);

        Team team = builder.getResult();

        this.save(team);
        this.updateUserTeam(request.getUtenteID(), 1); // ID team simulato = 1

        System.out.println("Successo: Team " + team.getNome() + " creato con membri: " + team.getMembri());

        return new TeamDTO(1, team.getNome(), team.getMembri());
    }

    private void selfCheck(TeamRequest request) {
        if (request.getNomeTeam().equalsIgnoreCase("Esistente")) {
            throw new RuntimeException("Nome team già occupato!");
        }
    }

    private void save(Team t) {
        System.out.println("Repo: Team salvato nel database.");
    }

    private void updateUserTeam(int uId, int tId) {
        System.out.println("Repo: Utente " + uId + " collegato al team " + tId);
    }

    private Utente getUtenteById(int id) {
        return new Utente(id, "Utente-" + id, "utente" + id + "@email.it");
    }
}