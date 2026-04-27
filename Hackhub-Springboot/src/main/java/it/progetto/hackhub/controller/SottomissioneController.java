package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.SottomissioneDTO;
import it.progetto.hackhub.dto.SottomissioneRequest;
import it.progetto.hackhub.service.SottomissioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sottomissioni")
public class SottomissioneController {

    private final SottomissioneService sottomissioneService;

    @Autowired
    public SottomissioneController(SottomissioneService sottomissioneService) {
        this.sottomissioneService = sottomissioneService;
    }

    @PostMapping("/invia")
    public SottomissioneDTO inviaSottomissione(@RequestBody SottomissioneRequest request) {
        return sottomissioneService.sendSottomissione(request);
    }
}
