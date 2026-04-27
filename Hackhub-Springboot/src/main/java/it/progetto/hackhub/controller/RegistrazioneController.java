package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.RegistrazioneDTO;
import it.progetto.hackhub.dto.RegistrazioneRequest;
import it.progetto.hackhub.service.RegistrazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class RegistrazioneController {

    private final RegistrazioneService registrazioneService;

    @Autowired
    public RegistrazioneController(RegistrazioneService registrazioneService) {
        this.registrazioneService = registrazioneService;
    }

    @PostMapping("/register")
    public RegistrazioneDTO registraUtente(@RequestBody RegistrazioneRequest request) {
        return registrazioneService.processaRegistrazione(request);
    }
}
