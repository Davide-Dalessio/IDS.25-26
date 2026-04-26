package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.TeamDTO;
import it.progetto.hackhub.dto.TeamRequest;
import it.progetto.hackhub.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/create")
    public TeamDTO createTeam(@RequestBody TeamRequest request) {
        return teamService.requestTeam(request);
    }
}
