package it.progetto.hackhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Valutazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int valutazioneId;

    private int giudiceId;
    private int hackathonId;
    private int submissionId;
    private String commento;
    private int punteggio;

    public Valutazione(int giudiceId, int hackathonId, int submissionId, String commento, int punteggio) {
        this.giudiceId = giudiceId;
        this.hackathonId = hackathonId;
        this.submissionId = submissionId;
        this.commento = commento;
        this.punteggio = punteggio;
    }
}
