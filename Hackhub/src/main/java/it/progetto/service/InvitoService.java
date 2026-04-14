package it.progetto.service;

import it.progetto.dto.InvitoRequest;
import it.progetto.dto.InvitoDTO;
import it.progetto.model.Invito;
import it.progetto.model.InvitoBuilder;
import it.progetto.model.ConcreteInvitoBuilder;
import it.progetto.model.Utente;

import java.util.ArrayList;
import java.util.List;

public class InvitoService {

    public List<Utente> eseguiRicerca(String nome) {
        List<Utente> lista = new ArrayList<>();
        lista.add(new Utente(2, nome, nome.toLowerCase() + "@mail.com"));
        return lista;
    }

    public InvitoDTO requestInvito(InvitoRequest request) {
        boolean valido = checkUtente(request.getUtenteID());

        if (!valido) {
            throw new RuntimeException("Utente gia in team");
        }

        InvitoBuilder builder = new ConcreteInvitoBuilder();
        builder.reset();
        builder.setMittente(request.getMittenteID());
        builder.setUtenteInvitato(request.getUtenteID());

        Invito invito = builder.getResult();

        this.save(invito);

        this.sendInvito(invito);

        return new InvitoDTO(invito.getMittenteID(), invito.getUtenteID());
    }

    private boolean checkUtente(int utenteID) {
        return utenteID != 999;
    }

    private void save(Invito invito) {
        System.out.println("Salvataggio Invito nel DB");
    }

    private void sendInvito(Invito invito) {
        System.out.println("Invito inviato");
    }
}
