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
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "hackathon_id")
    private Hackathon hackathon;

    private String stato;
    private LocalDate dataIscrizione;

    public Partecipazione(Team team, Hackathon hackathon) {
        this.team = team;
        this.hackathon = hackathon;
        this.stato = "ISCRITTO";
        this.dataIscrizione = LocalDate.now();
    }
}
