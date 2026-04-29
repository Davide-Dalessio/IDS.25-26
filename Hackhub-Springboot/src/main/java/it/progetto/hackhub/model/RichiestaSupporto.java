package it.progetto.hackhub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class RichiestaSupporto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int teamId;
    private int hackathonId;
    private String msg;
    private String stato;

    private String categoria;
    private LocalDate data;
    private String disponibilita;
    private String storico;

    public RichiestaSupporto(int teamId, int hackathonId, String msg) {
        this.teamId = teamId;
        this.hackathonId = hackathonId;
        this.msg = msg;
        this.stato = "Aperta";
        this.data = LocalDate.now();
        this.categoria = "Non specificata";
        this.disponibilita = "Non specificata";
        this.storico = "Nessuno storico";
    }
}
