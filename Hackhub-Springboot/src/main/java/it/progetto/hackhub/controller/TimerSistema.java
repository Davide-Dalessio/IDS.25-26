package it.progetto.hackhub.controller;

import it.progetto.hackhub.service.HackathonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TimerSistema {

    @Autowired
    private HackathonService hackathonService;

    @Scheduled(cron = "0 0 0 * * *")
    public void runTask() {
        System.out.println("--- [CRON-JOB AVVIATO] " + LocalDate.now() + " ---");
        System.out.println("TimerSistema: Lancio comando di aggiornamento ciclico delle fasi.");

        hackathonService.aggiornaFasi();

        System.out.println("--- [CRON-JOB TERMINATO] ---");
    }
}
