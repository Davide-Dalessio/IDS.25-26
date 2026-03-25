package it.progetto.view;

import it.progetto.controller.InvitoController;
import it.progetto.dto.InvitoDTO;
import it.progetto.model.Utente;

import java.util.List;

public class ICreazioneInvito {

    private InvitoController controller;

    public ICreazioneInvito() {
        this.controller = new InvitoController();
    }

    public void viewModulo() {
        System.out.println("Creazione Invito");
    }

    public void cercaUtente(String nome) {
        System.out.println("Ricerca: " + nome);
        List<Utente> risultati = controller.cercaUtente(nome);
        this.showListaUtenti(risultati);
    }

    public void showListaUtenti(List<Utente> lista) {
        System.out.println("Mostrando " + lista.size() + " risultati della ricerca:");
        for (Utente u : lista) {
            System.out.println(" - " + u.getNome() + " (ID: " + u.getId() + ")");
        }
    }

    public void sendDatiInvito(int utenteID, int mittenteID) {
        System.out.println("Invito a: " + utenteID);

        InvitoDTO risultato = controller.sendDatiInvito(utenteID, mittenteID);

        if (risultato != null) {
            showOK();
        } else {
            showError();
        }
    }

    public void showError() {
        System.out.println("Errore.");
    }

    public void showOK() {
        System.out.println("OK.");
    }

}
