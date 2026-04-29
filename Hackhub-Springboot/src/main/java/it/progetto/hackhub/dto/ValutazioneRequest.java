package it.progetto.hackhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValutazioneRequest {
    private int giudiceId;
    private int hackathonId;
    private int submissionId;
    private String commento;
    private int punteggio;
}
