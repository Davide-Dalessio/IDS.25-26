package it.progetto.hackhub.service;

import it.progetto.hackhub.dto.RegistrazioneDTO;
import it.progetto.hackhub.dto.RegistrazioneRequest;
import it.progetto.hackhub.model.Utente;
import it.progetto.hackhub.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrazioneService {

    private final UtenteRepository utenteRepository;

    @Autowired
    public RegistrazioneService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public RegistrazioneDTO processaRegistrazione(RegistrazioneRequest request) {
        checkDati(request);
        
        if (utenteRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email già registrata!");
        }

        Utente utente = new Utente(request.getNome(), request.getEmail(), request.getPassword());
        utenteRepository.save(utente);
        
        return new RegistrazioneDTO(utente.getNome(), utente.getEmail());
    }

    public void checkDati(RegistrazioneRequest request) {
        if (request.getNome() == null || request.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome utente non valido.");
        }
        if (request.getEmail() == null || !request.getEmail().contains("@")) {
            throw new IllegalArgumentException("Email non valida.");
        }
        if (request.getPassword() == null || request.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password troppo debole (minimo 6 caratteri).");
        }
    }
}
