package it.progetto.hackhub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hackathon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hackathonId;

    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private double premio;
    private int organizzatoreID;

    @Enumerated(EnumType.STRING)
    private StatoHackathon stato;

    private int maxMembriTeam;

    @ManyToMany
    @JoinTable(name = "hackathon_mentori")
    private java.util.List<Utente> mentori = new java.util.ArrayList<>();

    @ManyToMany
    @JoinTable(name = "hackathon_giudici")
    private java.util.List<Utente> giudici = new java.util.ArrayList<>();

}
