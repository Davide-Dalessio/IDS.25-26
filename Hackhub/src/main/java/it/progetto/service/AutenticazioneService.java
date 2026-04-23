package it.progetto.service;
import it.progetto.model.Utente;
import it.progetto.dto.LoginResponse;
public class AutenticazioneService {
    public LoginResponse eseguiLogin(String email, String password) {

        // Passo 4: SYSTEM Cerca l'email nel database (Simulato)
        Utente utenteTrovato = findByEmailSimulato(email);

        // Estensione 4.a: SYSTEM rileva che l'email inserita non esiste
        if (utenteTrovato == null) {
            return new LoginResponse(false, "Errore: Utente non trovato per l'email fornita.", null);
        }

        // Passo 5 e Estensione 5.a: SYSTEM Confronta la password
        if (!utenteTrovato.getPassword().equals(password)) {
            return new LoginResponse(false, "Errore: Password errata.", null);
        }

        // Passo 6: Login riuscito
        return new LoginResponse(true, "Login effettuato con successo.", utenteTrovato);
    }

    // Metodo simulato per rimpiazzare l'accesso al DB
    private Utente findByEmailSimulato(String email) {
        if ("visitatore1@test.com".equals(email)) {
            // Uso il costruttore (String nome, String email, String password) che hai definito
            Utente u = new Utente("Mario Rossi", email, "password123");
            u.setId(1); // Setto un ID fittizio
            return u;
        }
        return null;
    }
}
