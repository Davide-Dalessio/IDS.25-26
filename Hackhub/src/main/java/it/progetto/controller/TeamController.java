package it.progetto.controller;

import it.progetto.dto.TeamDTO;
import it.progetto.dto.TeamRequest;
import it.progetto.service.TeamService;

public class TeamController {
    private final TeamService teamService;

    public TeamController() {
        this.teamService = new TeamService();
    }

    public boolean checkValidUtente(int utenteID) {
        try {
            return teamService.checkTeam(utenteID);
        } catch (RuntimeException e) {
            System.out.println("Errore: " + e.getMessage());
            return false;
        }
    }

    public TeamDTO sendDati(String nomeTeam, int utenteID) {
        TeamRequest request = this.createRequest(nomeTeam, utenteID);

        return teamService.requestTeam(request);
    }

    private TeamRequest createRequest(String nome, int id) {
        return new TeamRequest(nome, id);
    }
}