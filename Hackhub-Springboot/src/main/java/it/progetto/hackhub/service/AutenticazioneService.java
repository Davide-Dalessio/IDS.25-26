package it.progetto.hackhub.service;

import it.progetto.hackhub.model.Utente;
import it.progetto.hackhub.dto.LoginResponse;
import it.progetto.hackhub.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticazioneService {

    private final UtenteRepository utenteRepository;

    @Autowired
    public AutenticazioneService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public LoginResponse eseguiLogin(String email, String password) {
        Utente utenteTrovato = utenteRepository.findByEmail(email).orElse(null);

        if (utenteTrovato == null) {
            return new LoginResponse(false, "Errore: Utente non trovato.", null);
        }

        if (!checkPassword(utenteTrovato, password)) {
            return new LoginResponse(false, "Errore: Password errata.", null);
        }

        SessionManager.getInstance().creaSessione(utenteTrovato);
        return new LoginResponse(true, "Login effettuato.", utenteTrovato);
    }

    public void eseguiLogout() {
        SessionManager.getInstance().invalidaSessione();
    }

    private boolean checkPassword(Utente utente, String password) {
        return utente.getPassword().equals(password);
    }
}
