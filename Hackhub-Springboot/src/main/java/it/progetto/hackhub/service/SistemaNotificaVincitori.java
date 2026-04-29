package it.progetto.hackhub.service;

import it.progetto.hackhub.model.IObserver;
import it.progetto.hackhub.model.Utente;
import it.progetto.hackhub.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.progetto.hackhub.model.Proclamazione;
import it.progetto.hackhub.model.Team;
import it.progetto.hackhub.repository.ProclamazioneRepository;
import java.util.List;

@Service
public class SistemaNotificaVincitori implements IObserver {

    private final NotificaService notificaService;
    private final TeamRepository teamRepository;
    private final ProclamazioneRepository proclamazioneRepository;

    @Autowired
    public SistemaNotificaVincitori(NotificaService notificaService, TeamRepository teamRepository, ProclamazioneRepository proclamazioneRepository) {
        this.notificaService = notificaService;
        this.teamRepository = teamRepository;
        this.proclamazioneRepository = proclamazioneRepository;
    }

    @Override
    public void update(String data) {
        int hackathonId = Integer.parseInt(data);

        System.out.println(
                "   [SISTEMA NOTIFICA] Hackathon #" + hackathonId + " concluso. Notifica ai vincitori in corso...");

        String msg = "CONGRATULAZIONI! Hai vinto l'Hackathon #" + hackathonId + "!";

        proclamazioneRepository.findAll().stream()
                .filter(p -> p.getHackathonId() == hackathonId)
                .findFirst()
                .ifPresent(proclamazione -> {
                    teamRepository.findById(proclamazione.getTeamId())
                            .ifPresent(team -> {
                                for (Utente membro : team.getMembri()) {
                                    notificaService.inviaNotifica(msg, membro.getId());
                                }
                            });
                });
    }
}
