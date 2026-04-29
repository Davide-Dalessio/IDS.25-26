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
public class Proclamazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int organizzatoreId;
    private int hackathonId;
    private int teamId;
    private boolean pagamentoEseguito;

    public Proclamazione(int organizzatoreId, int hackathonId, int teamId) {
        this.organizzatoreId = organizzatoreId;
        this.hackathonId = hackathonId;
        this.teamId = teamId;
        this.pagamentoEseguito = false;
    }
}
