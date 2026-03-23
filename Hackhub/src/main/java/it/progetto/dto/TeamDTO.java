package it.progetto.dto;

import java.util.List;

public class TeamDTO {
    private final int id;
    private final String nome;
    private final List<Integer> membriIDs;

    public TeamDTO(int id, String nome, List<Integer> membriIDs) {
        this.id = id;
        this.nome = nome;
        this.membriIDs = membriIDs;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Integer> getMembriIDs() {
        return membriIDs;
    }
}
