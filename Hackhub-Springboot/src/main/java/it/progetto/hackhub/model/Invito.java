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
public class Invito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int mittenteID;
    private int utenteID;

    public Invito(int mittenteID, int utenteID) {
        this.mittenteID = mittenteID;
        this.utenteID = utenteID;
    }
}
