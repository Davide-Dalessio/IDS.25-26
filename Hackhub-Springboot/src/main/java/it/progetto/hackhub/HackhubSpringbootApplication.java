package it.progetto.hackhub;

import it.progetto.hackhub.controller.*;
import it.progetto.hackhub.dto.*;
import it.progetto.hackhub.model.*;
import it.progetto.hackhub.repository.*;
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
            TeamRepository teamRepo,
            InvitoRepository invitoRepo) {

        return args -> {
            System.out.println("\n--- SCENARIO DI TEST INVITI E RISPOSTE ---");

            // 1. Creazione Utenti
            Utente u1 = utenteRepo.save(new Utente("User Uno", "user1@test.it", "password"));
            Utente u2 = utenteRepo.save(new Utente("User Due", "user2@test.it", "password"));

            // 2. Creazione Team Alpha (Utente 1 è membro)
            Team teamAlpha = new Team();
            teamAlpha.setNome("Team Alpha");
            teamAlpha.getMembri().add(u1);
            teamRepo.save(teamAlpha);

            // 3. Creazione Invito (Utente 1 invita Utente 2)
            Invito invito = invitoRepo.save(new Invito(u1.getId(), u2.getId()));

            System.out.println("Configurazione completata:");
            System.out.println("- Utente 1 (Mittente) ID: " + u1.getId());
            System.out.println("- Utente 2 (Invitato) ID: " + u2.getId());
            System.out.println("- Team Alpha ID: " + teamAlpha.getTeamId());
            System.out.println("- Invito Pendente ID: " + invito.getId());
            System.out.println("------------------------------------------\n");
        };
    }
}
