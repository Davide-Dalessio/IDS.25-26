package it.progetto.hackhub;

import it.progetto.hackhub.controller.AutenticazioneController;
import it.progetto.hackhub.controller.HackathonController;
import it.progetto.hackhub.controller.TeamController;
import it.progetto.hackhub.dto.*;
import it.progetto.hackhub.model.Utente;
import it.progetto.hackhub.repository.UtenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class HackhubSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackhubSpringbootApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(
            UtenteRepository utenteRepo,
            HackathonController hackathonController,
            TeamController teamController) {

        return args -> {
            System.out.println("\n--- INIZIALIZZAZIONE DATI ---");

            // 1. Creazione 5 Utenti
            Utente u1 = utenteRepo.save(new Utente("Mario", "mario@test.it", "pass"));
            Utente u2 = utenteRepo.save(new Utente("Luca", "luca@test.it", "pass"));
            Utente u3 = utenteRepo.save(new Utente("Anna", "anna@test.it", "pass"));
            Utente u4 = utenteRepo.save(new Utente("Giulia", "giulia@test.it", "pass"));
            Utente u5 = utenteRepo.save(new Utente("Paolo", "paolo@test.it", "pass"));


            // 2. Creazione Hackathon
            HackathonRequest hackReq = new HackathonRequest(
                "Super Hack 2026", 
                LocalDate.now().plusDays(10), 
                LocalDate.now().plusDays(12), 
                1500.0, 
                u1.getId(),
                java.util.List.of(u2.getId()),
                java.util.List.of(u3.getId())
            );
            HackathonDTO hackRes = hackathonController.createHackathon(hackReq);


            // 3. Creazione Team
            TeamRequest teamReq = new TeamRequest("Team Alpha", u4.getId());
            teamController.createTeam(teamReq);

            System.out.println("--- INIZIALIZZAZIONE COMPLETATA ---\n");
        };
    }
}
