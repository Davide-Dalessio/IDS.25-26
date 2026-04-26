package it.progetto.hackhub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;

    private String nome;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "team_membri",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "utente_id")
    )
    private List<Utente> membri = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "hackathon_id")
    private Hackathon hackathon;

    public void aggiungiMembro(Utente utente) {
        if (this.membri == null) {
            this.membri = new ArrayList<>();
        }
        if (!this.membri.contains(utente)) {
            this.membri.add(utente);
        }
    }
}
