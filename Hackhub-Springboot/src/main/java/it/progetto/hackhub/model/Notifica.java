package it.progetto.hackhub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notifica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String messaggio;
    private int utenteId; // L'utente che riceve la notifica
    private LocalDateTime dataInvio;
    private boolean letta;

    public Notifica(String messaggio, int utenteId) {
        this.messaggio = messaggio;
        this.utenteId = utenteId;
        this.dataInvio = LocalDateTime.now();
        this.letta = false;
    }
}
