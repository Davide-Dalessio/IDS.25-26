package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.RispostaDTO;
import it.progetto.hackhub.dto.RispostaRequest;
import it.progetto.hackhub.service.RispostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/risposte")
public class RispostaController {

    private final RispostaService rispostaService;

    @Autowired
    public RispostaController(RispostaService rispostaService) {
        this.rispostaService = rispostaService;
    }

    @PostMapping("/rispondi")
    public RispostaDTO gestisciRisposta(@RequestBody RispostaRequest request) {
        return rispostaService.requestRisposta(request);
    }
}
