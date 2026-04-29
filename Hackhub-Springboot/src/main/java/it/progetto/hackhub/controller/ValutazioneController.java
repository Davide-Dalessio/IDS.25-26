package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.ValutazioneDTO;
import it.progetto.hackhub.dto.ValutazioneRequest;
import it.progetto.hackhub.service.ValutazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/valutazioni")
public class ValutazioneController {

    private final ValutazioneService valutazioneService;

    @Autowired
    public ValutazioneController(ValutazioneService valutazioneService) {
        this.valutazioneService = valutazioneService;
    }

    @PostMapping("/valuta")
    public ValutazioneDTO valuta(@RequestBody ValutazioneRequest request) {
        return valutazioneService.requestEvaluation(request);
    }
}
