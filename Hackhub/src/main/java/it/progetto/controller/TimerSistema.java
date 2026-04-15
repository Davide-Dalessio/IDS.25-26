package it.progetto.controller;

import java.time.LocalDate;

public class TimerSistema {

    private HackathonController hackathonController;

    public TimerSistema() {
        this.hackathonController = new HackathonController();
    }

    public void runTask() {
        System.out.println("--- [CRON-JOB AVVIATO] " + LocalDate.now() + " ---");
        System.out.println("TimerSistema: Lancio comando di aggiornamento ciclico delle fasi.");
        
        hackathonController.aggiornaFasi();
        
        System.out.println("--- [CRON-JOB TERMINATO] ---");
    }
}
