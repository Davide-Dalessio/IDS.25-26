package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.InvitoDTO;
import it.progetto.hackhub.dto.InvitoRequest;
import it.progetto.hackhub.service.InvitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inviti")
public class InvitoController {

    private final InvitoService invitoService;

    @Autowired
    public InvitoController(InvitoService invitoService) {
        this.invitoService = invitoService;
    }

    @PostMapping("/invia")
    public InvitoDTO inviaInvito(@RequestBody InvitoRequest request) {
        return invitoService.requestInvito(request);
    }
}
