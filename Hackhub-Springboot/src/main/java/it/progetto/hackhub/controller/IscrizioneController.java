package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.IscrizioneDTO;
import it.progetto.hackhub.dto.IscrizioneRequest;
import it.progetto.hackhub.service.IscrizioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/iscrizioni")
public class IscrizioneController {

    private final IscrizioneService iscrizioneService;

    @Autowired
    public IscrizioneController(IscrizioneService iscrizioneService) {
        this.iscrizioneService = iscrizioneService;
    }

    @PostMapping("/iscrivi")
    public IscrizioneDTO iscriviTeam(@RequestBody IscrizioneRequest request) {
        return iscrizioneService.iscriviTeam(request);
    }
}
