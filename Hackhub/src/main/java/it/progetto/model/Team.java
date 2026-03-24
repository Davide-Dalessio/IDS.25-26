package it.progetto.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private String nome;
    private List<Utente> membri;

    public Team() {
        this.membri = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Utente> getMembri() {
        return membri;
    }

    public void aggiungiMembro(Utente utente) {
        if (!this.membri.contains(utente)) {
            this.membri.add(utente);
        }
    }
}