package it.progetto.hackhub;

import it.progetto.hackhub.model.*;
import it.progetto.hackhub.repository.*;
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
    public CommandLineRunner initData(
            UtenteRepository utenteRepo,
            HackathonRepository hackathonRepo,
            TeamRepository teamRepo,
            SottomissioneRepository sottomissioneRepo,
            PartecipazioneRepository partecipazioneRepo,
            RichiestaSupportoRepository richiestaSupportoRepo) {

        return args -> {
            if (utenteRepo.count() > 0) {
                System.out.println("\n--- DB già inizializzato, skip init data ---");
                return;
            }

            System.out.println("\n--- SCENARIO TEST VALUTAZIONE E ACCESSO SOTTOMISSIONI ---");

            Utente org = utenteRepo.save(new Utente("Organizzatore", "org@test.it", "password"));
            Utente giudice = utenteRepo.save(new Utente("Giudice Dredd", "giudice@test.it", "password"));
            Utente membro = utenteRepo.save(new Utente("Membro Team", "membro@test.it", "password"));
            Utente membro2 = utenteRepo.save(new Utente("Sviluppatore 2", "membro2@test.it", "password"));
            Utente mentore = utenteRepo.save(new Utente("Mentore Esperto", "mentore@test.it", "password"));
            
            Hackathon hack = new Hackathon();
            hack.setNome("Hackathon Valutato");
            hack.setOrganizzatoreID(org.getId());
            hack.setStato(StatoHackathon.IN_VALUTAZIONE);
            hack.getGiudici().add(giudice);
            hackathonRepo.save(hack);

            Team team = new Team();
            team.setNome("Team Da Valutare");
            team.getMembri().add(membro);
            teamRepo.save(team);

            partecipazioneRepo.save(new Partecipazione(team, hack));

            Sottomissione sottomissione = new Sottomissione(team, hack, "https://github.com/team/progetto");
            sottomissioneRepo.save(sottomissione);

            // SECONDO HACKATHON PER TEST SOTTOMISSIONE (IN_CORSO)
            Hackathon hackInCorso = new Hackathon();
            hackInCorso.setNome("Hackathon Attivo");
            hackInCorso.setOrganizzatoreID(org.getId());
            hackInCorso.setStato(StatoHackathon.IN_CORSO);
            hackathonRepo.save(hackInCorso);

            Team teamAttivo = new Team();
            teamAttivo.setNome("Team Sviluppatori");
            teamAttivo.getMembri().add(membro2);
            teamRepo.save(teamAttivo);

            partecipazioneRepo.save(new Partecipazione(teamAttivo, hackInCorso));

            hackInCorso.getMentori().add(mentore);
            hackathonRepo.save(hackInCorso);

            RichiestaSupporto richiesta1 = new RichiestaSupporto(teamAttivo.getTeamId(), hackInCorso.getHackathonId(), "Aiuto con l'integrazione API");
            richiesta1.setCategoria("Backend");
            richiesta1.setDisponibilita("Mattina / Pomeriggio");
            RichiestaSupporto richiesta2 = new RichiestaSupporto(teamAttivo.getTeamId(), hackInCorso.getHackathonId(), "Problema con schema relazionale");
            richiesta2.setCategoria("Database");
            richiesta2.setDisponibilita("Solo pomeriggio");
            richiestaSupportoRepo.save(richiesta1);
            richiestaSupportoRepo.save(richiesta2);

            // TERZO HACKATHON PER TEST ISCRIZIONE (IN_ISCRIZIONE)
            Hackathon hackIscrizione = new Hackathon();
            hackIscrizione.setNome("Hackathon Nuove Idee");
            hackIscrizione.setOrganizzatoreID(org.getId());
            hackIscrizione.setStato(StatoHackathon.IN_ISCRIZIONE);
            hackIscrizione.setDataInizio(java.time.LocalDate.now().plusDays(7));
            hackIscrizione.setDataFine(java.time.LocalDate.now().plusDays(10));
            hackIscrizione.setMaxMembriTeam(4);
            hackathonRepo.save(hackIscrizione);

            // UTENTI LIBERI PER TEST REGISTRAZIONE/INVITO
            Utente libero1 = utenteRepo.save(new Utente("Mario Rossi", "mario@test.it", "password"));
            Utente libero2 = utenteRepo.save(new Utente("Luigi Bianchi", "luigi@test.it", "password"));

            System.out.println("Dati pronti:");
            System.out.println("- ID Giudice: " + giudice.getId());
            System.out.println("- ID Hackathon Valutazione: " + hack.getHackathonId() + " (Stato: IN_VALUTAZIONE)");
            System.out.println("- ID Hackathon Attivo: " + hackInCorso.getHackathonId() + " (Stato: IN_CORSO)");
            System.out.println("- ID Hackathon Iscrizioni: " + hackIscrizione.getHackathonId() + " (Stato: IN_ISCRIZIONE)");
            System.out.println("- ID Team 1: " + team.getTeamId());
            System.out.println("- ID Team 2: " + teamAttivo.getTeamId());
            System.out.println("- ID Sottomissione Iniziale: " + sottomissione.getSottomissioneId());
            System.out.println("- ID Mentore: " + mentore.getId());
            System.out.println("- ID Richiesta 1: " + richiesta1.getId());
            System.out.println("- ID Richiesta 2: " + richiesta2.getId());
            System.out.println("- ID Utenti Liberi: " + libero1.getId() + ", " + libero2.getId());
            System.out.println("-----------------------------------------------------------\n");
        };
    }
}
