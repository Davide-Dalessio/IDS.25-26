package it.progetto.dto;

import java.util.List;
import it.progetto.model.Utente;

public class TeamDTO {
    private final int id;
    private final String nome;
    private final List<Utente> membri;

    public TeamDTO(int id, String nome, List<Utente> membri) {
        this.id = id;
        this.nome = nome;
        this.membri = membri;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Utente> getMembri() {
        return membri;
    }
}
