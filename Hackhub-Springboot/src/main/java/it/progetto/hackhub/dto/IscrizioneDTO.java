package it.progetto.hackhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IscrizioneDTO {
    private int teamId;
    private int hackathonId;
    private String stato;
    private LocalDate dataIscrizione;
}
