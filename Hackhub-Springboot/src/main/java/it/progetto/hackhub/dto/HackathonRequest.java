package it.progetto.hackhub.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HackathonRequest {
    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private double premio;
    private int organizzatoreID;
    private int maxMembriTeam;
    private java.util.List<Integer> mentoriIds;
    private java.util.List<Integer> giudiciIds;
}
