package it.progetto.hackhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProclamazioneRequest {
    private int organizzatoreId;
    private int hackathonId;
    private int teamId;
}
