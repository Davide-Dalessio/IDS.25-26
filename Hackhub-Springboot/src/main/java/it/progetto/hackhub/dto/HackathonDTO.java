package it.progetto.hackhub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HackathonDTO {
    private int hackathonId;
    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private double premio;
    private int organizzatoreID;
}
