package it.progetto.model;

import java.util.ArrayList;
import java.util.List;

public class Utente implements IObserver {
    private int id;
    private String nome;
    private String email;
    private List<String> bachecaNotifiche = new ArrayList<>();

    public Utente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public void update(String messaggio) {
        this.bachecaNotifiche.add(messaggio);
        System.out.println("   [OBSERVER - BACHECA DI " + this.nome.toUpperCase() + "] Nuova notifica ricevuta: " + messaggio);
    }
}
