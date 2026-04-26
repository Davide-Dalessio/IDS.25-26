package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.HackathonDTO;
import it.progetto.hackhub.dto.HackathonRequest;
import it.progetto.hackhub.service.HackathonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hackathons")
public class HackathonController {

    private final HackathonService hackathonService;

    @Autowired
    public HackathonController(HackathonService hackathonService) {
        this.hackathonService = hackathonService;
    }

    @PostMapping("/create")
    public HackathonDTO createHackathon(@RequestBody HackathonRequest request) {
        return hackathonService.requestHackathon(request);
    }

    @PostMapping("/update-phases")
    public void aggiornaFasi() {
        hackathonService.aggiornaFasi();
    }
}