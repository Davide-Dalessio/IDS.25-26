package it.progetto.service;

import it.progetto.dto.RegistrazioneRequest;
import it.progetto.dto.RegistrazioneDTO;
import it.progetto.model.Utente;

public class RegistrazioneService {

    public RegistrazioneDTO processaRegistrazione(RegistrazioneRequest request) {
        checkDati(request);
        
        Utente utente = new Utente(request.getNome(), request.getEmail(), request.getPassword());
        
        save(utente);
        
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

    private void save(Utente utente) {
        System.out.println("   [DB - UTENTI] Salvato nuovo utente: " + utente.getNome() + " (" + utente.getEmail() + ")");
    }
}
