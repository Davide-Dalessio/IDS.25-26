package it.progetto.hackhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValutazioneDTO {
    private int valutazioneId;
    private int submissionId;
    private int giudiceId;
    private String commento;
    private int punteggio;
    private String messaggio;
}
