package it.progetto.hackhub.controller;

import it.progetto.hackhub.dto.LoginRequest;
import it.progetto.hackhub.dto.LoginResponse;
import it.progetto.hackhub.service.AutenticazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AutenticazioneController {

    private final AutenticazioneService autenticazioneService;

    @Autowired
    public AutenticazioneController(AutenticazioneService autenticazioneService) {
        this.autenticazioneService = autenticazioneService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return autenticazioneService.login(request.getEmail(), request.getPassword());
    }
}
