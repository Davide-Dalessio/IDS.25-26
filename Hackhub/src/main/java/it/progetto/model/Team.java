package it.progetto.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private int id;
    private String nome;
    private List<Integer> membriIDs;

    public Team() {
        this.membriIDs = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Integer> getMembriIDs() { return membriIDs; }

    public void aggiungiMembro(int utenteID) {
        if (!this.membriIDs.contains(utenteID)) {
            this.membriIDs.add(utenteID);
        }
    }
}