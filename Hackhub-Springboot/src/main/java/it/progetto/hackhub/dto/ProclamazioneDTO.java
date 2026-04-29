package it.progetto.hackhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProclamazioneDTO {
    private int hackathonId;
    private int teamId;
    private boolean pagamentoEseguito;
    private String messaggio;
}
