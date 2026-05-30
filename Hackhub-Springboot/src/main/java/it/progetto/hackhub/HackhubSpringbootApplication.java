package it.progetto.hackhub;

import it.progetto.hackhub.model.Utente;
import it.progetto.hackhub.repository.UtenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HackhubSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackhubSpringbootApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UtenteRepository utenteRepo) {

        return args -> {
            if (utenteRepo.count() > 0) {
                System.out.println("\n--- DB già inizializzato, skip init data ---");
                return;
            }

            Utente u1  = utenteRepo.save(new Utente("Organizzatore", "org@test.it",         "password"));
            Utente u2  = utenteRepo.save(new Utente("Giudice",       "giudice@test.it",     "password"));
            Utente u3  = utenteRepo.save(new Utente("Mentore",       "mentore@test.it",     "password"));
            Utente u4  = utenteRepo.save(new Utente("Alice",         "alice@test.it",       "password"));
            Utente u5  = utenteRepo.save(new Utente("Bob",           "bob@test.it",         "password"));
            Utente u6  = utenteRepo.save(new Utente("Carlo",         "carlo@test.it",       "password"));
            Utente u7  = utenteRepo.save(new Utente("Diana",         "diana@test.it",       "password"));
            Utente u8  = utenteRepo.save(new Utente("Elena",         "elena@test.it",       "password"));
            Utente u9  = utenteRepo.save(new Utente("Francesco",     "francesco@test.it",   "password"));
            Utente u10 = utenteRepo.save(new Utente("Giulia",        "giulia@test.it",      "password"));

            System.out.println("\n--- Utenti creati ---");
            System.out.println("ID " + u1.getId()  + " → org@test.it       (Organizzatore)");
            System.out.println("ID " + u2.getId()  + " → giudice@test.it   (Giudice)");
            System.out.println("ID " + u3.getId()  + " → mentore@test.it   (Mentore)");
            System.out.println("ID " + u4.getId()  + " → alice@test.it");
            System.out.println("ID " + u5.getId()  + " → bob@test.it");
            System.out.println("ID " + u6.getId()  + " → carlo@test.it");
            System.out.println("ID " + u7.getId()  + " → diana@test.it");
            System.out.println("ID " + u8.getId()  + " → elena@test.it");
            System.out.println("ID " + u9.getId()  + " → francesco@test.it");
            System.out.println("ID " + u10.getId() + " → giulia@test.it");
            System.out.println("---------------------\n");
        };
    }
}
