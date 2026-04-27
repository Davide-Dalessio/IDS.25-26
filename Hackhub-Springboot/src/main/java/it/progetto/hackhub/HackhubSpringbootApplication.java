package it.progetto.hackhub;


import it.progetto.hackhub.controller.*;
import it.progetto.hackhub.dto.*;
import it.progetto.hackhub.model.*;
import it.progetto.hackhub.model.Utente;
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
            HackathonRepository hackathonRepo,
            TeamRepository teamRepo,
            it.progetto.hackhub.repository.PartecipazioneRepository partecipazioneRepo) {

        return args -> {
            System.out.println("\n--- SCENARIO DI TEST SOTTOMISSIONI ---");

            // 1. Utenti base
            Utente u1 = utenteRepo.save(new Utente("Mario", "mario@test.it", "pass"));
            
            // 2. Hackathon 1: IN_CORSO (Si può inviare)
            Hackathon hInCorso = new Hackathon();
            hInCorso.setNome("Hackathon Live");
            hInCorso.setStato(StatoHackathon.IN_CORSO);
            hInCorso.setMaxMembriTeam(5);
            hackathonRepo.save(hInCorso);

            // 3. Hackathon 2: IN_ISCRIZIONE (Invio bloccato)
            Hackathon hSoloIscrizioni = new Hackathon();
            hSoloIscrizioni.setNome("Hackathon Future");
            hSoloIscrizioni.setStato(StatoHackathon.IN_ISCRIZIONE);
            hSoloIscrizioni.setMaxMembriTeam(5);
            hackathonRepo.save(hSoloIscrizioni);

            // 4. Team ISCRITTO all'Hackathon 1
            Team teamIscritto = new Team();
            teamIscritto.setNome("Team Iscritto");
            teamIscritto.getMembri().add(u1);
            teamIscritto.setHackathon(hInCorso);
            teamRepo.save(teamIscritto);
            
            // Creiamo la partecipazione ufficiale
            partecipazioneRepo.save(new Partecipazione(teamIscritto, hInCorso));

            // 5. Team NON ISCRITTO
            Team teamEstraneo = new Team();
            teamEstraneo.setNome("Team Estraneo");
            teamEstraneo.getMembri().add(u1);
            teamRepo.save(teamEstraneo);

            System.out.println("Scenario caricato:");
            System.out.println("- Hackathon LIVE ID: " + hInCorso.getHackathonId());
            System.out.println("- Hackathon FUTURE ID: " + hSoloIscrizioni.getHackathonId());
            System.out.println("- Team ISCRITTO ID: " + teamIscritto.getTeamId() + " (Iscritto a " + hInCorso.getHackathonId() + ")");
            System.out.println("- Team ESTRANEO ID: " + teamEstraneo.getTeamId() + " (Nessuna iscrizione)");
            System.out.println("--------------------------------------\n");
        };
    }
}
