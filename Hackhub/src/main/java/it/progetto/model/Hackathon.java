package it.progetto.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hackathon {
    private int hackathonId;
    private String nome;
    private LocalDate dataInizio, dataFine;
    private double premio;
    private int organizzatoreID;
    private StatoHackathon stato;
    private int maxMembriTeam;
    private EventManager events = new EventManager();

    public Hackathon() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public void setOrganizzatoreID(int organizzatoreID) {
        this.organizzatoreID = organizzatoreID;
    }

    public void setStato(StatoHackathon stato) {
        this.stato = stato;

        if (stato == StatoHackathon.IN_CORSO) {
            events.notify("cambio_fase", "L'Hackathon '" + this.nome + "' e' appena INIZIATO (fase IN CORSO)!");
        } else if (stato == StatoHackathon.IN_VALUTAZIONE) {
            events.notify("cambio_fase",
                    "Stop ai lavori! L'Hackathon '" + this.nome + "' e' ora in fase di VALUTAZIONE!");
        } else if (stato == StatoHackathon.CONCLUSO) {
            events.notify("HACKATHON_CONCLUSO", String.valueOf(this.hackathonId));
        }
    }

    public void setHackathonId(int hackathonId) {
        this.hackathonId = hackathonId;
    }

    public int getHackathonId() {
        return this.hackathonId;
    }

    public void setMaxMembriTeam(int maxMembriTeam) {
        this.maxMembriTeam = maxMembriTeam;
    }

    public String getNome() {
        return this.nome;
    }

    public LocalDate getDataInizio() {
        return this.dataInizio;
    }

    public LocalDate getDataFine() {
        return this.dataFine;
    }

    public double getPremio() {
        return this.premio;
    }

    public int getOrganizzatoreID() {
        return this.organizzatoreID;
    }

    public StatoHackathon getStato() {
        return this.stato;
    }

    public int getMaxMembriTeam() {
        return this.maxMembriTeam;
    }

    public EventManager getEvents() {
        return this.events;
    }

    public void notificaMentori(int hackathonId) {
        events.notify("nuova_richiesta", "Nuova richiesta di supporto per l'hackathon " + hackathonId);
    }
}
