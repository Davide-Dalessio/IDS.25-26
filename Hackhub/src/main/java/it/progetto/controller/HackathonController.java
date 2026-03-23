package it.progetto.controller;

import it.progetto.dto.HackathonDTO;
import it.progetto.dto.HackathonRequest;
import it.progetto.service.HackathonService;

public class HackathonController {
    private final HackathonService hackathonService;

    public HackathonController() {
        this.hackathonService = new HackathonService();
    }

    public HackathonDTO sendDati(String nome, String inizio, String fine, double premio, int utenteID) {

        HackathonRequest request = this.createRequest(nome, inizio, fine, premio, utenteID);

        System.out.println("Controller: Request creata. Invio al Service...");

        return hackathonService.requestHackathon(request);
    }

    private HackathonRequest createRequest(String nome, String inizio, String fine, double premio, int utenteID) {
        return new HackathonRequest(nome, inizio, fine, premio, utenteID);
    }
}