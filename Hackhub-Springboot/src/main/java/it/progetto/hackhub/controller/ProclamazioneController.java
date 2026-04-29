package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.ProclamazioneDTO;
import it.progetto.hackhub.dto.ProclamazioneRequest;
import it.progetto.hackhub.service.ProclamazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proclamazioni")
public class ProclamazioneController {

    private final ProclamazioneService proclamazioneService;

    @Autowired
    public ProclamazioneController(ProclamazioneService proclamazioneService) {
        this.proclamazioneService = proclamazioneService;
    }

    @PostMapping("/proclama")
    public ProclamazioneDTO proclamaVincitore(@RequestBody ProclamazioneRequest request) {
        return proclamazioneService.proclaimWinner(request);
    }
}
